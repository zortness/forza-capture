package net.kopfhaus.forza.io;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.kopfhaus.forza.dto.Fm7DataPacket;

import javax.annotation.PostConstruct;
import java.io.FileOutputStream;
import java.net.InetAddress;

@RequiredArgsConstructor
@Slf4j
public class IncomingPacketHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private final FileOutputStream outputFile;
    private final String format;
    private final String delimiter;

    private final ChannelState state = new ChannelState();

    @PostConstruct
    public void init() throws Exception {
        log.debug("Initializing packet handler");
        if (format.equals("CSV")) {
            outputFile.write(Fm7DataPacket.headerToString(delimiter).getBytes());
            outputFile.write("\n".getBytes());
            outputFile.flush();
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket packet) throws Exception {
        final InetAddress srcAddr = packet.sender().getAddress();
        final ByteBuf buf = packet.content();
        final int rcvPktLength = buf.readableBytes();
        final byte[] rcvPktBuf = new byte[rcvPktLength];
        buf.readBytes(rcvPktBuf);

        synchronized (state) {
            state.totalPackets++;
            if (state.totalPackets % 100 == 0) {
                log.debug("Got packet from {} of size {}", srcAddr, rcvPktLength);
            }
        }

        Fm7DataPacket dataPacket = Fm7DataPacket.fromBytes(rcvPktBuf);

        if (dataPacket.getIsRaceOn() == 0) {
            synchronized (state) {
                state.discardedPackets++;
                if (state.discardedPackets % 100 == 0) {
                    log.debug("Discarding data, not racing");
                }
                state.racing = false;
            }
        } else {
            boolean optimize = true;
            synchronized(state) {
                state.keptPackets++;
                if (state.keptPackets % 100 == 0) {
                    log.info("Getting Race Data");
                }
                if (!state.racing) {
                    state.racing = true;
                    optimize = false;
                }
            }

            if (format.equals("CSV")) {
                outputFile.write(dataPacket.toString(delimiter, optimize).getBytes());
                outputFile.write("\n".getBytes());
                outputFile.flush();
            }
        }

    }

    /**
     * Used to make this thread safe
     */
    @Data
    private static class ChannelState {
        private long totalPackets = 0;
        private long discardedPackets = 0;
        private long keptPackets = 0;
        private boolean racing = false;
    }
}

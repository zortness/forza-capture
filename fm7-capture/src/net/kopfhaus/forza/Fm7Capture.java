package net.kopfhaus.forza;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.kopfhaus.forza.io.IncomingPacketHandler;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;

@RequiredArgsConstructor
@Slf4j
public class Fm7Capture {

    private static final String DEFAULT_PORT = "7788";
    private static final String DEFAULT_DIR = ".";
    private static final String DEFAULT_FILENAME = "out.csv";
    private static final String DEFAULT_FORMAT = "CSV";
    private static final String DEFAULT_DELIMITER = ",";

    public static void main(String [] args) throws Exception {
        log.info("Starting...");

        Options options = new Options()
                .addOption(new Option("p", "port", true, "UDP port to listen on [default 7788]"))
                .addOption(new Option("o", "outfile", true, "output file and path [default ./out.csv]"))
                .addOption(new Option("f", "format", true, "format to output (CSV, BIN) [default CSV]"))
                .addOption(new Option("d", "delimiter", true, "CSV delimiter to use [default ,]"));

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Fm7Capture", options);
            System.exit(1);
        }

        Fm7Capture me = new Fm7Capture(
                Integer.parseInt(cmd.getOptionValue('p', DEFAULT_PORT)),
                cmd.getOptionValue('o', DEFAULT_DIR + File.separator + DEFAULT_FILENAME),
                cmd.getOptionValue('f', DEFAULT_FORMAT),
                cmd.getOptionValue('d', DEFAULT_DELIMITER));
        me.run();
    }

    private final int port;
    private final String outputFileName;
    private final String format;
    private final String delimiter;

    public void run() throws Exception {

        final NioEventLoopGroup group = new NioEventLoopGroup();
        log.info("Creating output file: {}", outputFileName);
        final FileOutputStream outputStream = new FileOutputStream(
                new File(outputFileName));
        try {
            final Bootstrap b = new Bootstrap();
            b.group(group).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChannelInitializer<NioDatagramChannel>() {
                        @Override
                        public void initChannel(final NioDatagramChannel ch) throws Exception {
                            log.debug("Initializing Channel");
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(
                                    new IncomingPacketHandler(outputStream, format, delimiter));
                        }
                    });

            // Bind and start to accept incoming connections.
            Integer pPort = port;
            InetAddress address  = InetAddress.getLocalHost();
            log.info("waiting for messages on {}:{}",address.toString(), pPort.toString());
            b.bind(address, port).sync().channel().closeFuture().await();

        } finally {
            log.debug("In Server Finally");
            group.shutdownGracefully();
            outputStream.close();
        }
    }



}

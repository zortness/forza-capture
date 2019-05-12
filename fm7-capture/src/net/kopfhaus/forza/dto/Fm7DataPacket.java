package net.kopfhaus.forza.dto;

import lombok.Builder;
import lombok.Data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@Data @Builder
public class Fm7DataPacket {

    private int isRaceOn; // = 1 when race is on. = 0 when in menus/race stopped …

    private int timestampMS; //Can overflow to 0 eventually

    private float engineMaxRpm;
    private float engineIdleRpm;
    private float currentEngineRpm;

    private float accelerationX; //In the car's local space; X = right, Y = up, Z = forward
    private float accelerationY;
    private float accelerationZ;

    private float velocityX; //In the car's local space; X = right, Y = up, Z = forward
    private float velocityY;
    private float velocityZ;

    private float angularVelocityX; //In the car's local space; X = pitch, Y = yaw, Z = roll
    private float angularVelocityY;
    private float angularVelocityZ;

    private float yaw;
    private float pitch;
    private float roll;

    private float normalizedSuspensionTravelFrontLeft; // Suspension travel normalized: 0.0f = max stretch; 1.0 = max compression
    private float normalizedSuspensionTravelFrontRight;
    private float normalizedSuspensionTravelRearLeft;
    private float normalizedSuspensionTravelRearRight;

    private float tireSlipRatioFrontLeft; // Tire normalized slip ratio, = 0 means 100% grip and |ratio| > 1.0 means loss of grip.
    private float tireSlipRatioFrontRight;
    private float tireSlipRatioRearLeft;
    private float tireSlipRatioRearRight;

    private float wheelRotationSpeedFrontLeft; // Wheel rotation speed radians/sec.
    private float wheelRotationSpeedFrontRight;
    private float wheelRotationSpeedRearLeft;
    private float wheelRotationSpeedRearRight;

    private int wheelOnRumbleStripFrontLeft; // = 1 when wheel is on rumble strip, = 0 when off.
    private int wheelOnRumbleStripFrontRight;
    private int wheelOnRumbleStripRearLeft;
    private int wheelOnRumbleStripRearRight;

    private float wheelInPuddleDepthFrontLeft; // = from 0 to 1, where 1 is the deepest puddle
    private float wheelInPuddleDepthFrontRight;
    private float wheelInPuddleDepthRearLeft;
    private float wheelInPuddleDepthRearRight;

    private float surfaceRumbleFrontLeft; // Non-dimensional surface rumble values passed to controller force feedback
    private float surfaceRumbleFrontRight;
    private float surfaceRumbleRearLeft;
    private float surfaceRumbleRearRight;

    private float tireSlipAngleFrontLeft; // Tire normalized slip angle, = 0 means 100% grip and |angle| > 1.0 means loss of grip.
    private float tireSlipAngleFrontRight;
    private float tireSlipAngleRearLeft;
    private float tireSlipAngleRearRight;

    private float tireCombinedSlipFrontLeft; // Tire normalized combined slip, = 0 means 100% grip and |slip| > 1.0 means loss of grip.
    private float tireCombinedSlipFrontRight;
    private float tireCombinedSlipRearLeft;
    private float tireCombinedSlipRearRight;

    private float suspensionTravelMetersFrontLeft; // Actual suspension travel in meters
    private float suspensionTravelMetersFrontRight;
    private float suspensionTravelMetersRearLeft;
    private float suspensionTravelMetersRearRight;

    private int carOrdinal; //Unique ID of the car make/model
    private int carClass; //Between 0 (D -- worst cars) and 7 (X class -- best cars) inclusive
    private int carPerformanceIndex; //Between 100 (slowest car) and 999 (fastest car) inclusive
    private int drivetrainType; //Corresponds to EDrivetrainType; 0 = FWD, 1 = RWD, 2 = AWD
    private int numCylinders; //Number of cylinders in the engine

    //Position (meters)
    private float positionX;
    private float positionY;
    private float positionZ;

    private float speed; // meters per second
    private float power; // watts
    private float torque; // newton meter

    private float tireTempFrontLeft;
    private float tireTempFrontRight;
    private float tireTempRearLeft;
    private float tireTempRearRight;

    private float boost;
    private float fuel;
    private float distanceTraveled;
    private float bestLap;
    private float lastLap;
    private float currentLap;
    private float currentRaceTime;

    private int lapNumber;
    private int racePosition;

    private int accel;
    private int brake;
    private int clutch;
    private int handBrake;
    private int gear;
    private int steer;

    private int normalizedDrivingLine;
    private int normalizedAIBrakeDifference;


    public String toString(String separator, boolean optimize) {
        return "" + (optimize? "" : isRaceOn) + separator +
                timestampMS + separator +

                (optimize? "" : engineMaxRpm) + separator +
                (optimize? "" : engineIdleRpm) + separator +
                currentEngineRpm + separator +

                accelerationX + separator +
                accelerationY + separator +
                accelerationZ + separator +

                velocityX + separator +
                velocityY + separator +
                velocityZ + separator +

                angularVelocityX + separator +
                angularVelocityY + separator +
                angularVelocityZ + separator +

                yaw + separator +
                pitch + separator +
                roll + separator +

                normalizedSuspensionTravelFrontLeft + separator +
                normalizedSuspensionTravelFrontRight + separator +
                normalizedSuspensionTravelRearLeft + separator +
                normalizedSuspensionTravelRearRight + separator +

                tireSlipRatioFrontLeft + separator +
                tireSlipRatioFrontRight + separator +
                tireSlipRatioRearLeft + separator +
                tireSlipRatioRearRight + separator +

                wheelRotationSpeedFrontLeft + separator +
                wheelRotationSpeedFrontRight + separator +
                wheelRotationSpeedRearLeft + separator +
                wheelRotationSpeedRearRight + separator +

                wheelOnRumbleStripFrontLeft + separator +
                wheelOnRumbleStripFrontRight + separator +
                wheelOnRumbleStripRearLeft + separator +
                wheelOnRumbleStripRearRight + separator +

                wheelInPuddleDepthFrontLeft + separator +
                wheelInPuddleDepthFrontRight + separator +
                wheelInPuddleDepthRearLeft + separator +
                wheelInPuddleDepthRearRight + separator +

                surfaceRumbleFrontLeft + separator +
                surfaceRumbleFrontRight + separator +
                surfaceRumbleRearLeft + separator +
                surfaceRumbleRearRight + separator +

                tireSlipAngleFrontLeft + separator +
                tireSlipAngleFrontRight + separator +
                tireSlipAngleRearLeft + separator +
                tireSlipAngleRearRight + separator +

                tireCombinedSlipFrontLeft + separator +
                tireCombinedSlipFrontRight + separator +
                tireCombinedSlipRearLeft + separator +
                tireCombinedSlipRearRight + separator +

                suspensionTravelMetersFrontLeft + separator +
                suspensionTravelMetersFrontRight + separator +
                suspensionTravelMetersRearLeft + separator +
                suspensionTravelMetersRearRight + separator +

                (optimize? "" : carOrdinal)  + separator +
                (optimize? "" : carClass) + separator +
                (optimize? "" : carPerformanceIndex) + separator +
                (optimize? "" : drivetrainType) + separator +
                (optimize? "" : numCylinders) + separator +

                positionX + separator +
                positionY + separator +
                positionZ + separator +

                speed + separator +
                power + separator +
                torque + separator +

                tireTempFrontLeft + separator +
                tireTempFrontRight + separator +
                tireTempRearLeft + separator +
                tireTempRearRight + separator +

                boost + separator +
                fuel + separator +
                distanceTraveled + separator +
                bestLap + separator +
                lastLap + separator +
                currentLap + separator +
                currentRaceTime + separator +

                lapNumber + separator +
                racePosition + separator +

                accel + separator +
                brake + separator +
                clutch + separator +
                handBrake + separator +
                gear + separator +
                steer + separator +
                normalizedDrivingLine + separator +
                normalizedAIBrakeDifference;
    }

    public static String headerToString(String separator) {
        return "isRaceOn" + separator +
                "timestampMS" + separator +

                "engineMaxRpm" + separator +
                "engineIdleRpm" + separator +
                "currentEngineRpm" + separator +

                "accelerationX" + separator +
                "accelerationY" + separator +
                "accelerationZ" + separator +

                "velocityX" + separator +
                "velocityY" + separator +
                "velocityZ" + separator +

                "angularVelocityX" + separator +
                "angularVelocityY" + separator +
                "angularVelocityZ" + separator +

                "yaw" + separator +
                "pitch" + separator +
                "roll" + separator +

                "normalizedSuspensionTravelFrontLeft" + separator +
                "normalizedSuspensionTravelFrontRight" + separator +
                "normalizedSuspensionTravelRearLeft" + separator +
                "normalizedSuspensionTravelRearRight" + separator +

                "tireSlipRatioFrontLeft" + separator +
                "tireSlipRatioFrontRight" + separator +
                "tireSlipRatioRearLeft" + separator +
                "tireSlipRatioRearRight" + separator +

                "wheelRotationSpeedFrontLeft" + separator +
                "wheelRotationSpeedFrontRight" + separator +
                "wheelRotationSpeedRearLeft" + separator +
                "wheelRotationSpeedRearRight" + separator +

                "wheelOnRumbleStripFrontLeft" + separator +
                "wheelOnRumbleStripFrontRight" + separator +
                "wheelOnRumbleStripRearLeft" + separator +
                "wheelOnRumbleStripRearRight" + separator +

                "wheelInPuddleDepthFrontLeft" + separator +
                "wheelInPuddleDepthFrontRight" + separator +
                "wheelInPuddleDepthRearLeft" + separator +
                "wheelInPuddleDepthRearRight" + separator +

                "surfaceRumbleFrontLeft" + separator +
                "surfaceRumbleFrontRight" + separator +
                "surfaceRumbleRearLeft" + separator +
                "surfaceRumbleRearRight" + separator +

                "tireSlipAngleFrontLeft" + separator +
                "tireSlipAngleFrontRight" + separator +
                "tireSlipAngleRearLeft" + separator +
                "tireSlipAngleRearRight" + separator +

                "tireCombinedSlipFrontLeft" + separator +
                "tireCombinedSlipFrontRight" + separator +
                "tireCombinedSlipRearLeft" + separator +
                "tireCombinedSlipRearRight" + separator +

                "suspensionTravelMetersFrontLeft" + separator +
                "suspensionTravelMetersFrontRight" + separator +
                "suspensionTravelMetersRearLeft" + separator +
                "suspensionTravelMetersRearRight" + separator +

                "carOrdinal" + separator +
                "carClass" + separator +
                "carPerformanceIndex" + separator +
                "drivetrainType" + separator +
                "numCylinders" + separator +

                "positionX" + separator +
                "positionY" + separator +
                "positionZ" + separator +

                "speed" + separator +
                "power" + separator +
                "torque" + separator +

                "tireTempFrontLeft" + separator +
                "tireTempFrontRight" + separator +
                "tireTempRearLeft" + separator +
                "tireTempRearRight" + separator +

                "boost" + separator +
                "fuel" + separator +
                "distanceTraveled" + separator +
                "bestLap" + separator +
                "lastLap" + separator +
                "currentLap" + separator +
                "currentRaceTime" + separator +

                "lapNumber" + separator +
                "racePosition" + separator +

                "accel" + separator +
                "brake" + separator +
                "clutch" + separator +
                "handBrake" + separator +
                "gear" + separator +
                "steer" + separator +
                "normalizedDrivingLine" + separator +
                "normalizedAIBrakeDifference";
    }

    public static Fm7DataPacket fromBytes(byte[] data) {

        /**
         0000   -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
         0010   -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
         0020   -- -- -- -- -- -- -- -- -- -- 01 00 00 00 b3 ca
         0030   3a 48 fb cf 04 46 f8 ff 47 44 93 7d a4 45 2c a8
         0040   22 3e a2 d8 1d 3f be b9 41 40 00 9d 89 3c 00 95
         0050   96 bb 4d 7c 03 42 11 38 09 bd 52 3e ea 3a 63 6e
         0060   f8 bc 87 c7 40 c0 10 51 0b bd 62 18 f6 bc 32 60
         0070   bb 3e 24 1b a2 3e 93 a0 e2 3e 8f 5f e6 3e 3e 2d
         0080   4b bb 83 97 62 bb 29 39 c1 3d 67 66 b0 3d 18 61
         0090   ca 42 07 5a ca 42 60 c3 be 42 57 84 be 42 00 00
         00a0   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
         00b0   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
         00c0   00 00 00 00 00 00 00 00 00 00 00 00 00 00 45 ec
         00d0   02 bb cc 1f 39 bb 98 04 5c 3c 8a 37 6e bc a2 b4
         00e0   71 3b d1 4c 92 3b b5 2b c3 3d 47 e5 b2 3d 48 49
         00f0   a7 3b 00 1a 5a 3a 94 cc fe 3b a4 a1 0a 3c 09 0b
         0100   00 00 06 00 00 00 82 03 00 00 01 00 00 00 08 00
         0110   00 00 3b aa 83 c3 63 3c 8d 41 41 54 65 c4 4f 7c
         0120   03 42 2a cc 1d 48 61 78 92 43 5c 3c f7 42 da 6c
         0130   f7 42 a2 79 06 43 a2 79 06 43 86 bf 97 41 00 00
         0140   80 3f e9 69 1e 43 00 00 00 00 00 00 00 00 7e e7
         0150   50 41 68 45 78 41 00 00 01 87 00 00 00 03 00 11
         0160   00


         s32 IsRaceOn; // = 1 when race is on. = 0 when in menus/race stopped …

         u32 TimestampMS; //Can overflow to 0 eventually

         f32 EngineMaxRpm;
         f32 EngineIdleRpm;
         f32 CurrentEngineRpm;

         f32 AccelerationX; //In the car's local space; X = right, Y = up, Z = forward
         f32 AccelerationY;
         f32 AccelerationZ;

         f32 VelocityX; //In the car's local space; X = right, Y = up, Z = forward
         f32 VelocityY;
         f32 VelocityZ;

         f32 AngularVelocityX; //In the car's local space; X = pitch, Y = yaw, Z = roll
         f32 AngularVelocityY;
         f32 AngularVelocityZ;

         f32 Yaw;
         f32 Pitch;
         f32 Roll;

         f32 NormalizedSuspensionTravelFrontLeft; // Suspension travel normalized: 0.0f = max stretch; 1.0 = max compression
         f32 NormalizedSuspensionTravelFrontRight;
         f32 NormalizedSuspensionTravelRearLeft;
         f32 NormalizedSuspensionTravelRearRight;

         f32 TireSlipRatioFrontLeft; // Tire normalized slip ratio, = 0 means 100% grip and |ratio| > 1.0 means loss of grip.
         f32 TireSlipRatioFrontRight;
         f32 TireSlipRatioRearLeft;
         f32 TireSlipRatioRearRight;

         f32 WheelRotationSpeedFrontLeft; // Wheel rotation speed radians/sec.
         f32 WheelRotationSpeedFrontRight;
         f32 WheelRotationSpeedRearLeft;
         f32 WheelRotationSpeedRearRight;

         s32 WheelOnRumbleStripFrontLeft; // = 1 when wheel is on rumble strip, = 0 when off.
         s32 WheelOnRumbleStripFrontRight;
         s32 WheelOnRumbleStripRearLeft;
         s32 WheelOnRumbleStripRearRight;

         f32 WheelInPuddleDepthFrontLeft; // = from 0 to 1, where 1 is the deepest puddle
         f32 WheelInPuddleDepthFrontRight;
         f32 WheelInPuddleDepthRearLeft;
         f32 WheelInPuddleDepthRearRight;

         f32 SurfaceRumbleFrontLeft; // Non-dimensional surface rumble values passed to controller force feedback
         f32 SurfaceRumbleFrontRight;
         f32 SurfaceRumbleRearLeft;
         f32 SurfaceRumbleRearRight;

         f32 TireSlipAngleFrontLeft; // Tire normalized slip angle, = 0 means 100% grip and |angle| > 1.0 means loss of grip.
         f32 TireSlipAngleFrontRight;
         f32 TireSlipAngleRearLeft;
         f32 TireSlipAngleRearRight;

         f32 TireCombinedSlipFrontLeft; // Tire normalized combined slip, = 0 means 100% grip and |slip| > 1.0 means loss of grip.
         f32 TireCombinedSlipFrontRight;
         f32 TireCombinedSlipRearLeft;
         f32 TireCombinedSlipRearRight;

         f32 SuspensionTravelMetersFrontLeft; // Actual suspension travel in meters
         f32 SuspensionTravelMetersFrontRight;
         f32 SuspensionTravelMetersRearLeft;
         f32 SuspensionTravelMetersRearRight;

         s32 CarOrdinal; //Unique ID of the car make/model
         s32 CarClass; //Between 0 (D -- worst cars) and 7 (X class -- best cars) inclusive
         s32 CarPerformanceIndex; //Between 100 (slowest car) and 999 (fastest car) inclusive
         s32 DrivetrainType; //Corresponds to EDrivetrainType; 0 = FWD, 1 = RWD, 2 = AWD
         s32 NumCylinders; //Number of cylinders in the engine

         [Sept. 10, 2018 UPDATE: NEW DATA OUT STRUCTURE]

         V1 is now called Sled
         V2 is V1 then these added in this order at the bottom.
         //Position (meters)
         f32 PositionX;
         f32 PositionY;
         f32 PositionZ;

         f32 Speed; // meters per second
         f32 Power; // watts
         f32 Torque; // newton meter

         f32 TireTempFrontLeft;
         f32 TireTempFrontRight;
         f32 TireTempRearLeft;
         f32 TireTempRearRight;

         f32 Boost;
         f32 Fuel;
         f32 DistanceTraveled;
         f32 BestLap;
         f32 LastLap;
         f32 CurrentLap;
         f32 CurrentRaceTime;

         u16 LapNumber;
         u8 RacePosition;

         u8 Accel;
         u8 Brake;
         u8 Clutch;
         u8 HandBrake;
         u8 Gear;
         s8 Steer;

         s8 NormalizedDrivingLine;
         s8 NormalizedAIBrakeDifference;
         */

        // data is in Little Endian format for some reason
        ByteBuffer buffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);

        Fm7DataPacketBuilder builder = Fm7DataPacket.builder()
                .isRaceOn(buffer.getInt())
                .timestampMS(buffer.getInt())

                .engineMaxRpm(buffer.getFloat())
                .engineIdleRpm(buffer.getFloat())
                .currentEngineRpm(buffer.getFloat())

                .accelerationX(buffer.getFloat())
                .accelerationY(buffer.getFloat())
                .accelerationZ(buffer.getFloat())

                .velocityX(buffer.getFloat())
                .velocityY(buffer.getFloat())
                .velocityZ(buffer.getFloat())

                .angularVelocityX(buffer.getFloat())
                .angularVelocityY(buffer.getFloat())
                .angularVelocityZ(buffer.getFloat())

                .yaw(buffer.getFloat())
                .pitch(buffer.getFloat())
                .roll(buffer.getFloat())

                .normalizedSuspensionTravelFrontLeft(buffer.getFloat())
                .normalizedSuspensionTravelFrontRight(buffer.getFloat())
                .normalizedSuspensionTravelRearLeft(buffer.getFloat())
                .normalizedSuspensionTravelRearRight(buffer.getFloat())

                .tireSlipRatioFrontLeft(buffer.getFloat())
                .tireSlipRatioFrontRight(buffer.getFloat())
                .tireSlipRatioRearLeft(buffer.getFloat())
                .tireSlipRatioRearRight(buffer.getFloat())

                .wheelRotationSpeedFrontLeft(buffer.getFloat())
                .wheelRotationSpeedFrontRight(buffer.getFloat())
                .wheelRotationSpeedRearLeft(buffer.getFloat())
                .wheelRotationSpeedRearRight(buffer.getFloat())

                .wheelOnRumbleStripFrontLeft(buffer.getInt())
                .wheelOnRumbleStripFrontRight(buffer.getInt())
                .wheelOnRumbleStripRearLeft(buffer.getInt())
                .wheelOnRumbleStripRearRight(buffer.getInt())

                .wheelInPuddleDepthFrontLeft(buffer.getFloat())
                .wheelInPuddleDepthFrontRight(buffer.getFloat())
                .wheelInPuddleDepthRearLeft(buffer.getFloat())
                .wheelInPuddleDepthRearRight(buffer.getFloat())

                .surfaceRumbleFrontLeft(buffer.getFloat())
                .surfaceRumbleFrontRight(buffer.getFloat())
                .surfaceRumbleRearLeft(buffer.getFloat())
                .surfaceRumbleRearRight(buffer.getFloat())

                .tireSlipAngleFrontLeft(buffer.getFloat())
                .tireSlipAngleFrontRight(buffer.getFloat())
                .tireSlipAngleRearLeft(buffer.getFloat())
                .tireSlipAngleRearRight(buffer.getFloat())

                .tireCombinedSlipFrontLeft(buffer.getFloat())
                .tireCombinedSlipFrontRight(buffer.getFloat())
                .tireCombinedSlipRearLeft(buffer.getFloat())
                .tireCombinedSlipRearRight(buffer.getFloat())

                .suspensionTravelMetersFrontLeft(buffer.getFloat())
                .suspensionTravelMetersFrontRight(buffer.getFloat())
                .suspensionTravelMetersRearLeft(buffer.getFloat())
                .suspensionTravelMetersRearRight(buffer.getFloat())

                .carOrdinal(buffer.getInt())
                .carClass(buffer.getInt())
                .carPerformanceIndex(buffer.getInt())
                .drivetrainType(buffer.getInt())
                .numCylinders(buffer.getInt());

        if (data.length == 311) {
            // additional v2 data
            builder
                    .positionX(buffer.getFloat())
                    .positionY(buffer.getFloat())
                    .positionZ(buffer.getFloat())

                    .speed(buffer.getFloat())
                    .power(buffer.getFloat())
                    .torque(buffer.getFloat())

                    .tireTempFrontLeft(buffer.getFloat())
                    .tireTempFrontRight(buffer.getFloat())
                    .tireTempRearLeft(buffer.getFloat())
                    .tireTempRearRight(buffer.getFloat())

                    .boost(buffer.getFloat())
                    .fuel(buffer.getFloat())
                    .distanceTraveled(buffer.getFloat())
                    .bestLap(buffer.getFloat())
                    .lastLap(buffer.getFloat())
                    .currentLap(buffer.getFloat())
                    .currentRaceTime(buffer.getFloat())

                    .lapNumber(buffer.getShort()) // u16
                    .racePosition(Byte.toUnsignedInt(buffer.get())) // u8 (single byte)

                    .accel(Byte.toUnsignedInt(buffer.get()))
                    .brake(Byte.toUnsignedInt(buffer.get()))
                    .clutch(Byte.toUnsignedInt(buffer.get()))
                    .handBrake(Byte.toUnsignedInt(buffer.get()))
                    .gear(Byte.toUnsignedInt(buffer.get()))
                    .steer(buffer.get()) // s8

                    .normalizedDrivingLine(buffer.get())
                    .normalizedAIBrakeDifference(buffer.get());
        }

        return builder.build();
    }

}

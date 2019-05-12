CREATE TABLE `data` (

	`id` BIGINT NOT NULL AUTO_INCREMENT,

	`isRaceOn` SMALLINT NULL DEFAULT NULL,
	`timestampMS` BIGINT NOT NULL,

	`engineMaxRpm` FLOAT NULL DEFAULT NULL,
	`engineIdleRpm` FLOAT NULL DEFAULT NULL,
	`currentEngineRpm` FLOAT NULL,

	`accelerationX` FLOAT NULL,
	`accelerationY` FLOAT NULL,
	`accelerationZ` FLOAT NULL,

	`velocityX` FLOAT NULL,
	`velocityY` FLOAT NULL,
	`velocityZ` FLOAT NULL,

	`angularVelocityX` FLOAT NULL,
	`angularVelocityY` FLOAT NULL,
	`angularVelocityZ` FLOAT NULL,

	`yaw` FLOAT NULL,
	`pitch` FLOAT NULL,
	`roll` FLOAT NULL,

	`normalizedSuspensionTravelFrontLeft` FLOAT NULL,
	`normalizedSuspensionTravelFrontRight` FLOAT NULL,
	`normalizedSuspensionTravelRearLeft` FLOAT NULL,
	`normalizedSuspensionTravelRearRight` FLOAT NULL,

	`tireSlipRatioFrontLeft` FLOAT NULL,
	`tireSlipRatioFrontRight` FLOAT NULL,
	`tireSlipRatioRearLeft` FLOAT NULL,
	`tireSlipRatioRearRight` FLOAT NULL,

	`wheelRotationSpeedFrontLeft` FLOAT NULL,
	`wheelRotationSpeedFrontRight` FLOAT NULL,
	`wheelRotationSpeedRearLeft` FLOAT NULL,
	`wheelRotationSpeedRearRight` FLOAT NULL,

	`wheelOnRumbleStripFrontLeft` SMALLINT NULL,
	`wheelOnRumbleStripFrontRight` SMALLINT NULL,
	`wheelOnRumbleStripRearLeft` SMALLINT NULL,
	`wheelOnRumbleStripRearRight` SMALLINT NULL,

	`wheelInPuddleDepthFrontLeft` FLOAT NULL,
	`wheelInPuddleDepthFrontRight` FLOAT NULL,
	`wheelInPuddleDepthRearLeft` FLOAT NULL,
	`wheelInPuddleDepthRearRight` FLOAT NULL,

	`surfaceRumbleFrontLeft` FLOAT NULL,
	`surfaceRumbleFrontRight` FLOAT NULL,
	`surfaceRumbleRearLeft` FLOAT NULL,
	`surfaceRumbleRearRight` FLOAT NULL,

	`tireSlipAngleFrontLeft` FLOAT NULL,
	`tireSlipAngleFrontRight` FLOAT NULL,
	`tireSlipAngleRearLeft` FLOAT NULL,
	`tireSlipAngleRearRight` FLOAT NULL,

	`tireCombinedSlipFrontLeft` FLOAT NULL,
	`tireCombinedSlipFrontRight` FLOAT NULL,
	`tireCombinedSlipRearLeft` FLOAT NULL,
	`tireCombinedSlipRearRight` FLOAT NULL,

	`suspensionTravelMetersFrontLeft` FLOAT NULL,
	`suspensionTravelMetersFrontRight` FLOAT NULL,
	`suspensionTravelMetersRearLeft` FLOAT NULL,
	`suspensionTravelMetersRearRight` FLOAT NULL,

	`carOrdinal` INT NULL DEFAULT NULL,
	`carClass` INT NULL DEFAULT NULL,
	`carPerformanceIndex` INT NULL DEFAULT NULL,
	`drivetrainType` INT NULL DEFAULT NULL,
	`numCylinders` INT NULL DEFAULT NULL,

	`positionX` FLOAT NULL,
	`positionY` FLOAT NULL,
	`positionZ` FLOAT NULL,

	`speed` FLOAT NULL,
	`power` FLOAT NULL,
	`torque` FLOAT NULL,

	`tireTempFrontLeft` FLOAT NULL,
	`tireTempFrontRight` FLOAT NULL,
	`tireTempRearLeft` FLOAT NULL,
	`tireTempRearRight` FLOAT NULL,

	`boost` FLOAT NULL,
	`fuel` FLOAT NULL,
	`distanceTraveled` FLOAT NULL,
	`bestLap` FLOAT NULL,
	`lastLap` FLOAT NULL,
	`currentLap` FLOAT NULL,
	`currentRaceTime` FLOAT NULL,

	`lapNumber` SMALLINT NULL,
	`racePosition` SMALLINT NULL,

	`accel` SMALLINT NULL,
	`brake` SMALLINT NULL,
	`clutch` SMALLINT NULL,
	`handBrake` SMALLINT NULL,
	`gear` SMALLINT NULL,
	`steer` SMALLINT NULL,
	`normalizedDrivingLine` SMALLINT NULL,
	`normalizedAIBrakeDifferenceS` SMALLINT NULL,
	
	PRIMARY KEY(`id`),
	INDEX `idx_time` (`timestampMS`)

);
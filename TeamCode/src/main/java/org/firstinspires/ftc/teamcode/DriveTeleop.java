package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "DriveTeleop")
public class DriveTeleop extends CommandOpMode {

    private DrivebaseSubsystem drivebaseSubsystem;
    private GamepadEx gamepad_1;

    @Override
    public void initialize() {

        drivebaseSubsystem = new DrivebaseSubsystem(hardwareMap);

        gamepad_1 = new GamepadEx(gamepad1);

        DrivebaseCommand drivebaseCommand = new DrivebaseCommand(drivebaseSubsystem, gamepad_1::getLeftY, gamepad_1::getRightX);

        register(drivebaseSubsystem);
        CommandScheduler.getInstance().setDefaultCommand(drivebaseSubsystem, drivebaseCommand);
    }

    @Override
    public void run() {
        CommandScheduler.getInstance().run();
    }
}

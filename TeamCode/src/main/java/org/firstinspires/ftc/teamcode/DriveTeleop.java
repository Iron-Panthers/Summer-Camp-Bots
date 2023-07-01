package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "DriveTeleop")
public class DriveTeleop extends CommandOpMode {

    private DrivebaseSubsystem drivebaseSubsystem;
    private GamepadEx gamepad_1;

    @Override
    public void initialize() {

        String macAddress = MacUtil.macToString(MacUtil.getMacAddress());

        drivebaseSubsystem = new DrivebaseSubsystem(hardwareMap, macAddress);

        gamepad_1 = new GamepadEx(gamepad1);

        DrivebaseCommand drivebaseCommand;


        switch (macAddress) {
            case Constants.FTC_VLQB:
            case Constants.SevenThreeOneSix_RC:
            case Constants.SevenThreeOneSix_a_RC:
                drivebaseCommand= new DrivebaseCommand(drivebaseSubsystem, gamepad_1::getLeftX, gamepad_1::getRightX);
                break;
            default:
                drivebaseCommand= new DrivebaseCommand(drivebaseSubsystem, gamepad_1::getLeftX, gamepad_1::getRightY);


        }






        register(drivebaseSubsystem);
        CommandScheduler.getInstance().setDefaultCommand(drivebaseSubsystem, drivebaseCommand);
    }

    @Override
    public void run() {

        CommandScheduler.getInstance().run();
    }
}

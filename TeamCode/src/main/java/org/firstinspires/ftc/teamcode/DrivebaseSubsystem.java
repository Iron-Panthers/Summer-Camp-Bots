package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DrivebaseSubsystem extends SubsystemBase {

    private FtcDashboard dashboard = FtcDashboard.getInstance();
    private Telemetry dashboardTelemetry = dashboard.getTelemetry();
    String macAddress;
    double rotation, velocity;

    MotorEx lMotor, rMotor;

    DifferentialDrive differentialDrive;

    //innerwheels expansionhub - autoinvert true, 0.75*rightY,
    //
    //
    //

    public DrivebaseSubsystem(HardwareMap hMap, String macAddress) {
        this.macAddress = macAddress;

        rotation = 0;
        velocity = 0;

        lMotor = new MotorEx(hMap, "lMotor");
        rMotor = new MotorEx(hMap, "rMotor");

        differentialDrive = new DifferentialDrive(true, lMotor, rMotor);
    }

    public void drive(double rotation, double velocity) {
        this.rotation = rotation;
        this.velocity = velocity;
    }

    @Override
    public void periodic() {


        dashboardTelemetry.addData("address", macAddress);
        String id ="No known bot";
        dashboardTelemetry.addData("velocity", velocity);
        dashboardTelemetry.addData("rotation", rotation);



        switch (macAddress) {
            case Constants.FTC_VLQB:
                id = "FTC_VLQB";
                differentialDrive.arcadeDrive(-velocity, -rotation * 0.75, true);
                break;
            case Constants.SevenThreeOneSix_RC:
                id = "7316-RC";
                // For some reason, this one is flipped oof
                differentialDrive.arcadeDrive(rotation * 0.75, velocity, true);
                break;
            case Constants.SevenThreeOneSix_a_RC:
                id = "7316-a-RC";
                differentialDrive.arcadeDrive(-velocity, rotation * 0.75, true);
                break;
            default:
                differentialDrive.arcadeDrive(-velocity, rotation * 0.75, true);


        }
        dashboardTelemetry.addData("Bot", id);
        dashboardTelemetry.update();
    }
}

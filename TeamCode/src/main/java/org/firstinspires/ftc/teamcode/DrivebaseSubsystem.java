package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DrivebaseSubsystem extends SubsystemBase {

    double leftY, rightX;

    MotorEx lMotor, rMotor;

    DifferentialDrive differentialDrive;

    //innerwheels expansionhub - autoinvert true, 0.75*rightX,
    //
    //
    //

    public DrivebaseSubsystem(HardwareMap hMap) {
        leftY = 0;
        rightX = 0;

        lMotor = new MotorEx(hMap, "lMotor");
        rMotor = new MotorEx(hMap, "rMotor");

        differentialDrive = new DifferentialDrive(true, lMotor, rMotor);
    }

    public void drive(double leftY, double rightX) {
        this.leftY = leftY;
        this.rightX = rightX;
    }

    @Override
    public void periodic() {
        differentialDrive.arcadeDrive(leftY, rightX*0.75, true);
    }
}

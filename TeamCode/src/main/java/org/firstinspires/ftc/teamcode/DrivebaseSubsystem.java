package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.function.DoubleSupplier;

public class DrivebaseSubsystem extends SubsystemBase {

    DoubleSupplier leftY, rightX;

    MotorEx lMotor, rMotor;

    DifferentialDrive differentialDrive;

    public DrivebaseSubsystem(HardwareMap hMap) {

        lMotor = new MotorEx(hMap, "lMotor");
        rMotor = new MotorEx(hMap, "rMotor");

        differentialDrive = new DifferentialDrive(lMotor, rMotor);
    }

    public void drive(DoubleSupplier leftY, DoubleSupplier rightX) {
        this.leftY = leftY;
        this.rightX = rightX;
    }

    @Override
    public void periodic() {
        differentialDrive.arcadeDrive(leftY.getAsDouble(), rightX.getAsDouble(), true);
    }
}

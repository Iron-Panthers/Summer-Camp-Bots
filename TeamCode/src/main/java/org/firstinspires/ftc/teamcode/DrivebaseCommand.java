package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

import java.util.function.DoubleSupplier;

public class DrivebaseCommand extends CommandBase {

    DrivebaseSubsystem drivebaseSubsystem;

    DoubleSupplier leftY, rightX;

    public DrivebaseCommand(DrivebaseSubsystem drivebaseSubsystem, DoubleSupplier leftY, DoubleSupplier rightX) {

        this.drivebaseSubsystem = drivebaseSubsystem;

        this.leftY = leftY;
        this.rightX = rightX;

        addRequirements(drivebaseSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        drivebaseSubsystem.drive(leftY.getAsDouble(), rightX.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

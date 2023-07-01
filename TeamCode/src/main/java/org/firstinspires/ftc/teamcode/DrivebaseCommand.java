package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

import java.util.function.DoubleSupplier;

public class DrivebaseCommand extends CommandBase {

    DrivebaseSubsystem drivebaseSubsystem;

    DoubleSupplier rotSupplier, velocitySupplier;

    public DrivebaseCommand(DrivebaseSubsystem drivebaseSubsystem, DoubleSupplier rotSupplier, DoubleSupplier velocitySupplier) {



        this.drivebaseSubsystem = drivebaseSubsystem;

        this.rotSupplier = rotSupplier;
        this.velocitySupplier = velocitySupplier;

        addRequirements(drivebaseSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (rotSupplier == null || velocitySupplier == null) return;
        drivebaseSubsystem.drive(rotSupplier.getAsDouble(), velocitySupplier.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

package org.firstinspires.ftc.teamcode.Hand;

import com.arcrobotics.ftclib.command.CommandBase;

public class CommandHandDown extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final HandSubsystem c_subsystem;
    public CommandHandDown(HandSubsystem subsystem) {
        c_subsystem = subsystem;
        addRequirements(c_subsystem);
    }
    @Override
    public void initialize() {
        c_subsystem.HandDown();
    }


    @Override
    public boolean isFinished() {
        return true;
    }
}

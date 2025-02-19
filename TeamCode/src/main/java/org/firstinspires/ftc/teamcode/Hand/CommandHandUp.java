package org.firstinspires.ftc.teamcode.Hand;

import com.arcrobotics.ftclib.command.CommandBase;

public class CommandHandUp extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final HandSubsystem c_subsystem;
    public CommandHandUp(HandSubsystem subsystem) {
        c_subsystem = subsystem;
        addRequirements(c_subsystem);
    }
    @Override
    public void initialize() {
        c_subsystem.HandUp();
    }


    @Override
    public boolean isFinished() {
        return true;
    }
}

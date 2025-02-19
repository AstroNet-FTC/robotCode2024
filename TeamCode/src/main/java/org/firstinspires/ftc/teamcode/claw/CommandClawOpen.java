package org.firstinspires.ftc.teamcode.claw;

import com.arcrobotics.ftclib.command.CommandBase;

public class CommandClawOpen extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final SubSystemClaw c_subsystem;
    public CommandClawOpen(SubSystemClaw subsystem) {
        c_subsystem = subsystem;
        addRequirements(c_subsystem);
    }
    @Override
    public void initialize() {
        c_subsystem.ClawOpen();
    }


    @Override
    public boolean isFinished() {
        return true;
    }
}

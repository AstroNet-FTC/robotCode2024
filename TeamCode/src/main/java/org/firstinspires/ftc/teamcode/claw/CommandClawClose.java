package org.firstinspires.ftc.teamcode.claw;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.SubsystemBase;

public class CommandClawClose extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final SubSystemClaw c_subsystem;
    public CommandClawClose(SubSystemClaw subsystem) {
        c_subsystem = subsystem;
        addRequirements(c_subsystem);
    }
    @Override
    public void initialize() {
        c_subsystem.ClawClose();
    }
}

package org.firstinspires.ftc.teamcode.Elevator;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.claw.SubSystemClaw;

public class ResetElevatorCommand extends CommandBase {
    private final ElevatorSubsystem subsystem;

    public ResetElevatorCommand (ElevatorSubsystem Elevator){
        subsystem = Elevator;

    }
    @Override
    public void execute(){
        subsystem.reset();
    }
}

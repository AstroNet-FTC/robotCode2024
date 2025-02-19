package org.firstinspires.ftc.teamcode.Elevator;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Elevator.ElevatorSubsystem;
import org.firstinspires.ftc.teamcode.Globals;

public class CommandElevator extends CommandBase {

    private final ElevatorSubsystem subsystem;
    private double wanted;
    public CommandElevator (ElevatorSubsystem Subsystem,double Wanted)  {
        subsystem = Subsystem;
        wanted = Wanted;

    }

    @Override
    public void initialize(){
        subsystem.getPidController().setSetPoint(wanted - Globals.ElvevatorOffset);
    }
    @Override
    public void execute(){
        subsystem.setPower(subsystem.getPidController().calculate(subsystem.getTicks()));
    }
    @Override
    public boolean isFinished(){
        return subsystem.getPidController().atSetPoint();
    }
    @Override
    public void end(boolean interupted){
        subsystem.setPower(0);
    }


}

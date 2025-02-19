package org.firstinspires.ftc.teamcode.Elevator;


import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Globals;

public class DefaultElevator extends CommandBase {
    private double ElevatorPower;
    private ElevatorSubsystem subsystem;
    public DefaultElevator(ElevatorSubsystem elevator){
        subsystem = elevator;
        addRequirements(elevator);
        if (!Globals.ManualElevator){
            switch(Globals.elevatorState){
                case INTAKE:
                    ElevatorPower = 0;
                    break;
                case CLOSED:
                    ElevatorPower = 0;
                    break;
                case LOWBASKET:
                    ElevatorPower = 0.2;
                    break;
                case HIGHBASKET:
                    ElevatorPower = 0.25;
                    break;
            }
        }
    }
    @Override
   public void execute(){
        subsystem.setPower(ElevatorPower);
    }

}

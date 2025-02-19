package org.firstinspires.ftc.teamcode.defaultReset;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Arm.ArmCommand;
import org.firstinspires.ftc.teamcode.Arm.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Elevator.CommandElevator;
import org.firstinspires.ftc.teamcode.Elevator.ElevatorState;
import org.firstinspires.ftc.teamcode.Elevator.ElevatorSubsystem;
import org.firstinspires.ftc.teamcode.Globals;
import org.firstinspires.ftc.teamcode.Hand.CommandHandDown;
import org.firstinspires.ftc.teamcode.Hand.CommandHandUp;
import org.firstinspires.ftc.teamcode.Hand.HandSubsystem;

public class defaultStart extends SequentialCommandGroup {
    private static final double defStartArmWanted = -300;
    private static final double defStartElevatorWanted = 0;

            public defaultStart (ArmSubsystem Arm, ElevatorSubsystem Elevator, HandSubsystem Hand){
            addCommands(
                    new ArmCommand(Arm, defStartArmWanted),
                    new CommandElevator(Elevator, defStartElevatorWanted),
                    new CommandHandDown(Hand));
                Globals.elevatorState = ElevatorState.CLOSED;
                Globals.ArmUp = false;
            }


}

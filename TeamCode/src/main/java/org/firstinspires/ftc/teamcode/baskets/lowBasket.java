package org.firstinspires.ftc.teamcode.baskets;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Arm.ArmCommand;
import org.firstinspires.ftc.teamcode.Arm.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Elevator.CommandElevator;
import org.firstinspires.ftc.teamcode.Elevator.ElevatorState;
import org.firstinspires.ftc.teamcode.Elevator.ElevatorSubsystem;
import org.firstinspires.ftc.teamcode.Globals;
import org.firstinspires.ftc.teamcode.Hand.CommandHandUp;
import org.firstinspires.ftc.teamcode.Hand.HandSubsystem;

public class lowBasket extends SequentialCommandGroup {
    private static final double ArmWanted = -2140;
    private static final double ElevatorWanted = -1450;


    public lowBasket (ArmSubsystem Arm, ElevatorSubsystem Elevator, HandSubsystem Hand){
        addCommands(new ArmCommand(Arm, ArmWanted),
                new CommandElevator(Elevator, ElevatorWanted),
                new CommandHandUp(Hand));
        Globals.elevatorState = ElevatorState.LOWBASKET;
        Globals.ArmUp = true;
        }
    }

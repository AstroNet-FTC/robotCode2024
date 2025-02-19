package org.firstinspires.ftc.teamcode.pickup;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Arm.ArmCommand;
import org.firstinspires.ftc.teamcode.Arm.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Elevator.CommandElevator;
import org.firstinspires.ftc.teamcode.Elevator.ElevatorSubsystem;
import org.firstinspires.ftc.teamcode.Hand.CommandHandDown;
import org.firstinspires.ftc.teamcode.Hand.CommandHandUp;
import org.firstinspires.ftc.teamcode.Hand.HandSubsystem;
import org.firstinspires.ftc.teamcode.claw.CommandClawClose;
import org.firstinspires.ftc.teamcode.claw.CommandClawOpen;
import org.firstinspires.ftc.teamcode.claw.SubSystemClaw;

public class pickup extends SequentialCommandGroup {
    private static final double pickupArmWanted = -240;
    private static final double pickupElevatorWanted = -1750;

    public pickup (ArmSubsystem Arm, ElevatorSubsystem Elevator, HandSubsystem Hand) {
        addCommands(
                new ArmCommand(Arm, pickupArmWanted),
                new CommandElevator(Elevator, pickupElevatorWanted),
                new CommandHandDown(Hand));

    }
}

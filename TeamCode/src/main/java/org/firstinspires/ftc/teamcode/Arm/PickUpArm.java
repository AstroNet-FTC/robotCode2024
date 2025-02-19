package org.firstinspires.ftc.teamcode.Arm;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Globals;

public class PickUpArm extends SequentialCommandGroup {
    private static final double ArmUpWanted = -300;
    public PickUpArm (ArmSubsystem Arm){
        addCommands(
                new ArmCommand(Arm, ArmUpWanted));
        Globals.ArmUp = true;
    }
}

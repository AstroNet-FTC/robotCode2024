package org.firstinspires.ftc.teamcode.Arm;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Globals;

public class ArmDown extends SequentialCommandGroup {
    private static final double ArmDownWanted = 30;

    public ArmDown (ArmSubsystem Arm){
        addCommands(
                new ArmCommand(Arm, ArmDownWanted));
                Globals.ArmUp = false;
    }
}

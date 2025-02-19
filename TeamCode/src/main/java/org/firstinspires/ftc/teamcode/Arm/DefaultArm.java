package org.firstinspires.ftc.teamcode.Arm;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Elevator.ElevatorSubsystem;
import org.firstinspires.ftc.teamcode.Globals;
import org.firstinspires.ftc.teamcode.old_code.Arm;

public class DefaultArm extends CommandBase {
    private double ArmPower;
    private ArmSubsystem subsystem;
    public DefaultArm(ArmSubsystem Arm) {
        subsystem = Arm;
        addRequirements(Arm);
        if (Globals.ArmUp){
            ArmPower = -0.05;
        }
        else {
            ArmPower = -0.05;
        }
    }
    @Override
    public void execute(){
        subsystem.setPower(ArmPower);
    }
}



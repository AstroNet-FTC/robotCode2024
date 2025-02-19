package org.firstinspires.ftc.teamcode.Elevator;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Globals;

public class CommandManualElevator extends CommandBase {
    private ElevatorSubsystem subsystem;
    private GamepadEx gamepad;

    public CommandManualElevator(ElevatorSubsystem Elevator, GamepadEx Gamepad){
        subsystem = Elevator;
        gamepad = Gamepad;
        addRequirements(Elevator);
    }


    @Override
    public void execute() {
        subsystem.setPower(gamepad.getRightY());
        if (gamepad.getRightY() != 0){
            Globals.ManualElevator = true;
        } else {
            Globals.ManualElevator = false;
        }
    }
}

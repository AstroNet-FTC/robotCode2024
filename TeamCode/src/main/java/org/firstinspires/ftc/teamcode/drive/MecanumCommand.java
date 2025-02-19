package org.firstinspires.ftc.teamcode.drive;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;



public class MecanumCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private Mecanum com_mecanum;
    private GamepadEx gamepad;


    public MecanumCommand(Mecanum mecanum, GamepadEx Gamepad) {
        com_mecanum = mecanum;
        addRequirements(com_mecanum);
        gamepad = Gamepad;
    }

    @Override
    public void execute() {
        double x = gamepad.getLeftX() * 1.1;
        double y = -gamepad.getLeftY();
        double turn = gamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) - gamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);

        com_mecanum.arcadeDrive(x, y, turn);
    }
}
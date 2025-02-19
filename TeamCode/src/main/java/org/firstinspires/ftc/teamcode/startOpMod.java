package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Arm.ArmDown;
import org.firstinspires.ftc.teamcode.Arm.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Arm.DefaultArm;
import org.firstinspires.ftc.teamcode.Arm.PickUpArm;
import org.firstinspires.ftc.teamcode.Elevator.CommandManualElevator;
import org.firstinspires.ftc.teamcode.Elevator.DefaultElevator;
import org.firstinspires.ftc.teamcode.Elevator.ElevatorSubsystem;
import org.firstinspires.ftc.teamcode.Elevator.ResetElevatorCommand;
import org.firstinspires.ftc.teamcode.Hand.CommandHandDown;
import org.firstinspires.ftc.teamcode.Hand.CommandHandUp;
import org.firstinspires.ftc.teamcode.Hand.HandSubsystem;
import org.firstinspires.ftc.teamcode.baskets.lowBasket;
import org.firstinspires.ftc.teamcode.claw.CommandClawClose;
import org.firstinspires.ftc.teamcode.claw.CommandClawOpen;
import org.firstinspires.ftc.teamcode.claw.SubSystemClaw;
import org.firstinspires.ftc.teamcode.defaultReset.defaultStart;
import org.firstinspires.ftc.teamcode.drive.Mecanum;
import org.firstinspires.ftc.teamcode.drive.MecanumCommand;
import org.firstinspires.ftc.teamcode.pickup.pickup;

@TeleOp
public class startOpMod extends CommandOpMode {
    public GamepadEx gamepad;
    private SubSystemClaw claw;
    private ElevatorSubsystem elevator;
    private ArmSubsystem arm;
    private HandSubsystem hand;

    private Mecanum mecanum;


    @Override
    public void initialize() {
        gamepad = new GamepadEx(gamepad1);

        claw = new SubSystemClaw(hardwareMap);
        elevator = new ElevatorSubsystem(hardwareMap);
        arm = new ArmSubsystem(hardwareMap);
        hand = new HandSubsystem(hardwareMap);
        mecanum = new Mecanum(hardwareMap);


        gamepad.getGamepadButton(GamepadKeys.Button.A)
                .toggleWhenPressed(new CommandClawOpen(claw),new CommandClawClose(claw));
        gamepad.getGamepadButton(GamepadKeys.Button.B)
                .toggleWhenPressed(new CommandHandUp(hand),new CommandHandDown(hand));
        mecanum.setDefaultCommand(new MecanumCommand(
                mecanum,
                gamepad
        ));
        elevator.setDefaultCommand(new DefaultElevator(elevator));
        arm.setDefaultCommand(new DefaultArm(arm));
        elevator.setDefaultCommand(new CommandManualElevator(elevator, gamepad));
        gamepad.getGamepadButton(GamepadKeys.Button.DPAD_UP)
                .whenPressed(new lowBasket(arm, elevator, hand));
        gamepad.getGamepadButton(GamepadKeys.Button.X)
                .whenPressed(new pickup(arm, elevator, hand));
        gamepad.getGamepadButton(GamepadKeys.Button.START)
                .whenPressed(new defaultStart(arm, elevator, hand));
        gamepad.getGamepadButton(GamepadKeys.Button.DPAD_DOWN)
                .whenPressed(new ArmDown(arm));
        gamepad.getGamepadButton(GamepadKeys.Button.DPAD_LEFT)
                .whenPressed(new PickUpArm(arm));
        gamepad.getGamepadButton(GamepadKeys.Button.BACK)
                .whenPressed(new ResetElevatorCommand(elevator));

}
@Override
    public void run(){
        super.run();
}

}

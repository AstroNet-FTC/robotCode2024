//package org.firstinspires.ftc.teamcode;
//
//import com.arcrobotics.ftclib.command.CommandOpMode;
//import com.arcrobotics.ftclib.gamepad.GamepadEx;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//
//import org.firstinspires.ftc.teamcode.Arm.ArmCommand;
//import org.firstinspires.ftc.teamcode.Arm.ArmSubsystem;
//import org.firstinspires.ftc.teamcode.Elevator.ElevatorSubsystem;
//import org.firstinspires.ftc.teamcode.Hand.HandSubsystem;
//import org.firstinspires.ftc.teamcode.claw.SubSystemClaw;
//import org.firstinspires.ftc.teamcode.drive.AutoCommand;
//import org.firstinspires.ftc.teamcode.drive.Mecanum;
//
//
//@Autonomous
//public class Autonomus extends CommandOpMode {
//
//
//    public GamepadEx gamepad;
//    private SubSystemClaw claw;
//    private ElevatorSubsystem elevator;
//    private ArmSubsystem arm;
//    private HandSubsystem hand;
//
//    private Mecanum mecanum;
//    private double[] FirstTicks = {3000,3000,3000,3000};
//    private double[] FirstPower = {0.1,0.1,0.1,0.1};
//
//    @Override
//    public void initialize() {
//        super.schedule(new AutoCommand(mecanum, FirstTicks,FirstPower));
//    }
//    @Override
//    public void run(){
//        //new ArmCommand(arm, 2140);
//        super.run();
//
//    }
//}

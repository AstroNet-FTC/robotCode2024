package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class telmetry extends LinearOpMode {

    private DcMotor Elevator;
    private DcMotor Arm;
    private Servo servoRight;
    private Servo servoLeft;
    private DcMotor frontLeftDrive;
    private DcMotor frontRightDrive;
    private DcMotor backRightDrive;
    private DcMotor backLeftDrive;
    double servoPos = 0;
    boolean lastPress= false;
    boolean lastPress2= false;

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.addData("code", " updated");
        telemetry.update();

        Elevator = hardwareMap.get(DcMotor.class,"ElevatorMotor");
        Arm = hardwareMap.get(DcMotor.class,"ArmMotor");
        frontLeftDrive  = hardwareMap.get(DcMotor.class, "front left");
        frontRightDrive = hardwareMap.get(DcMotor.class, "front right");
        backLeftDrive = hardwareMap.get(DcMotor.class, "back left");
        backRightDrive = hardwareMap.get(DcMotor.class, "back right");
        waitForStart();
        while (opModeIsActive()){
            telemetry.addData("x",gamepad1.x);
            telemetry.addData("a",gamepad1.a);
            telemetry.addData("Arm", Arm.getCurrentPosition());
            telemetry.addData("Elevator", Elevator.getCurrentPosition());
            telemetry.addData("servoPos", servoPos);
            telemetry.update();
        }




    }





}

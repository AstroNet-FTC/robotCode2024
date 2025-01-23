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

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        Elevator = hardwareMap.get(DcMotor.class,"ElevatorMotor");
        Arm = hardwareMap.get(DcMotor.class,"ArmMotor");
        servoLeft = hardwareMap.get(Servo.class, "ArmLeftServo");
        servoRight = hardwareMap.get(Servo.class, "ArmRightServo");
        frontLeftDrive  = hardwareMap.get(DcMotor.class, "front left");
        frontRightDrive = hardwareMap.get(DcMotor.class, "front right");
        backLeftDrive = hardwareMap.get(DcMotor.class, "back left");
        backRightDrive = hardwareMap.get(DcMotor.class, "back right");
        waitForStart();
        while (opModeIsActive()){


            if(gamepad1.a) frontLeftDrive.setPower(0.1); //backright
            if(gamepad1.b) frontRightDrive.setPower(0.1); //frontright
            if(gamepad1.x) backRightDrive.setPower(0.1); //backleft
            if(gamepad1.y) backLeftDrive.setPower(0.1); //frontleft

            telemetry.addData("Arm", Arm.getCurrentPosition());
            telemetry.addData("Elevator", Elevator.getCurrentPosition());
            telemetry.addData("servoPositionRight", servoRight.getPosition());
            telemetry.addData("servoPositionLeft", servoLeft.getPosition());
            telemetry.addData("servoPos", servoPos);
            telemetry.update();
        }




    }





}

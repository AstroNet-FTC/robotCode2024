package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: Linear OpMode", group="Linear OpMode")
public class ArmNewOpMod extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor Arm;
    private DcMotor Elevator;
    private Servo ArmServoRight;
    private Servo ArmServoLeft;
    private Servo ClawServoRight;
    private Servo ClawServoLeft;

    private DcMotor frontLeftDrive;
    private DcMotor frontRightDrive;
    private DcMotor backRightDrive;
    private DcMotor backLeftDrive;
    static final int ElevatorWanted = -1100;
    static final int ArmWanted = -1680;
    static final int pickupArm = 0; //change me
    static final int pickupElevator = -1100;
    static final int ArmClosed = -200;
    boolean ClawOpen = true;
    boolean IntakeOpen = false;


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        Arm = hardwareMap.get(DcMotor.class,"ArmMotor");
        Elevator = hardwareMap.get(DcMotor.class,"ElevatorMotor");
        ArmServoRight = hardwareMap.get(Servo.class,"ArmRightServo");
        ArmServoLeft = hardwareMap.get(Servo.class,"ArmLeftServo");
        ClawServoRight = hardwareMap.get(Servo.class,"ClawRightServo");
        ClawServoLeft = hardwareMap.get(Servo.class,"ClawLeftServo");
        frontLeftDrive  = hardwareMap.get(DcMotor.class, "front left");
        frontRightDrive = hardwareMap.get(DcMotor.class, "front right");
        backLeftDrive = hardwareMap.get(DcMotor.class, "back left");
        backRightDrive = hardwareMap.get(DcMotor.class, "back right");

        Arm.setDirection(DcMotor.Direction.FORWARD);
        Elevator.setDirection(DcMotor.Direction.FORWARD);
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);

        Elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            double drive = gamepad1.left_stick_y;
            double power = Range.clip(drive, -1.0, 1.0) ;
            if (gamepad1.left_bumper){
                backRightDrive.setPower(0.5);
                frontLeftDrive.setPower(0.5);
            } else if (gamepad1.right_bumper) {
                backLeftDrive.setPower(0.5);
                frontRightDrive.setPower(0.5);
            }
            else {
                frontRightDrive.setPower(power);
                frontLeftDrive.setPower(power);
                backRightDrive.setPower(power);
                backLeftDrive.setPower(power);
            }
            // Show the elapsed game time and wheel power.

            if (gamepad1.dpad_up){
                proportional(Arm, ArmWanted, 0.8, 0);
                proportional(Elevator, ElevatorWanted, 0.8, -0.1);
                ArmServoRight.setPosition(0.5);
                ArmServoLeft.setPosition(0.5);
            }
            if(gamepad1.dpad_down){
                proportional(Elevator, -20, 0.7, 0);
                telemetry.addData("close", "sucsess");
                proportional(Arm, ArmClosed, 0.7, 0);
            }
            if(gamepad1.a && ClawOpen){
                ClawServoRight.setPosition(0.5);
                ClawServoLeft.setPosition(0);
                ClawOpen = false;
            }
            if (gamepad1.a && !ClawOpen){
                ClawServoRight.setPosition(0.3);
                ClawServoLeft.setPosition(1);
                ClawOpen = true;
            }
            if (gamepad1.x && !IntakeOpen){
                proportional(Arm, pickupArm, 1, 0);
                proportional(Elevator, pickupElevator, 1, 0);
                proportional(Arm,0, 1,0);

            }


            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", power);
            telemetry.update();

        }
    }
    public void proportional(DcMotor motor, final int wanted, double KP, double KF){
        int current = motor.getCurrentPosition();
        int Error = wanted;
        double fix = 1;
        while(wanted != current && opModeIsActive()){
            current = motor.getCurrentPosition();
            Error =  (wanted - current);
            fix = Error * KP;
            motor.setPower(fix + KF);
        }
    }
}


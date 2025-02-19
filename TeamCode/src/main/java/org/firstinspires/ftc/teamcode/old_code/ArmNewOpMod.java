package org.firstinspires.ftc.teamcode.old_code;

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
    static final int ArmWanted = -2900;
    static final int pickupArm = -370; //change me
    static final int pickUpArm = -365;
    static final int pickupElevator = -1190;
    static final int elevatorClosed = -350;
    static final int ArmClosed = -50;
    static final int armClose = -200;
    static final int ElevatorClosed = 0;
    boolean ClawOpen = true;
    boolean IntakeOpen = false;
    boolean Up = false;
    boolean Up1 = false;
    boolean PickUpOn = true;
    boolean ArmServoUp = false;


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
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);

        Elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        runtime.reset();
        proportional(Arm, -200, 1.1, 0,false);
        while (opModeIsActive()) {
            double drive = gamepad1.left_stick_y;
            double ElvJoystick = gamepad1.right_stick_y;
            double power = Range.clip(drive, -1.0, 1.0) ;
            double ElvPower= Range.clip(ElvJoystick, -1.0, 1.0);
                if (gamepad1.left_bumper) {
                    backLeftDrive.setPower(0.5);
                    frontRightDrive.setPower(-0.5);
                    frontLeftDrive.setPower(0.5);
                    backRightDrive.setPower(-0.5);
                } else if (gamepad1.right_bumper) {
                    backRightDrive.setPower(0.5);
                    frontLeftDrive.setPower(-0.5);
                    backLeftDrive.setPower(-0.5);
                    frontRightDrive.setPower(0.5);
                } else {
                    frontRightDrive.setPower(power);
                    frontLeftDrive.setPower(power);
                    backRightDrive.setPower(power);
                    backLeftDrive.setPower(power);



            }
            // Show the elapsed game time and wheel power.

            Elevator.setPower(ElvPower);
            if (gamepad1.dpad_up){
                proportional(Arm, ArmWanted, 0.7, -0.10, false);
                Up1 = false;
                telemetry.addData("Arm:", "up");
                telemetry.update();
              //  Elevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                proportional(Elevator, ElevatorWanted, 1, -0.30, true);
               // Elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
               // ArmServoRight.setPosition(0);
              //  ArmServoLeft.setPosition(0);
                Up = true;
                proportional(Arm, ArmWanted, 0.7, -0.07, false);

            }
            //if (gamepad1.x && PickUpOn) {
//                proportional(Arm, pickupArm, 1.1, -0.2, true);
//                Arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//                proportional(Elevator, pickupElevator, 1.1, -0.2, false);
//                PickUpOn = false;
//                Up = true;
//                Up1 = false;
            //}
            //if(gamepad1.x && !PickUpOn) {
//               proportional(Arm, armClose, 1.1, -0.2, true);
//                proportional(Elevator, ElevatorClosed, 1.1, 0.2, false);
//                Elevator.setPower(ElvPower);
//                PickUpOn = true;
//                Up = false;
//                Up1 = true;
            //}

            if (Up){
                Arm.setPower(-0.12);
                //Elevator.setPower(-0.02);
                if(ElvJoystick >0){
                    Arm.setPower(-0.18);
                }
            }
            if (Up1){
                //Arm.setPower(-0.15);
            }
            if(gamepad1.dpad_down) {
                proportional(Arm, ArmClosed, 1.1, 0.01, false);
                Up1 = true;

            }
            if(gamepad1.dpad_left) {
                if(Up){
                proportional(Arm, pickupArm, 1.1, -0.15, true);
                Up = false;
                }
                if (!Up){
                    proportional(Arm, pickupArm, 1.1, -0.01, true);
                }
                Up1= true;
            }
            if(gamepad1.a && ClawOpen){
                ClawServoRight.setPosition(0.7);
                ClawServoLeft.setPosition(0.6);
                ClawOpen = false;
            }
            if (gamepad1.x && !ClawOpen){
                ClawServoRight.setPosition(1);
                ClawServoLeft.setPosition(0);
                ClawOpen = true;

            }if(gamepad1.b && ArmServoUp){
                ArmServoRight.setPosition(0.7);
                ArmServoLeft.setPosition(0.6);
                ArmServoUp = false;
                Arm.setPower(-0.5);
            }
            if (gamepad1.b && !ArmServoUp){
                ArmServoRight.setPosition(1);
                ArmServoLeft.setPosition(0);
                ArmServoUp = true;
            }
            if (gamepad1.y){
            proportional(Arm, -2050, 1.1, 0.2, true );
            }


           // if (gamepad1.x && !IntakeOpen){
                //proportional(Arm, pickupArm, 1, -1, false);
                //proportional(Elevator, pickupElevator, 1, 0, false);
                //proportional(Arm, ArmClosed, 1,-1, false);
           // }

            telemetry.addData("Up", Up);
            telemetry.addData("Up1", Up1);
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", power);
            telemetry.update();

        }
    }
    public void proportional(DcMotor motor, final int wanted, double KP, double KF, boolean hold) {
        int current = motor.getCurrentPosition();
        double Error = wanted - current;
        double totalFix = 0;
        double fix = 1;
        if (Error < 0) {
            totalFix = -(wanted - current);
            while ((wanted <= current) && opModeIsActive()) {
                current = motor.getCurrentPosition();
                Error = (wanted - current);
                fix = (Error / totalFix) * KP;
                motor.setPower(fix + KF);
                telemetry.addData("motor current: ", current);
                telemetry.update();
                if (gamepad1.dpad_right) {
                    motor.setPower(3 * KF);
                }
                if (gamepad1.options) {
                    break;
                }
            }
        } else {
            totalFix = wanted - current;
            while ((wanted >= current) && opModeIsActive()) {
                current = motor.getCurrentPosition();
                Error = (wanted - current);
                fix = (Error / totalFix) * KP;
                motor.setPower(fix + KF);
                telemetry.addData("motor current: ", current);
                telemetry.update();
                if (gamepad1.dpad_right) {
                    motor.setPower(3 * KF);
                }
                if (gamepad1.options) {
                    break;
                }
            }
        }
//        telemetry.addData();
        if (hold) motor.setPower(KF);
        {

        }
    }
}

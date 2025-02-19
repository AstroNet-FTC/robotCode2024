package org.firstinspires.ftc.teamcode.old_code;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


/*
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */
@Autonomous
//@Disabled`
public class  Auto2 extends LinearOpMode {

    // Declare OpMode members.
    private DcMotor Arm;
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeftDrive;
    private DcMotor frontRightDrive;
    private DcMotor backRightDrive;
    private DcMotor backLeftDrive;
    double Ticks_Per_Revolution = 384.5;
    double Wheel_Diameter_Cm = 9.5;
    double Counts_Per_Cm = Ticks_Per_Revolution * Wheel_Diameter_Cm * 3.1415;
    double Drive_Speed = 0.5;
    //double Turn_speed = 0.4;
    static final int ArmWanted = -1680;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        frontLeftDrive = hardwareMap.get(DcMotor.class, "front left");
        frontRightDrive = hardwareMap.get(DcMotor.class, "front right");
        backLeftDrive = hardwareMap.get(DcMotor.class, "back left");
        backRightDrive = hardwareMap.get(DcMotor.class, "back right");
        Arm = hardwareMap.get(DcMotor.class, "ArmMotor");


        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);

        frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        proportional(Arm, ArmWanted, 0.5, 0);
//        Arm.setTargetPosition(ArmWanted);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Wait for the game to start (driver presses START)
        waitForStart();


        runtime.reset();
        encoderDrive(Drive_Speed, -0.280, -0.280, 4.0);  // S3: Reverse 24 Inches with 4 Sec timeout
        encoderDrive(Drive_Speed, 0.350, 0.350, 4.0);
    }
    public void encoderDrive(double speed,
                             double leftCM ,double rightCm,
                             double timeoutS) {
        int newBackRightTarget;
        int newFrontRightTarget;
        int newFrontLeftTarget;
        int newBackLeftTarget;

        // Ensure that the OpMode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newBackRightTarget = backRightDrive.getCurrentPosition() + (int) (rightCm * Counts_Per_Cm);
            newBackLeftTarget = backLeftDrive.getCurrentPosition() + (int) (leftCM * Counts_Per_Cm);
            newFrontLeftTarget = frontLeftDrive.getCurrentPosition() + (int) (leftCM * Counts_Per_Cm);
            newFrontRightTarget = frontRightDrive.getCurrentPosition() + (int) (rightCm * Counts_Per_Cm);

            frontLeftDrive.setTargetPosition(newFrontLeftTarget);
            frontRightDrive.setTargetPosition(newFrontRightTarget);
            backLeftDrive.setTargetPosition(newBackLeftTarget);
            backRightDrive.setTargetPosition(newBackRightTarget);

            // Turn On RUN_TO_POSITION
            frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            // reset the timeout time and start motion.
            runtime.reset();
            backLeftDrive.setPower(Math.abs(speed));
            backRightDrive.setPower(Math.abs(speed));
            frontRightDrive.setPower(Math.abs(speed));
            frontLeftDrive.setPower(Math.abs(speed));
            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (backLeftDrive.isBusy() && backRightDrive.isBusy() && frontRightDrive.isBusy() && frontLeftDrive.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Running to", " %7d :%7d", newFrontLeftTarget, newFrontRightTarget, newBackLeftTarget, newBackRightTarget);
                telemetry.addData("Currently at", " at %7d :%7d",
                        frontLeftDrive.getCurrentPosition(), frontRightDrive.getCurrentPosition(), backLeftDrive.getCurrentPosition(), backRightDrive.getCurrentPosition());
                telemetry.update();
            }

            // Stop all motion;
            backLeftDrive.setPower(0);
            backRightDrive.setPower(0);
            frontLeftDrive.setPower(0);
            frontRightDrive.setPower(0);
            // Turn off RUN_TO_POSITION
            frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            sleep(250);   // optional pause after each move.

        }


    }
    public void proportional(DcMotor motor, final int wanted, double KP, double KF){
        int current = motor.getCurrentPosition();
        double Error = wanted - current;
        final double totalFix = wanted-current;
        double fix = 1;
        while((wanted != current) && opModeIsActive()){
            current = motor.getCurrentPosition();
            Error =  (wanted - current);
            fix = (Error / totalFix) * KP;
            motor.setPower(fix + KF);
        }
    }

}
package org.firstinspires.ftc.teamcode.old_code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Basic: Linear OpMode", group="Linear OpMode")
public class  Arm extends LinearOpMode {
    private DcMotor elevator;

    //before the code begins

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        elevator  = hardwareMap.get(DcMotor.class, "elevator");
        //init- what happens only the first cycle before you press play
        elevator.setDirection(DcMotor.Direction.FORWARD);
        while (opModeIsActive()) {
            double elevatorPower;

            //what happens in the code

        }

    }



    }

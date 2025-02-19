package org.firstinspires.ftc.teamcode.claw;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SubSystemClaw extends SubsystemBase {
    private final CRServo Claw;

    public SubSystemClaw(HardwareMap hardwareMap) {
        Claw = hardwareMap.get(CRServo.class, "Claw");

    }

    public void ClawOpen() {
        Claw.setPower(0.4);}

    public void ClawClose() {
            Claw.setPower(-0.4);
    }
}


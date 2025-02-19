package org.firstinspires.ftc.teamcode.drive;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.lang.Math;
public class Mecanum extends SubsystemBase {
    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;

    public Mecanum(HardwareMap hardwareMap) {
        fl = hardwareMap.get(DcMotor.class, "front left");
        fr = hardwareMap.get(DcMotor.class, "front right");
        bl = hardwareMap.get(DcMotor.class, "back left");
        br = hardwareMap.get(DcMotor.class, "back right");

        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public double[] joystickToPower(double x, double y, double rx) {

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double[] powers = {
                (y + x + rx) / denominator,
                (y - (x * 1.5) + rx) / denominator,
                (y - x - rx) / denominator,
                (y + (x * 1.5) - rx) / denominator
        };
        return powers;

    }

    public void setPower(double[] powers) {
        fl.setPower(powers[0]);
        bl.setPower(powers[1]);
        fr.setPower(powers[2]);
        br.setPower(powers[3]);
    }

    public void arcadeDrive(double x, double y, double rx) {
        setPower(joystickToPower(x, y, rx));
    }
    public double[] GetPos(){
        double[] TickPos = {
               fl.getCurrentPosition(),
                bl.getCurrentPosition(),
                fr.getCurrentPosition(),
                br.getCurrentPosition()
        };
        return TickPos;
    }

}
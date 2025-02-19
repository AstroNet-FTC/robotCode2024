package org.firstinspires.ftc.teamcode.Arm;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.old_code.Arm;

public class ArmSubsystem extends SubsystemBase{

    private final DcMotor Arm;
    static final double kp = 0.5;
    static final double ki = 0;
    static final double kd = 0;


    private PIDController pidController;
    public  ArmSubsystem(HardwareMap hardwareMap){
        Arm = hardwareMap.get(DcMotor.class,"ArmMotor");
        pidController = new PIDController(kp, ki, kd);
        Arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void setPower(double power) {Arm.setPower(power);
    }
    public double getTicks () {return (Arm.getCurrentPosition());
    }
    public PIDController getPidController() {
        return pidController;

    }


}

package org.firstinspires.ftc.teamcode.Elevator;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Globals;

public class ElevatorSubsystem extends SubsystemBase{

    private final DcMotor Elevator;
    static final int ElevatorWanted = 0;
    private PIDController pidController;
    static final double kp = 0.7;
    static final double ki = 0;
    static final double kd = 0;


    public  ElevatorSubsystem(HardwareMap hardwareMap){
        Elevator = hardwareMap.get(DcMotor.class,"ElevatorMotor");
        pidController = new PIDController(kp, ki, kd);
        Elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void setPower(double power) {Elevator.setPower(power);
    }
    public double getTicks () {
        return (Elevator.getCurrentPosition());
    }
    public PIDController getPidController() {
        return pidController;
    }
    public void reset (){
        Globals.ElvevatorOffset = Elevator.getCurrentPosition();
    }
    public void manual(double power){
        Elevator.setPower(power);
    }



}

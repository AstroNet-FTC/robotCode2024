package org.firstinspires.ftc.teamcode.Hand;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HandSubsystem extends SubsystemBase {
    private final Servo HandRightServo;
    public HandSubsystem(HardwareMap hardwareMap){
        HandRightServo = hardwareMap.get(Servo.class, "Hand");
    }
    public void HandUp (){
        HandRightServo.setPosition(0.6);
    }
    public void HandDown (){
        HandRightServo.setPosition(0.1);
    }
}

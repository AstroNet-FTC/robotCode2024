package org.firstinspires.ftc.teamcode.drive;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SubsystemDrive extends SubsystemBase {
    private DcMotor frontLeftDrive;
    private DcMotor frontRightDrive;
    private DcMotor backRightDrive;
    private DcMotor backLeftDrive;

public SubsystemDrive (HardwareMap hardwareMap){
    frontLeftDrive  = hardwareMap.get(DcMotor.class, "front left");
    frontRightDrive = hardwareMap.get(DcMotor.class, "front right");
    backLeftDrive = hardwareMap.get(DcMotor.class, "back left");
    backRightDrive = hardwareMap.get(DcMotor.class, "back right");
}


}

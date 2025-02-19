package org.firstinspires.ftc.teamcode.Arm;

import com.arcrobotics.ftclib.command.CommandBase;

public class ArmCommand extends CommandBase {

    private final ArmSubsystem subsystem;
    private double wanted;
  public ArmCommand (ArmSubsystem Subsystem,double Wanted)  {
      subsystem = Subsystem;
      wanted = Wanted;

  }

  @Override
  public void initialize(){
   subsystem.getPidController().setSetPoint(wanted);
  }
  @Override
  public void execute(){
  subsystem.setPower(subsystem.getPidController().calculate(subsystem.getTicks()));
  }
  @Override
  public boolean isFinished(){
      return subsystem.getPidController().atSetPoint();
    }
  @Override
  public void end(boolean interupted){
      subsystem.setPower(0);
  }


}

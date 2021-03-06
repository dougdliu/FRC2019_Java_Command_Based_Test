/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArcadeDrive extends Command {
  public ArcadeDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_drivetrain_subsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftJoyY = -Robot.m_oi.j_stick_driver.getRawAxis(1);
    double rightJoyX = Robot.m_oi.j_stick_driver.getRawAxis(4);
    boolean LB_Pressed = Robot.m_oi.j_stick_control_LB.get();
    leftJoyY = LB_Pressed ? leftJoyY / 2 : leftJoyY;
    rightJoyX = LB_Pressed ? rightJoyX / 2 : rightJoyX;
    Robot.m_drivetrain_subsystem.TeleopDrive(leftJoyY, rightJoyX);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

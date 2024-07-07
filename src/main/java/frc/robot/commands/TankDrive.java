// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArcadeDrive;

public class TankDrive extends Command {
  /** Creates a new TankDrive. */
  ArcadeDrive m_ArcadeDrive;
  DoubleSupplier forwardSpeed;
  DoubleSupplier turnSpeed;
  public TankDrive(ArcadeDrive m_ArcadeDrive, DoubleSupplier forwardSpeed, DoubleSupplier turnSpeed) {
    this.m_ArcadeDrive = m_ArcadeDrive;
    this.forwardSpeed = forwardSpeed;
    this.turnSpeed = turnSpeed;
    addRequirements(m_ArcadeDrive);
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double moveSpeed = forwardSpeed.getAsDouble();
    double turningSpeed = turnSpeed.getAsDouble();
    
    double leftMotorSpeed = moveSpeed - turningSpeed;
    double rightMotorSpeed = moveSpeed + turningSpeed;
    
    // Find the maximum absolute value of the speeds
    double maxSpeed = Math.max(Math.abs(leftMotorSpeed), Math.abs(rightMotorSpeed));
    
    // If the maximum speed is greater than 1.0, scale both speeds
    if (maxSpeed > 1.0) {
        leftMotorSpeed /= maxSpeed;
        rightMotorSpeed /= maxSpeed;
    }
    
    m_ArcadeDrive.setLeftMotors(leftMotorSpeed);
    m_ArcadeDrive.setRightMotors(rightMotorSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ArcadeDrive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CandyRotator;

public class SpinCandyRotator extends Command {
  /** Creates a new SpinCandyRotator. */
  CandyRotator m_CandyRotator;
  DoubleSupplier speed;
  public SpinCandyRotator(CandyRotator m_CandyRotator, DoubleSupplier speed) {
    this.m_CandyRotator = m_CandyRotator;
    this.speed = speed;
    addRequirements(m_CandyRotator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_CandyRotator.setSpeed(speed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

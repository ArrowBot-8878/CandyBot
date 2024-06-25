// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.signals.MotorOutputStatusValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CandyRotator extends SubsystemBase {
  /** Creates a new CandyRotator. */
  CANSparkMax candyRotator;
  public CandyRotator() {
    candyRotator = new CANSparkMax(10, MotorType.kBrushless);
  }

  public void setSpeed(double speed) {
    candyRotator.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArcadeDrive extends SubsystemBase {
  /** Creates a new ArcadeDrive. */
  VictorSPX leftFrontVictorSPX;
  VictorSPX leftBackVictorSPX;
  VictorSPX rightFrontVictorSPX;
  VictorSPX rightBackVictorSPX;

  public ArcadeDrive() {
    leftFrontVictorSPX = new VictorSPX(1);
    leftBackVictorSPX = new VictorSPX(2);
    rightFrontVictorSPX = new VictorSPX(3);
    rightBackVictorSPX = new VictorSPX(4);
  }

  public void setLeftMotors(double speed) {
    leftFrontVictorSPX.set(VictorSPXControlMode.PercentOutput, speed);
    leftBackVictorSPX.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void setRightMotors(double speed) {
    rightFrontVictorSPX.set(VictorSPXControlMode.PercentOutput, -speed);
    rightBackVictorSPX.set(VictorSPXControlMode.PercentOutput, -speed);
  }

  public void stop() {
    leftFrontVictorSPX.set(VictorSPXControlMode.PercentOutput, 0);
    leftBackVictorSPX.set(VictorSPXControlMode.PercentOutput, 0);
    rightFrontVictorSPX.set(VictorSPXControlMode.PercentOutput, 0);
    rightBackVictorSPX.set(VictorSPXControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

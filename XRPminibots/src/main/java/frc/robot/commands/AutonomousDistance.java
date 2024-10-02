// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ReflectiveSensor;

public class AutonomousDistance extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
<<<<<<< Updated upstream
  public AutonomousDistance(Drivetrain drivetrain) {
    addCommands(
        new DriveDistance(2, 20, drivetrain),
        new TurnDegrees(-3, 90, drivetrain),
        new DriveDistance(2, 13, drivetrain));

=======
  public AutonomousDistance(Drivetrain drivetrain, ReflectiveSensor reflectiveSensor) {
    
    addCommands(
      new DriveAutoAlign(3, drivetrain, reflectiveSensor));
>>>>>>> Stashed changes
  }
}

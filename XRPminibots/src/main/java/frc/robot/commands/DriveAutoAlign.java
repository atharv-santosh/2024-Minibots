package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class DriveAutoAlign extends Command {

    private double m_speed;
    private Drivetrain m_drivetrain;
    private ReflectiveSensor m_reflectiveSensor;

    public DriveAutoAlign(double speed, Drivetrain drivetrain, ReflectiveSensor reflectiveSensor){
        addRequirements(drivetrain);
        m_drivetrain = drivetrain;
        m_speed = speed;
        m_reflectiveSensor = reflectiveSensor;

    }

    @Override
    public void initialize() {
        m_drivetrain.arcadeDrive(0, 0);
        m_drivetrain.resetEncoders();
    }

    @Override
    public void execute(){
        m_drivetrain.arcadeDrive(m_speed, 0);
        while (m_reflectiveSensor.leftValue() < 4){
            new TurnDegrees(-2, 1, m_drivetrain);
        }
         while (m_reflectiveSensor.rightValue() < 4){
            new TurnDegrees(2, 1,m_drivetrain);
        }
    }

    // public boolean turnFinished() {
    //     /* Need to convert distance travelled to degrees. The Standard
    //        XRP Chassis found here, https://www.sparkfun.com/products/22230,
    //        has a wheel placement diameter (163 mm) - width of the wheel (8 mm) = 155 mm
    //        or 6.102 inches. We then take into consideration the width of the tires.
    //     */
    //     double inchPerDegree = Math.PI * 6.102 / 360;
    
    //     if (reflectiveSensor.rightValue() != 4.3){

    //     }
    //     // return getAverageTurningDistance() >= (inchPerDegree * m_alignAngle);
    //   }
    
    //   private double getAverageTurningDistance() {
    //     double leftDistance = Math.abs(m_drivetrain.getLeftDistanceInch());
    //     double rightDistance = Math.abs(m_drivetrain.getRightDistanceInch());
    //     return (leftDistance + rightDistance) / 2.0;
    //   }

    @Override
    public void end(boolean interrupted) {
        m_drivetrain.arcadeDrive(0, 0);
    }
   
    // @Override
    // public boolean isFinished() {
    //     return Math.abs(m_drivetrain.getAverageDistanceInch()) >= m_distance;
    // }
}

package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.robot.OI;
import org.usfirst.frc.team1164.robot.RobotMap;
import org.usfirst.frc.team1164.robot.commands.DriveJoystick;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
	private VictorSP frontLeft, frontRight, backLeft, backRight;
	private Encoder leftEncoder, rightEncoder;
	private Solenoid solenoid1, solenoid2;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Chassis() {
		frontLeft = new VictorSP(RobotMap.ADV_frontLeft);
		frontRight = new VictorSP(RobotMap.ADV_frontRight);
		backLeft = new VictorSP(RobotMap.ADV_backLeft);
		backRight = new VictorSP(RobotMap.ADV_backRight);
		
		leftEncoder = new Encoder(RobotMap.ADE_leftA, RobotMap.ADE_leftB);
		rightEncoder = new Encoder(RobotMap.ADE_rightA, RobotMap.ADE_rightB);
		
		leftEncoder.reset();
		rightEncoder.reset();
		leftEncoder.setDistancePerPulse(RobotMap.ADE_leftDPP);
		rightEncoder.setDistancePerPulse(RobotMap.ADE_rightDPP);
		
		solenoid1 = new Solenoid(1, RobotMap.ADS_ID_1);
		solenoid2 = new Solenoid(1, RobotMap.ADS_ID_2);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveJoystick());
    }
    
    public void setFrontSide(boolean type) {
		frontLeft.setInverted(!type ^ RobotMap.ADV_frontLeftI);
		frontRight.setInverted(!type ^ RobotMap.ADV_frontRightI);
		backLeft.setInverted(!type ^ RobotMap.ADV_backLeftI);
		backRight.setInverted(!type ^ RobotMap.ADV_backRightI);
    }
    
    public void driveArcade() {
    	double FM = OI.getDriverJoystick().getRawAxis(1);
    	double AM = OI.getDriverJoystick().getRawAxis(4);
    	
    	/* take forward movement (FM) "speed", 
    	 * if Arcade movement (AM) is present subtracts 50% of FM * AM
    	 * from corresponding side
    	 */
    	double leftSpeed = FM - (AM < 0 ? (0.5 * FM * -AM) : 0);
    	double rightSpeed = FM - (AM > 0 ? (0.5 * FM * AM) : 0);
    	
    	drive(leftSpeed, rightSpeed);
    }
    
    public void driveTank() {
    	double leftSpeed = OI.getDriverJoystick().getRawAxis(1);
    	double rightSpeed = OI.getDriverJoystick().getRawAxis(3);
    	
    	drive(leftSpeed, rightSpeed);
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
    	frontLeft.set(leftSpeed);
    	frontRight.set(rightSpeed);
    	backLeft.set(leftSpeed);
    	backRight.set(rightSpeed);
    }
    
    public void brake() {
    	frontLeft.set(0);
    	frontRight.set(0);
    	backLeft.set(0);
    	backRight.set(0);
    }
    
    public void shiftHigh() {
    	solenoid1.set(!RobotMap.ADS_invert1);
    	solenoid2.set(!RobotMap.ADS_invert2);
    }
    
    public void shiftLow() {
    	solenoid1.set(RobotMap.ADS_invert1);
    	solenoid2.set(RobotMap.ADS_invert2);
    }
    
    public void ResetEncoders() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public double getLeftEncoder() {
    	return leftEncoder.getDistance();
    }
    
    public double getRightEncoder() {
    	return rightEncoder.getDistance();
    }
}
package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	private VictorSP shooterMotor;
	
	public Shooter() {
		shooterMotor = new VictorSP(RobotMap.S_motor);
		shooterMotor.setInverted(RobotMap.S_inverted);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed(int speed) {
    	shooterMotor.set(speed);
    }
    
    public void turnOn() {
    	setSpeed(1);
    }
    
    public void turnOff() {
    	setSpeed(0);
    }
}


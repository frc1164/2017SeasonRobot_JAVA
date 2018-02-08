package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.robot.RobotMap;
import org.usfirst.frc.team1164.robot.commands.RollerOff;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Roller extends Subsystem {
	
	public static final int OFF = 0;
	public static final int ON = 1;
	public static final int REVERSE = 2;
	
	private VictorSP roller;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Roller() {
		roller = new VictorSP(RobotMap.R_motor);
		roller.setInverted(RobotMap.R_Inverted);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new RollerOff());
    }
    
    public void setSpeed(int speed) {
    	roller.set(speed);
    }
    
    public void turnOn() {
    	setSpeed(1);
    }
    
    public void turnOff() {
    	setSpeed(0);
    }
    
    public void reverse() {
    	setSpeed(-1);
    }
}


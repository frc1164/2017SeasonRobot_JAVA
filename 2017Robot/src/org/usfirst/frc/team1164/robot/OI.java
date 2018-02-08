/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1164.robot;

import org.usfirst.frc.team1164.robot.commands.RollerOff;
import org.usfirst.frc.team1164.robot.commands.RollerOn;
import org.usfirst.frc.team1164.robot.commands.RollerReverse;
import org.usfirst.frc.team1164.robot.commands.ShiftHigh;
import org.usfirst.frc.team1164.robot.commands.ShiftLow;
import org.usfirst.frc.team1164.robot.commands.ShooterOff;
import org.usfirst.frc.team1164.robot.commands.ShooterOn;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static int driverRemotePort = 0;
	public static int operatorRemotePort = 0;
	
	private static Joystick driverStick = new Joystick(driverRemotePort);
	private static Joystick operatorStick = new Joystick(operatorRemotePort);
	
	private static Button shiftLow = new JoystickButton(driverStick, 7);
	private static Button shiftHigh = new JoystickButton(driverStick, 8);
	
	private static Button rollerOn = new JoystickButton(operatorStick, 2);
	private static Button rollerOff = new JoystickButton(operatorStick, 1);
	private static Button rollerReverse = new JoystickButton(operatorStick, 3);
	private static Button shooterOn = new JoystickButton(operatorStick, 6);
	private static Button shooterOff = new JoystickButton(operatorStick, 6);
	
	public OI() {
		shiftHigh.whenPressed(new ShiftHigh());
		shiftLow.whenPressed(new ShiftLow());
		
		rollerOn.whenPressed(new RollerOn());
		rollerOff.whenPressed(new RollerOff());
		rollerReverse.whenPressed(new RollerReverse());
		shooterOn.whenPressed(new ShooterOn());
		shooterOff.whenPressed(new ShooterOff());
	}
	
	public static Joystick getDriverJoystick() {
		return driverStick;
	}
	
	public static Joystick getOperatorJoystick() {
		return operatorStick;
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}

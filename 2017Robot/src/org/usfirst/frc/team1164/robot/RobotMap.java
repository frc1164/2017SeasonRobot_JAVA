/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1164.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

// drive
	// type
	// 1 = arcade
	// 2 = tank
	public final static int AD_type = 1;
	
	// VictorSP
	public final static int ADV_frontLeft = 1;
	public final static int ADV_frontRight = 3;
	public final static int ADV_backLeft = 0;
	public final static int ADV_backRight = 2;

	public final static boolean ADV_frontLeftI = false;
	public final static boolean ADV_frontRightI = false;
	public final static boolean ADV_backLeftI = false;
	public final static boolean ADV_backRightI = false;
	// Encoders
	/* info on names
	 * A = Channel A
	 * B = Channel B
	 * DPP = Distance per pulse
	 */
	public final static int ADE_leftA = 4;
	public final static int ADE_leftB = 5;
	public final static double ADE_leftDPP = 1.00;
	
	public final static int ADE_rightA = 6;
	public final static int ADE_rightB = 7;
	public final static double ADE_rightDPP = 1.00;
	// solenoids
	public final static int ADS_ID_1 = 4;
	public final static int ADS_ID_2 = 5;
	
	public final static boolean ADS_invert1 = false;
	public final static boolean ADS_invert2 = true;
	
// roller
	public final static int R_motor = 6;
	public final static boolean R_Inverted = false;

// shooter
	public final static int S_motor = 5;
	public final static boolean S_inverted = false;
	
}

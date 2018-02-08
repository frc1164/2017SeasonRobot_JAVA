package org.usfirst.frc.team1164.robot.commands;

import org.usfirst.frc.team1164.robot.Robot;
import org.usfirst.frc.team1164.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveJoystick extends Command {

    public DriveJoystick() {
        requires(Robot.kDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @SuppressWarnings("unused")
	protected void execute() {
    	if (RobotMap.AD_type < 2)
    		Robot.kDrive.driveArcade();
    	else
    		Robot.kDrive.driveTank();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

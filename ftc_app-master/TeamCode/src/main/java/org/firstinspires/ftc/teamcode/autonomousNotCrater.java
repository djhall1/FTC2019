package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "hooklessDepot")

public class autonomousNotCrater extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private hardwareMap robot = new hardwareMap();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 1){
            robot.frontRightDrive.setPower(0.7);
            robot.frontLeftDrive.setPower(0.7);
            robot.leftDrive.setPower(0.7);
            robot.rightDrive.setPower(0.7);
        }
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 2){
            robot.frontRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(-1.0);
            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(-1.0);
        }
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 1){
            robot.frontLeftDrive.setPower(0.74);
            robot.frontRightDrive.setPower(-0.74);
            robot.rightDrive.setPower(-0.74);
            robot.leftDrive.setPower(0.74);
        }
        runtime.reset();
       while(opModeIsActive() && runtime.seconds() < 2){
            robot.frontRightDrive.setPower(-1.0);
            robot.frontLeftDrive.setPower(-1.0);
            robot.rightDrive.setPower(-1.0);
            robot.leftDrive.setPower(-1.0);
        }
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 4.5){
            robot.arm.setPower(0.6);
            robot.frontRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
        }
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 1){
            robot.arm.setPower(0);
            robot.hand.setPower(-1.0);
        }
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() > 3.5){
            robot.hand.setPower(0);
        }
    }
}

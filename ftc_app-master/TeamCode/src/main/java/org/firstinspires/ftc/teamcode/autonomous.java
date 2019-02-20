package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
//@Disabled

@Autonomous (name = "Crater")

public class autonomous extends LinearOpMode{
    private ElapsedTime runtime = new ElapsedTime();
    private hardwareMap robot = new hardwareMap();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 1.5){
            robot.rightDrive.setPower(-0.5);
            robot.leftDrive.setPower(-0.5);
            robot.frontRightDrive.setPower(-0.5);
            robot.frontLeftDrive.setPower(-0.5);
        }
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 4.5){
            robot.rightDrive.setPower(0);
            robot.leftDrive.setPower(0);
            robot.frontRightDrive.setPower(0);
            robot.frontLeftDrive.setPower(0);
            robot.arm.setPower(0.9);
        }
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() < 1){
            robot.arm.setPower(0);
            robot.hand.setPower(-1.0);
        }
        runtime.reset();
        while(opModeIsActive() && runtime.seconds() > 0){
            robot.hand.setPower(0);
        }
    }

     //   idle();
    }



package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Put the arm back where it needs to be")


public class returnArm extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private hardwareMap robot = new hardwareMap();

    @Override
    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);
        waitForStart();
        runtime.reset();

        while(opModeIsActive() && runtime.seconds() < 5){
            robot.arm.setPower(-0.3);
        }
    }
}

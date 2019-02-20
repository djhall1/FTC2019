package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Tank Drive", group="Drive")


public class TankDrive extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    hardwareMap robot = new hardwareMap();

    boolean yPressed = false;
    boolean xPressed = false;
    boolean bPressed = false;
    boolean aPressed = false;

    @Override
    public void init() {
        robot.init(hardwareMap);

        runtime.reset();
    }

    @Override
    public void loop() {
        double leftPower;
        double rightPower;
        double armPowerClockWise;
        double armPowerCounterClockwise;
        double armPower;



        // check to see if gamepad button pressed
        if (gamepad2.y){
            yPressed = true;
            xPressed = false;
            bPressed = false;
            aPressed = false;
        }
        else if (gamepad2.x){
            yPressed = false;
            xPressed = true;
            bPressed = false;
            aPressed = false;
        }
        else if (gamepad2.a){
            yPressed = false;
            xPressed = false;
            bPressed = false;
            aPressed = true;
        }
        else if (gamepad2.b){
            yPressed = false;
            xPressed = false;
            bPressed = true;
            aPressed = false;
        }

        if (yPressed){
                leftPower = Range.clip(-gamepad1.left_stick_y, -1.0, 1.0);
                rightPower = Range.clip(-gamepad1.right_stick_y, -1.0, 1.0);

                robot.leftDrive.setPower(leftPower);
                robot.rightDrive.setPower(rightPower);
                robot.frontLeftDrive.setPower(leftPower);
                robot.frontRightDrive.setPower(rightPower);
            }
            if (xPressed){
                leftPower = Range.clip(-gamepad1.left_stick_y, -0.75, 0.75);
                rightPower = Range.clip(-gamepad1.right_stick_y, -0.75, 0.75);

                robot.leftDrive.setPower(leftPower);
                robot.rightDrive.setPower(rightPower);
                robot.frontLeftDrive.setPower(leftPower);
                robot.frontRightDrive.setPower(rightPower);
        }
        if (bPressed){
            leftPower = Range.clip(-gamepad1.left_stick_y, -0.5, 0.5);
            rightPower = Range.clip(-gamepad1.right_stick_y, -0.5, 0.5);

            robot.leftDrive.setPower(leftPower);
            robot.frontLeftDrive.setPower(leftPower);
            robot.rightDrive.setPower(rightPower);
            robot.frontRightDrive.setPower(rightPower);
        }
        if(aPressed){
            leftPower = Range.clip(-gamepad1.left_stick_y, -0.25, 0.25);
            rightPower = Range.clip(-gamepad1.right_stick_y, -0.25, 0.25);

            robot.frontRightDrive.setPower(rightPower);
            robot.rightDrive.setPower(rightPower);
            robot.frontLeftDrive.setPower(leftPower);
            robot.leftDrive.setPower(leftPower);
        }

        armPowerClockWise = Range.clip(gamepad1.left_trigger,0.0, 1.0);
        armPowerCounterClockwise = Range.clip(gamepad1.right_trigger, 0.0, 1.0);
        armPower = Range.clip(armPowerClockWise - armPowerCounterClockwise, -1.0, 1.0);

        robot.arm.setPower(armPower);

        if (gamepad1.left_bumper) {
            robot.hand.setPower(-1.0);
        }
        else if (gamepad1.right_bumper) {
            robot.hand.setPower(1.0);
        } else {
            robot.hand.setPower(0);
        }

        if (gamepad1.dpad_up) {
            robot.hook.setPower(1.0);
        }
        else if (gamepad1.dpad_down) {
            robot.hook.setPower(-1.0);
        } else {
            robot.hook.setPower(0);
        }

        if(gamepad1.x){
            robot.claw.setPosition(1.0);
        }
        else if(gamepad1.b){
            robot.claw.setPosition(0);
        }
    }


        //public void stop(){}

    }



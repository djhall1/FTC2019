package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Tank Drive 2", group="Drive")


public class tankDriveTwo extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    hardwareMap robot = new hardwareMap();

    boolean yPressed, xPressed, bPressed, aPressed;

    @Override
    public void init() {
        robot.init(hardwareMap);

        // set initial button press values
        // TODO: Make seperate controller class with function for button presses.
        yPressed = false;
        xPressed = false;
        bPressed = false;
        aPressed = false;

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
        leftPower = Range.clip(-gamepad1.left_stick_y, -1.0, 1.0);
        rightPower = Range.clip(-gamepad1.right_stick_y, -1.0, 1.0);

        if (yPressed){
            leftPower = leftPower * 2;
            rightPower = rightPower * 2;
        }
        if (xPressed){
            leftPower = leftPower / 2;
            rightPower = rightPower / 2;
        }
        if (bPressed){
            leftPower = leftPower / 3;
            rightPower = rightPower / 3;
        }
        if(aPressed){
            leftPower = leftPower * 3;
            rightPower = rightPower * 3;

        }

        robot.tankDrive(leftPower,rightPower);

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

    public void buttonPress (boolean gamepad Y, boolean gamepadX, boolean gamepadA, boolean gamepadB){

    }


    //public void stop(){}

}



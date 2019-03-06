package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Tank Drive 2", group="Drive")


public class tankDriveTwo extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    hardwareMap robot = new hardwareMap();

    float powerMod;

    @Override
    public void init() {
        robot.init(hardwareMap);

        powerMod = 1.0;

        runtime.reset();
    }

    @Override
    public void loop() {
        double leftPower;
        double rightPower;
        double armPowerClockWise;
        double armPowerCounterClockwise;
        double armPower;

        // Check gamepad face buttons and modify power outputs based on it.
        this.buttonPress(gamepad1.Y,gamepad1.X,gamepad1.A,gamepad1.B)
        // Tank Drive
        robot.tankDrive(leftPower,rightPower, powerMod);

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
            robot.extend();
        }
        else if (gamepad1.dpad_down) {
            robot.retract();
        }

        if(gamepad1.x){
            robot.claw.setPosition(1.0);
        }
        else if(gamepad1.b){
            robot.claw.setPosition(0);
        }
    }

    public void buttonPress (boolean Y, boolean X, boolean A, boolean B){
        if Y {
            this.powerMod = 4.0;
        } else if X{
            this.powerMod = 2.0;
        } else if A {
            this.powerMod = 3.0;
        } else if B {
            this.powerMod = 1.0;
        }
    }


    //public void stop(){}

}



package org.firstinspires.ftc.teamcode;

//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="POV Drive", group="Drive")

public class POVdrive extends OpMode {
    private ElapsedTime runtime = new ElapsedTime();
    hardwareMap robot = new hardwareMap();

    @Override
    public void init() {
  /*      telemetry.addData("Status", "Initialize");
        telemetry.update();*/

        robot.init(hardwareMap);

        runtime.reset();

    }

    @Override
    public void loop() {

        double leftPower;
        double rightPower;
        double drive;
        double turn;
        double hook;
        double hookPower;

        drive = -gamepad1.left_stick_y;
        turn = gamepad1.left_stick_x;
        hook = gamepad1.right_stick_y;
        hookPower = Range.clip(hook, -1.0, 1.0);
        leftPower = Range.clip(drive + turn, -0.75, 0.75);
        rightPower = Range.clip(drive - turn, -0.75, 0.75);

        robot.leftDrive.setPower(leftPower);
        robot.rightDrive.setPower(rightPower);
        robot.frontRightDrive.setPower(rightPower);
        robot.frontLeftDrive.setPower(leftPower);
        robot.hook.setPower(hookPower);

        if (gamepad1.y) {
            robot.arm.setPower(1);
        }
        if (gamepad1.a) {
            robot.arm.setPower(-1.0);
        } else {
            robot.arm.setPower(0);
        }

        if (gamepad1.left_bumper) {
            robot.hand.setPower(-1.0);
        }
        if (gamepad1.right_bumper) {
            robot.hand.setPower(1.0);
        } else {
            robot.hand.setPower(0);
        }

        if (gamepad1.x){
            robot.claw.setPosition(0);
        }
        if(gamepad1.b){
            robot.claw.setPosition(1.0);
        }


   /*         if (gamepad1.dpad_up) {
                robot.hook.setPower(1.0);
            }
            if (gamepad1.dpad_down) {
                robot.hook.setPower(-1.0);
            }
            else {robot.hook.setPower(0); */


  /*              telemetry.addData("Status", "Run Time: " + runtime.toString());
                telemetry.addData("Motors", "left (%.2f), right (%.2f), hook (%.2f)", leftPower, rightPower, hookPower);*/
            }

 /*           telemetry.addData("Status", "Run Time: "  runtime.seconds());
            telemetry.addData("Motors", "left (%.2f)," leftPower" ,right (%.2f)," rightPower,"hook (%.2f)", hookPower,);
            telemetry.update();*/
    }




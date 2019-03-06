package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class hardwareMap {

    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor frontLeftDrive = null;
    public DcMotor frontRightDrive = null;
    public DcMotor arm = null;
    public DcMotor hand = null;
    public DcMotor hook = null;
    public Servo claw = null;
    public DcMotor verticalArm = null;

    public static final double midServo =  0.5 ;

    private double armPosition;
    private static double posIncrement = 10;

    HardwareMap hwMap = null;
    private ElapsedTime time = new ElapsedTime();

    public hardwareMap(){
    }

    public void init(HardwareMap ahwMap){
        hwMap = ahwMap;

        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        frontLeftDrive = hwMap.get(DcMotor.class, "front_left_drive");
        frontRightDrive = hwMap.get(DcMotor.class, "front_right_drive");
        arm = hwMap.get(DcMotor.class, "arm");
        hand = hwMap.get(DcMotor.class, "hand");
        hook = hwMap.get(DcMotor.class, "hook");
        claw = hwMap.get(Servo.class, "claw");

        verticalArm = hwMap.get(DCMotor.class, "verticalArm");


        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        arm.setDirection(DcMotor.Direction.REVERSE);
        hook.setDirection(DcMotor.Direction.REVERSE);

        // Set verticalArm Encoder to 0 and turn to RUN TO POSITION Mode. This is done so that
        // the vertical arm can hold position.
        verticalArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        verticalArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        arm.setPower(0);
        hand.setPower(0);
        hook.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0);


    }

    public void extend(){
        this.hook.setPower(1.0);
    }

    public void retract(){
        this.hook.setPower(-1.0);
    }

    public void moveArm(bool inputUp, bool inputDown){
        // Function moves arm an increment up or down from its current position
        if inputUp {
            verticalArm.setTargetPosition(verticalArm.getCurrentPosition() + this.posIncrement)
        } else if inputDown {
            verticalArm.setTargetPosition(verticalArm.getCurrentPosition() - this.posIncrement)
        } else {
            verticalArm.setTargetPosition(verticalArm.getCurrentPosition())
        }
    }

    public void tankDrive(double leftPower, double rightPower){
        this.frontRightDrive.setPower(rightPower);
        this.rightDrive.setPower(rightPower);
        this.frontLeftDrive.setPower(leftPower);
        this.leftDrive.setPower(leftPower);
    }

}

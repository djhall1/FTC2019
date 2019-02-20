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
    public Servo token = null;

    public static final double midServo =  0.5 ;

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
        token = hwMap.get(Servo.class, "token");

        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        arm.setDirection(DcMotor.Direction.REVERSE);
        hook.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        arm.setPower(0);
        hand.setPower(0);
        hook.setPower(0);
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        token.setPosition(0);

    }

    public void extend(){
        this.hook.setPower(1.0);
    }

    public void retract(){
        this.hook.setPower(-1.0);
    }

}

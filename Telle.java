package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Program")
public class Telle extends LinearOpMode {

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor grabyleft = null;
    private DcMotor grabyright = null;
    private Servo dabberj = null;

    @Override
    public void runOpMode() {
        leftDrive = hardwareMap.get(DcMotor.class,"leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class,"rightDrive");
        dabberj = hardwareMap.get(Servo.class,"dabberj");
        leftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        //run until the end of the match (driver presses STOP )
        while (opModeIsActive()) {
            double leftPower = Range.scale(gamepad1.left_stick_y + gamepad1.left_trigger,-1, 1,-1, 1);
            double rightPower = Range.scale (gamepad1.right_stick_y - gamepad1.right_trigger,-1,1,-1,1);
            double up = 0.21;
            double down = 0.71;

            if(gamepad2.a){
                dabberj.setPosition(up);
            }
            if (gamepad2.b){
                dabberj.setPosition(down);
            }


            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
        }
    }
}

package com.example.quantaproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_phoneNum;
    private EditText et_userName;
    private EditText et_validateNum;
    private EditText et_password;
    private EditText et_rePassword;
    private Button bt_validateNum;
    private TimeCount mTimeCount;//计时器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initEvent();  //初始化控件
    }


    private void initEvent() {
        et_phoneNum = findViewById(R.id.et_phoneNum);
        et_userName = findViewById(R.id.et_username);
        et_validateNum = findViewById(R.id.et_validateNum);
        et_password = findViewById(R.id.et_password);
        et_rePassword = findViewById(R.id.et_repassword);
        bt_validateNum = findViewById(R.id.bt_validateNum);
        bt_validateNum.setOnClickListener(this);
        mTimeCount = new TimeCount(60000, 1000);
    }

    /*
    此处需处理验证码的逻辑跳转等
     */

        @Override
        public void onClick (View view){
            switch (view.getId()) {
                case R.id.bt_validateNum:
                    if (!et_phoneNum.getText().toString().trim().equals("")) {
                        if (checkTel(et_phoneNum.getText().toString().trim())) {
                            /*
                            此处需调用获取验证码
                             */
                            mTimeCount.start();
                        } else {
                            Toast.makeText(RegisterActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                    }
                    break;
                    /*
                case R.id.re_landing_btn:
                    if (!userName.getText().toString().trim().equals("")) {
                        if (checkTel(userName.getText().toString().trim())) {
                            if (!validateNum.getText().toString().trim().equals("")) {
                                SMSSDK.submitVerificationCode("+86", userName.getText().toString().trim(), validateNum.getText().toString().trim());//提交验证
                            } else {
                                Toast.makeText(RegisterActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "请输入手机号码", Toast.LENGTH_SHORT).show();
                    }
                    break;
                    */
                case R.id.et_username:
                    if (et_userName.getText().toString().trim().equals("")) {
                        Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.et_password:
                    if (et_password.getText().toString().trim().equals("")) {
                        Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.et_repassword:
                    if(!et_rePassword.getText().toString().trim().equals(et_password.getText().toString().trim())){
                        Toast.makeText(RegisterActivity.this,"两次输入的密码不一致！",Toast.LENGTH_SHORT).show();
                    }
            }
        }

        /**
         * 正则匹配手机号码
         */
        public boolean checkTel (String tel){
            Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
            Matcher matcher = p.matcher(tel);
            return matcher.matches();
        }


        /**
         * 计时器
         */
        class TimeCount extends CountDownTimer {

            public TimeCount(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            //时间变化
            @Override
            public void onTick(long l) {
                bt_validateNum.setClickable(false);
                bt_validateNum.setText(l / 1000 + "秒后重新获取");
            }

            @Override
            public void onFinish() {
                bt_validateNum.setClickable(true);
                bt_validateNum.setText("获取验证码");
            }
        }
    }


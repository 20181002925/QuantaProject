package com.example.quantaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_Register;
    private TextView tv_Login;
    private ImageButton ib_Register;
    private ImageButton ib_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_Register=findViewById(R.id.tv_Register);
        tv_Login=findViewById(R.id.tv_Login);
        ib_Register=findViewById(R.id.ib_Register);
        ib_Login=findViewById(R.id.ib_Login);
        setLinsterners();
    }

    //打包设置监听事件
    private void setLinsterners(){
        OnClick onClick=new OnClick();
        tv_Register.setOnClickListener(onClick);
        tv_Login.setOnClickListener(onClick);
        ib_Register.setOnClickListener(onClick);
        ib_Login.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                case R.id.tv_Register:
                    //跳转到登陆界面
                    intent=new Intent(MainActivity.this,RegisterActivity.class);
                    break;
                case R.id.ib_Register:
                    //跳转到登陆界面
                    intent=new Intent(MainActivity.this,RegisterActivity.class);
                    break;
                case R.id.tv_Login:
                    //跳转到注册界面
                    intent=new Intent(MainActivity.this,LoginActivity.class);
                    break;
                case R.id.ib_Login:
                    //跳转到注册界面
                    intent=new Intent(MainActivity.this,LoginActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}

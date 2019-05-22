package com.example.fragmentpingban;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
    登录界面，实现登录后跳转MainActivity
 */
public class Login extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.editText_user);
        pass = findViewById(R.id.editview_password);
        Button login = findViewById(R.id.login);
        Button regist = findViewById(R.id.regist);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equals("admin")   &&  pass.getText().toString().equals("123")){
                    Intent intent = new Intent(Login.this , MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Login.this , "账号或密码错误",Toast.LENGTH_LONG).show();
                }
            }
        });

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this , "暂未实现",Toast.LENGTH_LONG).show();
            }
        });

    }
}

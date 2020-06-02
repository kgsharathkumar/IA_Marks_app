package com.example.ise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;


    EditText mtextUsername;
    EditText mtextPassword;
    EditText mtextCnfPassword;
    Button mbuttonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db =new DatabaseHelper(this);

        mtextUsername =(EditText)findViewById(R.id.edittext_username);
        mtextPassword =(EditText)findViewById(R.id.edittext_password);
        mtextCnfPassword =(EditText)findViewById(R.id.edittext_cnf_password);
        mbuttonRegister =(Button) findViewById(R.id.button_register);
        mTextViewLogin =(TextView) findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent =new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(LoginIntent);

            }
        });
        mbuttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mtextUsername.getText().toString().trim();
                String pwd = mtextPassword.getText().toString().trim();
                String cnf_pwd = mtextCnfPassword.getText().toString().trim();

                if (pwd.equals(cnf_pwd))
                {
                    long val = db.adduser(user,pwd);
                    if(val>0)
                    {
                        Toast.makeText(RegisterActivity.this, "You have Registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin= new Intent(RegisterActivity.this,MainActivity.class);
                        startActivity(moveToLogin);
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }

                    }

                    else {
                    Toast.makeText(RegisterActivity.this, "Password is not Matching", Toast.LENGTH_SHORT).show();
                }
            }


        });


    }
}




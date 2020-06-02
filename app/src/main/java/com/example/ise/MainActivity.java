package com.example.ise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mtextUsername;
    EditText mtextPassword;
    Button mbuttonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextUsername =(EditText)findViewById(R.id.edittext_username);
        mtextPassword =(EditText)findViewById(R.id.edittext_password);
        mbuttonLogin =(Button) findViewById(R.id.button_login);
        mTextViewRegister =(TextView) findViewById(R.id.textview_register);

        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }

        });

        mbuttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mtextUsername.getText().toString().trim();
                String pwd = mtextPassword.getText().toString().trim();

                String StoredPassword =db.getregister(user);
                if(pwd.equals(StoredPassword)){
                    Toast.makeText(getApplicationContext(), StoredPassword+"Login Successfully", Toast.LENGTH_LONG).show();
                    Intent Homepage=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(Homepage);
                } else {
                    Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();

                }
            }});
    }
}

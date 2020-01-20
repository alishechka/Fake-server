package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Register extends AppCompatActivity {

    private EditText et_userName;
    private EditText et_password;
    private Button btn_register;
    FakeServer fakeServer = new FakeServer();
    public static final String NAME_KEY = "myName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        et_userName = findViewById(R.id.etUserNameReg);
        et_password = findViewById(R.id.etPasswordReg);
        btn_register = findViewById(R.id.btn_loginReg);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userNameToString = et_userName.getText().toString();
                final String passNameToString = et_password.getText().toString();

                if (userNameToString.isEmpty() || passNameToString.isEmpty()) {
                    Toast.makeText(Register.this, "Empty credentials", Toast.LENGTH_LONG).show();
                } else {
                    fakeServer.registerUser(userNameToString, passNameToString);
                    Toast.makeText(Register.this, "!SUCCESS!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Register.this, MainActivity.class);
                    intent.putExtra(NAME_KEY, fakeServer);
                    startActivity(intent);
                }
            }
        });
    }
}

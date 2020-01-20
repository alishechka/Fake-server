package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.loginapplication.Register.NAME_KEY;

public class MainActivity extends AppCompatActivity {
    private EditText et_userName;
    private EditText et_password;
    private Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_userName = findViewById(R.id.etUserName);
        et_password = findViewById(R.id.etPassword);
        btn_login = findViewById(R.id.btn_login);
        final FakeServer fakeServer = getIntent().getParcelableExtra(NAME_KEY);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String strUserName = et_userName.getText().toString();
                final String strUserPass = et_password.getText().toString();
                if (fakeServer.isExistingUser(strUserName, strUserPass)) {
                    Toast.makeText(MainActivity.this, "correct login details", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, Welcome.class);
                    intent.putExtra(NAME_KEY, fakeServer);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}
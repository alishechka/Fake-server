package com.example.loginapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.loginapplication.Register.NAME_KEY;

public class Welcome extends AppCompatActivity {
    private TextView tv_welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tv_welcome = findViewById(R.id.tv_welcome);

        FakeServer fakeServer = getIntent().getParcelableExtra(NAME_KEY);
        String strUser = null;
        if (fakeServer != null) {
            strUser = fakeServer.getName();
        }
        tv_welcome.setText(getString(R.string.welcome_friend, strUser));


    }
}

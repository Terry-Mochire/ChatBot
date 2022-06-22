package com.example.chatbot.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.chatbot.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.signinInstead) TextView  msignInInstead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);
        msignInInstead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == msignInInstead) {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        }
    }
}
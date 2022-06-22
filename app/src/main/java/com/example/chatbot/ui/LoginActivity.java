package com.example.chatbot.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatbot.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.createnewac) TextView mCreateNewAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        mCreateNewAcc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if( v == mCreateNewAcc) {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

        }
    }
}
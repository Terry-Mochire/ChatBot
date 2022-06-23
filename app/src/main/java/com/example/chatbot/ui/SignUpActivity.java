package com.example.chatbot.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatbot.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.signinInstead) TextView  msignInInstead;
    @BindView(R.id.editName) EditText mEditName;
    @BindView(R.id.editEmail) EditText mEditEmail;
    @BindView(R.id.editPass) EditText mEditPass;
    @BindView(R.id.createAcount) Button mCreateAccount;

    private FirebaseAuth mAuth;
    static String TAG = SignUpActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);
        msignInInstead.setOnClickListener(this);
        mCreateAccount.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        if (v == msignInInstead) {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        }
        if (v == mCreateAccount) {
            createNewUser();
        }
    }

    private void createNewUser() {

        final String name = mEditName.getText().toString().trim();
        final  String email = mEditEmail.getText().toString().trim();
        String password = mEditPass.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Authentication successful");
                    } else {
                        Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        }
    }

package net.tuyenoc.practice2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btSignIn;
    private ProgressBar pbLoading;
    private EditText etUsername, etPassword;
    private AuthenticationService authentication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        pbLoading = findViewById(R.id.pbLoading);
        btSignIn = findViewById(R.id.btSignIn);

        authentication = AuthenticationService.getInstance();

        btSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String username = etUsername.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        if (username.isEmpty()) {
            etUsername.setError("Username cannot be empty");
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password cannot be empty");
            return;
        } else {
            btSignIn.setVisibility(View.INVISIBLE);
            pbLoading.setVisibility(View.VISIBLE);
            authentication.signInWithUsernameAndPassword(username, password, new SignInCallBack() {
                @Override
                public void onSuccess(String username) {
                    btSignIn.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.INVISIBLE);
                    Toast.makeText(SignInActivity.this, "Sign in success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignInActivity.this, MainActivity.class).putExtra("username", username));
                    finish();
                }

                @Override
                public void onFailed(String message) {
                    btSignIn.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.INVISIBLE);
                    Toast.makeText(SignInActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}


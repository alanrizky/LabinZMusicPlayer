package lmp.labinzmusicplayer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import lmp.labinzmusicplayer.R;
import lmp.labinzmusicplayer.splash.SplashForgotPassword;

public class ForgotPasswordActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void BackHandle(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        finish();
        startActivity(i);
    }

    public void ResetPasswordSuccessHandler(View view) {
        Intent i = new Intent(this, SplashForgotPassword.class);
        finish();
        startActivity(i);
    }
}

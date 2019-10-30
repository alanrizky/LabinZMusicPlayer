package lmp.labinzmusicplayer.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import lmp.labinzmusicplayer.R;
import lmp.labinzmusicplayer.activities.LoginActivity;

public class SplashForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_forgot_password);

        Thread t = new Thread() {
            public void run() {
                try {
                    super.run();
                    sleep(2000);
                } catch (Exception e) {

                } finally {
                    Intent i = new Intent(SplashForgotPassword.this, LoginActivity.class);
                    finish();
                    startActivity(i);
                }
            }
        };
        t.start();
    }
}


package lmp.labinzmusicplayer.splash;

import androidx.appcompat.app.AppCompatActivity;

import lmp.labinzmusicplayer.MainActivity;
import lmp.labinzmusicplayer.R;

import android.content.Intent;
import android.os.Bundle;


public class SplashLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_login);

        Thread t = new Thread() {
            public void run() {
                try {
                    super.run();
                    sleep(2750);
                } catch (Exception e) {

                } finally {
                    Intent i = new Intent(SplashLogin.this, MainActivity.class);
                    finish();
                    startActivity(i);
                }
            }
        };
        t.start();
    }
}

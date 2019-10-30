package lmp.labinzmusicplayer.splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import lmp.labinzmusicplayer.R;
import lmp.labinzmusicplayer.activities.LoginActivity;

public class SplashCreateAccount extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_create_account);



        Thread t = new Thread() {
            public void run() {
                try {
                    super.run();
                    sleep(2000);
                } catch (Exception e) {

                } finally {
                    Intent i = new Intent(SplashCreateAccount.this, LoginActivity.class);
                    finish();
                    startActivity(i);
                }
            }
        };
        t.start();
    }
}

package lmp.labinzmusicplayer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import lmp.labinzmusicplayer.R;
import lmp.labinzmusicplayer.splash.SplashLogin;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Sign In";

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private EditText edtEmail;
    private EditText edtPass;
    private ImageView btnMasuk;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        edtEmail = findViewById(R.id.activityLogin_usernameInput);
        edtPass = findViewById(R.id.activityLogin_passwordInput);
        btnMasuk = findViewById(R.id.activityLogin_loginImage);


        btnMasuk.setOnClickListener(this);

    }

    private void signIn() {
        Log.d(TAG, "signIn");
        if (!validateForm()) {
            return;
        }

        String email = edtEmail.getText().toString();
        String password = edtPass.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInUser:onComplete: " + task.isSuccessful());

                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login Successful",
                                    Toast.LENGTH_SHORT).show();
                            SuccessfulLoginHandle();

                        }
                        else {
                            edtEmail.setError("User not found");
                            Toast.makeText(LoginActivity.this, "Check your username and password",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean validateForm() {
        boolean result = true;

        if (TextUtils.isEmpty(edtEmail.getText().toString())) {
            edtEmail.setError("Required");
            edtEmail.requestFocus();
            result = false;
        }

        if (TextUtils.isEmpty(edtPass.getText().toString())) {
            edtPass.setError("Required");
            edtPass.requestFocus();
            result = false;
        } else {
            edtPass.setError(null);
        }
        return result;
    }


    public void ForgotPasswordHandle(View view) {
        Intent i = new Intent(this, ForgotPasswordActivity.class);
        startActivity(i);
    }

    public void CreateNewAccountHandle(View view) {
        Intent i = new Intent(this, CreateAccountActivity.class);
        startActivity(i);
    }

    public void SuccessfulLoginHandle() {
        Intent i = new Intent(this, SplashLogin.class);
        finish();
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.activityLogin_loginImage) {
            signIn();
        }
    }
}

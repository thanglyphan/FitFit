package fitnessappen.fitfit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    EditText email; // EMAIL TODO: Change this.
    EditText password;
    private FirebaseUser user;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("LOL", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("LOL", "onAuthStateChanged:signed_out");
                }
            }
        };
        email = (EditText)findViewById(R.id.emailTxt);
        password = (EditText)findViewById(R.id.passwordTxt);

        Intent intent = getIntent();
        String loginname = intent.getStringExtra("Email");
        String loginpw = intent.getStringExtra("Password");

        if(intent != null){
            email.setText(loginname);
            password.setText(loginpw);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void loginClick(View v){
        final String emailAddress = email.getText().toString();
        final String passwordLol = password.getText().toString();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(emailAddress, passwordLol)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent accountIntent = new Intent(LoginActivity.this, YourAccountActivity.class);
                            startActivity(accountIntent);
                            LoginActivity.this.finish();
                        } else{
                            Toast.makeText(LoginActivity.this, "Login failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        //Finish signing in.
    }

    public void createAccountClick(View v){
        Intent createAccountIntent = new Intent(this, CreateNewAccountActivity.class);
        startActivity(createAccountIntent);
        LoginActivity.this.finish();
    }

}

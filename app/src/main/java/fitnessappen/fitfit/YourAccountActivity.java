package fitnessappen.fitfit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public class YourAccountActivity extends AppCompatActivity {

    private TextView yourNameTxt;

    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_account);
        yourNameTxt = (TextView)findViewById(R.id.yourNameTxt);
        user = FirebaseAuth.getInstance().getCurrentUser();
        yourNameTxt.setText(user.getUid());

        Log.d("Your acount", "" + user.getUid());
    }

}

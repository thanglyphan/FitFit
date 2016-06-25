package fitnessappen.fitfit;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.http.OkHttpClientFactory;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;
import com.squareup.okhttp.OkHttpClient;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.usernameTxt);
        password = (EditText)findViewById(R.id.passwordTxt);

        Intent intent = getIntent();
        String loginname = intent.getStringExtra("Username");
        String loginpw = intent.getStringExtra("Password");

        if(intent != null){
            username.setText(loginname);
            password.setText(loginpw);
        }
    }

    public void loginClick(View v){
        Connect con = new Connect();
        if(con.checkConnection(username.getText().toString(), password.getText().toString())){
            Intent accountIntent = new Intent(this, YourAccountActivity.class);
            startActivity(accountIntent);
            LoginActivity.this.finish();

        }else{
            Toast.makeText(this, "Invalid user", Toast.LENGTH_SHORT).show();
        }
    }

    public void createAccountClick(View v){
        Intent createAccountIntent = new Intent(this, CreateNewAccountActivity.class);
        startActivity(createAccountIntent);
        LoginActivity.this.finish();
    }

}

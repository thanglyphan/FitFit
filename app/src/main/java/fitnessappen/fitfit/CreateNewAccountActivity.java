package fitnessappen.fitfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNewAccountActivity extends AppCompatActivity {
    EditText Firstname;
    EditText Lastname;
    EditText Email;
    EditText Username;
    EditText Password;
    EditText PasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);

        Firstname = (EditText)findViewById(R.id.firstnameEdit);
        Lastname = (EditText)findViewById(R.id.lastnameEdit);
        Email = (EditText)findViewById(R.id.emailEdit);
        Username = (EditText)findViewById(R.id.newUsernameEdit);
        Password = (EditText)findViewById(R.id.newPasswordEdit);
        PasswordConfirm = (EditText)findViewById(R.id.newPasswordConfirmEdit);

    }

    public void createNewAccountClick(View v){
        String firstname = Firstname.getText().toString();
        String lastname = Lastname.getText().toString();
        String email = Email.getText().toString();
        String username = Username.getText().toString();
        String password = Password.getText().toString();
        String pwconfirm = PasswordConfirm.getText().toString();


        CheckRequired check = new CheckRequired(firstname, lastname, email, username, password, pwconfirm);
        switch (check.recquired()){
            case "firstname": Toast.makeText(this, "Firstname is not valid", Toast.LENGTH_SHORT).show(); break;
            case "lastname": Toast.makeText(this, "Lastname is not valid", Toast.LENGTH_SHORT).show();break;
            case "email": Toast.makeText(this, "Email is not valid", Toast.LENGTH_SHORT).show();break;
            case "username": Toast.makeText(this, "Username is not valid", Toast.LENGTH_SHORT).show();break;
            case "password": Toast.makeText(this, "Password minimum 6 characters", Toast.LENGTH_SHORT).show();break;
            case "pwconfirm": Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();break;
            default:
                if(check.checkRequiredFields() && check.checkPwConfirmed()){
                    User user = new User(firstname, lastname, email, username, password);
                    Toast.makeText(this, "Account created ish", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(CreateNewAccountActivity.this, LoginActivity.class);
                    mainIntent.putExtra("Username", username);
                    mainIntent.putExtra("Password", password);
                    CreateNewAccountActivity.this.startActivity(mainIntent);
                    CreateNewAccountActivity.this.finish();
                    //TODO: Add to database this user.
                }else{
                    Toast.makeText(this, "Account not created", Toast.LENGTH_SHORT).show();
                }

        }


    }
}

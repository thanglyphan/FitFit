package fitnessappen.fitfit;

/**
 * Created by Thang on 25.06.2016.
 */
public class CheckRequired {

    private String Username;
    private String Password;
    private String Email;
    private String FirstName;
    private String LastName;
    private String PasswordConfirm;

    public CheckRequired(String a, String b, String c, String d, String e, String f){
        this.FirstName = a;
        this.LastName = b;
        this.Email = c;
        this.Username = d;
        this.Password = e;
        this.PasswordConfirm = f;
    }

    public boolean checkRequiredFields(){
        if(Username != "" && Password != "" && Email != "" && Username != "" && Password != "" && PasswordConfirm != ""){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkPwConfirmed(){
        return Password.equals(PasswordConfirm);
    }

    public String recquired(){
        if(FirstName.equals("")){
            return "firstname";
        }else if(LastName.equals("")){
            return "lastname";
        }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            return "email";
        }else if(Username.equals("")){
            return "username";
        }else if(Password.length() < 6){
            return "password";
        }else if(!Password.equals(PasswordConfirm)){
            return "pwconfirm";
        }else{
            return "";
        }
    }
}

package fitnessappen.fitfit;

/**
 * Created by Thang on 25.06.2016.
 */
public class User
{
    private String Username;
    private String Password;
    private String Email;
    private String FirstName;
    private String LastName;

    public User(String a, String b, String c, String d, String e){
        this.FirstName = a;
        this.LastName = b;
        this.Email = c;
        this.Username = d;
        this.Password = e;
    }
}

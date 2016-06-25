package fitnessappen.fitfit;

/**
 * Created by Thang on 25.06.2016.
 */
public class Connect {
    private static String username;
    private static String password;

    public Connect(){
        this.username = "Thang";
        this.password = "lolert";
    }

    public static boolean checkConnection(String a, String b){
        if(a.equals(username) && b.equals(password)){
            return true;
        }else{
            return false;
        }
    }
}

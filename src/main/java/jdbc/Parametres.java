package jdbc;

public class Parametres {
    
    private static String password = "simplon93100";
    private static String user = "root";
    private static String url = "jdbc:mysql://localhost:3306/cinema?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
     
    public static String getPassword() {
        return password;
    }
    public static String getUrl() {
        return url;
    }
    public static String getUser() {
        return user;
    }
}
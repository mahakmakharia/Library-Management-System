package javaapplication1;

/**
 *
 * @author Osama
 */
public class User {

    private String UserType;
    private String UserName;
    private String Password;
    private int UserId;

    public User(String userType, String userName, String password, int userId) {

        UserType = userType;
        UserName = userName;
        Password = password;
        UserId = userId;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

}

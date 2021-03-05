package javaapplication1;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Osama
 */
public class LoginManager {

    private MainManager mainMgr;

    LoginManager(MainManager mainMgr) {
        this.mainMgr = mainMgr;
    }

    public String verifyUser(int userId, String passwords, String userType) {

        String path = "data/user.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            String file;
            int userid = userId;
            String password = passwords;

            while ((file = br.readLine()) != null) {
                String data[] = file.split(",");

                if (userid == Integer.parseInt(data[3]) && password.equals(data[2]) && userType.equals(data[0])) {
                    return userType;
                }
            }
            br.close();

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;

    }

    public boolean showDashboard(String userType) {
        if (userType == "admin") {
            return true;
        }
        return false;

    }

//    public static void main(String args[]) {
//        LoginManager mgr = new LoginManager();
//        assert (mgr.verifyUser(123, "password", "admin") != null);
//        assert (mgr.showDashboard("admin"));
//    }
}

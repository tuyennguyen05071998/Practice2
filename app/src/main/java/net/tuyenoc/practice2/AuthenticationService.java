package net.tuyenoc.practice2;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {
    private List<User> users;

    private static AuthenticationService instance;

    public static AuthenticationService getInstance(){
        if (instance == null)
            instance = new AuthenticationService();
        return instance;
    }

    private AuthenticationService() {
        this.users = new ArrayList<>();
        for (int i = 1; i <= 5;i++){
            this.users.add(new User("admin" + i, "admin" + i));
        }
    }
    private boolean verifyUser(String username, String password){
        for (User user : users){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public void signInWithUsernameAndPassword(final String username, final String password, final SignInCallBack signInCallBack){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (verifyUser(username, password)){
                    signInCallBack.onSuccess(username);
                }
                else{
                    signInCallBack.onFailed("Username or password is incorrect");
                }
            }
        };
        new Handler().postDelayed(runnable, 2000);
    }
}

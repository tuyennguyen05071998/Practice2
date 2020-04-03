package net.tuyenoc.practice2;

public interface SignInCallBack {
    void onSuccess(String username);
    void onFailed(String message);
}

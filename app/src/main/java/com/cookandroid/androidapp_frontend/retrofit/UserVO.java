package com.cookandroid.androidapp_frontend.retrofit;

public class UserVO {

    String userIdx;
    String userId;
    String userPw;

    public String getUserIdx(){return  userIdx;}

    public void setUserIdx(String userIdx){this.userIdx = userIdx;}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) { this.userId = userId; }

    public String getuserPw() {
        return userPw;
    }

    public void setuserPw(String userPw) {this.userPw = userPw;}

}

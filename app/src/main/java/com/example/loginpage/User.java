package com.example.loginpage;

public class User {
    private String userFullName,mobileNumber,userEmail,userPassword;


    public User(){}

    public String getUserFullName(){
        return userFullName;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
    public String getUserEmail(){
        return userEmail;
    }
    public String getUserPassword(){
        return userPassword;
    }

    public void setUserFullName(String userName){
        userFullName=userName;
    }
    public void setMobileNumber(String mob){
        mobileNumber=mob;
    }
    public void setEmail(String email){
        userEmail=email;
    }
    public void setPassword(String pass){
        userPassword=pass;
    }

}

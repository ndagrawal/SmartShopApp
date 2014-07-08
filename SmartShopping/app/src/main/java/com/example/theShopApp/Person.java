package com.example.theShopApp;

import android.util.Log;

import java.util.regex.Pattern;

/**
 * Created by NileshAgrawal on 7/6/14.
 */
public class Person {

    int id;
    String FirstName;
    String LastName;
    String Username;
    String emailid;
    String password;
    String Re_password;

    public Person(String firstName, String lastName, String username, String emailid, String password, String re_password) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Username = username;
        this.emailid = emailid;
        this.password = password;
        this.Re_password = re_password;
    }


    public String getRe_password() {
        return Re_password;
    }

    public void setRe_password(String re_password) {
        Re_password = re_password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public boolean password_authenticate(String password,String Re_password){

        if(password.equals(Re_password)){
            return true;
        }else {
            Log.d(Constants.SIGN_UP_LOGCAT, "Password not same.");
            return false;
        }
    }

    public boolean password_criteria(String password,String Re_password){

        //a password should have one special characters.
        //a password should have one capital letter.
        // a password should be minimum 6 charaters.
        // password should have mininum 1 number.

        if(password.length()<6){
            Log.d(Constants.SIGN_UP_LOGCAT,"Password should be minimum 6 characters");
            return false;
        }

        if(!password.contains(" ")){
            Log.d(Constants.SIGN_UP_LOGCAT,"Password Contains space");
            return false;
        }

        if (!Pattern.matches("\\p{Punct}", password)) {
            Log.d(Constants.SIGN_UP_LOGCAT,"Password Does no contain special character");
            return false;

        }

        //TODO: To check for the conditions.

/*        String s = "blah-FOO-test-1-2-3";

        if (!( s.matches(".*[0-9].*") && s.matches(".*[A-Z].*") )) {
            System.out.println("In Valid!");
            return false;
        }
*/
        return true;
    }

}

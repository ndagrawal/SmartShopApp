package com.example.theShopApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.theShopApp.R;

public class SignupActivity extends Activity {


    EditText etSignUpUserName,etSignUpPassword,etSignUpRePassword,etSignUpEmailId,etSignUpFirstName,etSignUpLastName;
    Button bNewAccount;

    public void initialise(){
        etSignUpUserName = (EditText)findViewById(R.id.etSignupUsername);
        etSignUpPassword = (EditText)findViewById(R.id.etPassword);
        etSignUpRePassword = (EditText)findViewById(R.id.etRePassword);
        etSignUpEmailId = (EditText)findViewById(R.id.etEmailId);
        etSignUpFirstName = (EditText)findViewById(R.id.etSigninFirstName);
        etSignUpLastName = (EditText)findViewById(R.id.etSigninLastName);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup);
        initialise();

        bNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String FirstName = etSignUpFirstName.getText().toString();
            String LastName = etSignUpLastName.getText().toString();
            String username = etSignUpUserName.getText().toString();
            String password = etSignUpPassword.getText().toString();
            String re_password = etSignUpRePassword.getText().toString();
            String emailid = etSignUpEmailId.getText().toString();

            Person personObject = new Person(FirstName,LastName,username, emailid,password, re_password);

           // Database.createAccount(personObject);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.signup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}


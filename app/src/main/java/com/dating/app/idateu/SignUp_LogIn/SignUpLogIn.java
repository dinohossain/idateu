package com.dating.app.idateu.SignUp_LogIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dating.app.idateu.Homepage.HomePage;
import com.dating.app.idateu.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpLogIn extends AppCompatActivity
    {
    String fakeEmail = "t@g.com";
    String fakePass = "test";

    Button register_btn;
    Button login_btn;

    EditText email_edit;
    EditText pass_edit;

    TextView noRecordMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_view);
        noRecordMsg=findViewById(R.id.no_record);
        noRecordMsg.setVisibility(View.INVISIBLE);
        email_edit = findViewById(R.id.emailInput);
        pass_edit = findViewById(R.id.passwordInput);

        register_btn = (Button)findViewById(R.id.register_button);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
                {
                startActivity(new Intent(SignUpLogIn.this, SecondSignUpPage.class));
                }
        });

        login_btn = (Button)findViewById(R.id.login_button);
        login_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                if(noUserError()) startActivity(new Intent(SignUpLogIn.this, HomePage.class));
                }
            });
        }

        private boolean noUserError()
            {
            boolean status = false;
            String email = email_edit.getText().toString();
            String password = pass_edit.getText().toString();
            if (isEmailValid(email)
                && didUserTypeInPassword(password)
                && doesRecordExistInDB(email,password))
                {
                status = true;
                }
            return status;}

        private boolean doesRecordExistInDB(String email, String password)
            {
            if (email.equals(fakeEmail) && password.equals(fakePass)) return true;
            noRecordMsg.setVisibility(View.VISIBLE);
            return false;
            }

        private boolean isEmailValid(String s)
            {
                Pattern VALID_EMAIL_ADDRESS_REGEX =
                        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(s);
                boolean stat = matcher.find() == true ? true : false;
                if (!stat) email_edit.setError("Invalid Email");
                return stat;
            }

        private boolean didUserTypeInPassword(String password)
            {
            if (password.length() > 0) return true;
            else
                {
                pass_edit.setError("Enter your password");
                return false;
                }
            }


    }
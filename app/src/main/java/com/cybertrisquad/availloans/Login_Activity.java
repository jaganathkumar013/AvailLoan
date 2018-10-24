package com.cybertrisquad.availloans;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {
    private EditText main_username,main_password;
    private Button main_button;
    private TextView main_attempts,main_forgotpasseord;
    private FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    private FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
    private int count=5;
    private String name,password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        setUIViews();
        main_attempts.setText("No.of.attempts remaining:5");



main_forgotpasseord=(TextView) findViewById(R.id.login_forgotpassword);
main_forgotpasseord.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Login_Activity.this,Forgot_password.class));
        finish();
    }
});

        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    validate(main_username.getText().toString(), main_password.getText().toString());
            }
        });
    }

    private void setUIViews() {
        main_username=(EditText) findViewById(R.id.login_email);
        main_password=(EditText) findViewById(R.id.login_password);
        main_button=(Button) findViewById(R.id.login_button);
        main_attempts=(TextView) findViewById(R.id.login_noattempts);
        main_forgotpasseord=(TextView) findViewById(R.id.login_forgotpassword);
    }

    private Boolean validate(String s, String s1) {
        Boolean result=true;
        name=main_username.getText().toString().trim();
        password=main_password.getText().toString().trim();
        if (name.isEmpty() || password.isEmpty()){
            Toast.makeText(Login_Activity.this,"Enter all the above Details ",Toast.LENGTH_SHORT).show();
        }
        else {

            firebaseAuth.signInWithEmailAndPassword(s, s1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        checkEmailVerification();
                    } else {
                        Toast.makeText(Login_Activity.this, "Login failed,please check your email Address and password", Toast.LENGTH_SHORT).show();
                        count--;
                        main_attempts.setText("No.of.attempts remaining" + count);
                        if (count == 0) {
                            main_button.setEnabled(false);
                        }
                    }
                }
            });
        }
return result;
    }
    private void checkEmailVerification() {
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag = firebaseUser.isEmailVerified();
        startActivity(new Intent(Login_Activity.this, Otp.class));


    }
}

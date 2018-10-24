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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration_Activity extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;
    private Button register_activity_button;
    private String name,age,email,password,contact;
    private String message;
    private TextView tvdisp;
    private EditText register_activity_username,register_activity_age,register_activity_email,register_activity_contactno,register_activity_passowrd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();
        register_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {
                    String user_email = register_activity_email.getText().toString().trim();
                    String user_password = register_activity_passowrd.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                sendUserData();
                                Toast.makeText(Registration_Activity.this, "Registration Successfull,return to Login", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Registration_Activity.this, Options.class));

                            } else {
                                Toast.makeText(Registration_Activity.this, "Registration failed, please try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
    }
    private void setupUIViews() {
        register_activity_username=(EditText) findViewById(R.id.register_username);
        register_activity_age=(EditText) findViewById(R.id.register_age);
        register_activity_email=(EditText) findViewById(R.id.register_email);
        register_activity_contactno=(EditText) findViewById(R.id.register_contactno);
        register_activity_passowrd=(EditText) findViewById(R.id.register_password);
        register_activity_button=(Button) findViewById(R.id.register_button);
        tvdisp=(TextView) findViewById(R.id.textvisi);

    }

    private boolean validate() {
        Boolean result=false;
        name=register_activity_username.getText().toString().trim();
        age=register_activity_age.getText().toString().trim();
        contact=register_activity_contactno.getText().toString().trim();
        email=register_activity_email.getText().toString().trim();
        password=register_activity_passowrd.getText().toString().trim();

        if(password.length()<7) {
            tvdisp.setVisibility(View.VISIBLE);

        if (name.isEmpty() || age.isEmpty() || contact.isEmpty() || email.isEmpty() || password.isEmpty() || password.length()<7){

                Toast.makeText(Registration_Activity.this, "please check all the above details", Toast.LENGTH_SHORT).show();
            }}
        else{
            result=true;
        }
        return result;
    }


    private void sendUserData() {

         firebaseDatabase=FirebaseDatabase.getInstance();
         databaseReference=firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid()).child("register");
        databaseReference.child("Name").setValue(name);
        databaseReference.child("age").setValue(age);
        databaseReference.child("email").setValue(email);
        databaseReference.child("contact no").setValue(contact);


    }





}


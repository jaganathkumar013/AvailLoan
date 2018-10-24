package com.cybertrisquad.availloans;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Auto_loan  extends AppCompatActivity implements View.OnClickListener{

    private String email;
    private String subject;
    private String message;
    private Button submit;
    private FirebaseAuth firebaseAuth;
    private EditText vname,vage,vcontactno,salary_self,vincome,required;
    private String name,age,contactno,salary,income,require;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_layout);

        submit=(Button) findViewById(R.id.auto_submit);
        submit.setOnClickListener(this);

    }
    private void sendEmail() {
        sendUIViews();
        if(validate()){

        email="enterpriseaandl@gmail.com";
        subject="Auto Loan";
        message="Name:- "+name+"\n"+"Age:-"+age+"\n"+"Contact No:-"+contactno+"\n"+"Salary/Self-Employed:-"+salary+"\n"
                +"Monthly Income:-"+income+"\n"+"Loan Required Amount:-"+require;
        //Getting content for email



        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
            startActivity(new Intent(Auto_loan.this,Menu.class));

        }
    }
    private Boolean validate() {
        Boolean result=false;

        name=vname.getText().toString().trim();
        age=vage.getText().toString().trim();
        contactno=vcontactno.getText().toString().trim();
        salary=salary_self.getText().toString().trim();
        income=vincome.getText().toString().trim();
        require=required.getText().toString().trim();

        if( name.isEmpty()|| age.isEmpty() || contactno.isEmpty() || salary.isEmpty()|| income.isEmpty() || require.isEmpty() )
        {
            Toast.makeText(Auto_loan.this,"please enter all the details above",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result=true;
        }
        return result;
    }

    private void sendUIViews() {
        vname=(EditText) findViewById(R.id.auto_name);
        vage=(EditText) findViewById(R.id.auto_age);
        vcontactno=(EditText) findViewById(R.id.auto_email);
        salary_self=(EditText) findViewById(R.id.auto_salary_self);
        vincome=(EditText) findViewById(R.id.auto_income);
        required=(EditText) findViewById(R.id.auto_require);

    }


    @Override
    public void onClick(View v) {
        sendEmail();
    }

}
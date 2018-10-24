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

public class Credit_card_activity  extends AppCompatActivity implements View.OnClickListener {

    private String email;
    private String subject;
    private String message;
    private Button submit;
    private FirebaseAuth firebaseAuth;
    private EditText vname,vage,vcontactno,salary_self,vincome,creditcard;
    private String name,age,contactno,salary,income,card;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_card);

        submit=(Button) findViewById(R.id.credit_submit);
        submit.setOnClickListener(this);

    }
    private void sendEmail() {
        sendUIViews();
        if(validate()) {

            email = "enterpriseaandl@gmail.com";
            subject = "Home Loan";
            message = "Name:- "+name+"\n"+"Age:-"+age+"\n"+"Contact No:-"+contactno+"\n"+"Salary/Self-Employed:-"+salary+"\n"
                    +"Monthly Income:-"+income+"\n"+"Bank for Card:-"+card;
            //Getting content for email


            //Creating SendMail object
            SendMail sm = new SendMail(this, email, subject, message);

            //Executing sendmail to send email
            sm.execute();
            startActivity(new Intent(Credit_card_activity.this,Menu.class));
        }

    }
    private Boolean validate() {
        Boolean result=false;

        name=vname.getText().toString().trim();
        age=vage.getText().toString().trim();
        contactno=vcontactno.getText().toString().trim();
        salary=salary_self.getText().toString().trim();
        income=vincome.getText().toString().trim();
        card=creditcard.getText().toString().trim();

        if( name.isEmpty()|| age.isEmpty() || contactno.isEmpty() || salary.isEmpty()|| income.isEmpty() || card.isEmpty() )
        {
            Toast.makeText(Credit_card_activity.this,"please enter all the details above",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result=true;
        }
        return result;
    }

    private void sendUIViews() {
        vname=(EditText) findViewById(R.id.credit_name);
        vage=(EditText) findViewById(R.id.credit_age);
        vcontactno=(EditText) findViewById(R.id.credit_email);
        salary_self=(EditText) findViewById(R.id.credit_salary_self);
        vincome=(EditText) findViewById(R.id.credit_income);
        creditcard=(EditText) findViewById(R.id.credit_Bankneed);

    }


    @Override
    public void onClick(View v) {
        sendEmail();

    }
}

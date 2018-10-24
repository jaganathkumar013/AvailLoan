package com.cybertrisquad.availloans;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Menu  extends AppCompatActivity {

    private CardView homeloan,personalloan,bussinessloan,vehicleloan,autoloan,mortgageloan,loanagainstproperties,creditcard,insurance,logout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        homeloan=(CardView) findViewById(R.id.homeloan);
        personalloan=(CardView) findViewById(R.id.Personal_loan);
        bussinessloan=(CardView) findViewById(R.id.Bussiness_loan) ;
        vehicleloan=(CardView) findViewById(R.id.Vehicle_loan) ;
        autoloan=(CardView) findViewById(R.id.Auto_loan) ;
        mortgageloan=(CardView) findViewById(R.id.Mortgage_loan) ;
        loanagainstproperties=(CardView) findViewById(R.id.Loan_against_properties) ;
        creditcard=(CardView) findViewById(R.id.Credit_card) ;
        insurance=(CardView) findViewById(R.id.Insurance) ;
        logout=(CardView) findViewById(R.id.menu_logout);

        homeloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Home_Loan.class));

            }
        });

        personalloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Personal_Loan.class));

            }
        });
        bussinessloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Bussiness_activity.class));

            }
        });
        vehicleloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Vehicle_Loan.class));

            }
        });
        autoloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Auto_loan.class));

            }
        });
        mortgageloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Mortgage_loan.class));

            }
        });
        loanagainstproperties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Loan_against_properties_activity.class));

            }
        });
        creditcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Credit_card_activity.class));

            }
        });
        insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Insurance.class));

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               moveTaskToBack(true);
               android.os.Process.killProcess(android.os.Process.myPid());
               System.exit(1);

            }
        });















    }
}

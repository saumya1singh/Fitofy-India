package com.saumya.fitofyindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginIndividual extends AppCompatActivity {
    // TextView tvMessage;
    EditText etPhone,etName;
    String phonenumber, name;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_individual);
        etPhone=findViewById(R.id.etPhone);
        etName=findViewById(R.id.etName);
        btnNext=findViewById(R.id.btnjoin);
        etName.requestFocus();

        etPhone.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_NAVIGATE_NEXT){
                    login();
                    return true;
                }
                return false;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    private boolean checkValid() {
        boolean check =true;
        if(TextUtils.isEmpty(phonenumber))
        {
            etPhone.setError("Required");
            check=false;
        }
        if(TextUtils.isEmpty(name))
        {
            etPhone.setError("Required");
            check=false;
        }
        if( !(phonenumber.length()==10))
        {
            etPhone.setError("Not valid");
            check=false;
        }
        return check;
    }
    private void login(){
        phonenumber=etPhone.getText().toString();
        name=etName.getText().toString();
        if(checkValid())
        {
            phonenumber="+91"+phonenumber;
            Intent intent = new Intent(LoginIndividual.this, IndividualMain.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }

}

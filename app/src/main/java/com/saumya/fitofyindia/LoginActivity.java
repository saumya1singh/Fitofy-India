package com.saumya.fitofyindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etPassword, etEmail;
    TextView tvRegister;
    String email,password;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        tvRegister = findViewById(R.id.tvRegister);
        auth=FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=etEmail.getText().toString();
                password=etPassword.getText().toString();
                if(checkvalidation()){
                    auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {
                                        Log.d("tag", "signInWithEmail:success");
                                        Intent i = new Intent(getBaseContext(), AfterLogin.class);
                                        startActivity(i);

                                        finish();

                                    }
                                    else
                                    {
                                        Toast.makeText(LoginActivity.this,"Aithentication Failed",Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }

            }
        });


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(i);
            }
        });



    }

    private boolean checkvalidation() {
        boolean check=true;

        if (TextUtils.isEmpty(email))
        {
            etEmail.setError("Required");
            check=false;
        }
        if (TextUtils.isEmpty(password))
        {
            etPassword.setError("Required");
            check=false;
        }
        return  check;
    }

}

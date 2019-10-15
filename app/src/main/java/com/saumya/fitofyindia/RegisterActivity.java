package com.saumya.fitofyindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth auth;
    String email, password , Organisation;
    EditText etEmail, etPassword, etOrganisation;
    Button btnSignUp;
    SharedPreferences sharedPreferences;


    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        etOrganisation = findViewById(R.id.etOrganisation);
        auth = FirebaseAuth.getInstance();


        firebaseDatabase = FirebaseDatabase.getInstance("https://fitofyindia.firebaseio.com/");
        sharedPreferences = getSharedPreferences("Organisation", Context.MODE_PRIVATE);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Organisation = etOrganisation.getText().toString();
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();


               // databaseReference = firebaseDatabase.getReference("Organisation/" );
               // databaseReference.child(Organisation).push();


                if (chekvalidation()) {
                    auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Log.d("tag", "createUserWithEmail:success");

                                        Intent intent = new Intent(RegisterActivity.this, AfterLogin.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Log.e("tag", "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("OrgName", Organisation);
                editor.apply();


            }
        });


    }

    private boolean chekvalidation() {
        boolean check = true;
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Required");
            check = false;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Required");
            check = false;
        }

        if (etOrganisation.getText().toString().isEmpty()){
            etOrganisation.setError("Required");
            check = false;
        }
        return check;
    }
}

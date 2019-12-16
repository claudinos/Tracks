package com.moringa.tracks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{


    public static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.passwordLoginButton)
    Button mPasswordLoginButton;
    @BindView(R.id.emailEditText)
    EditText mEmailEditText;
    @BindView(R.id.usernameEditText)
    EditText mUsernameEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.registerTextView)
    TextView mRegisterTextView;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mAuthProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mRegisterTextView.setOnClickListener(this);
        mPasswordLoginButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){

        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if(user != null){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        }
    };
    createAuthProgressDialog();
}
    private void createAuthProgressDialog(){
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Authenticating with Firebase...");
        mAuthProgressDialog.setCancelable(false);
    }

    @Override
    public void onClick(View v) {
        if(v == mRegisterTextView){
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }
        if (v == mPasswordLoginButton){
            loginWithPassword();
        }
    }
    private void loginWithPassword(){

        String username = mUsernameEditText.getText().toString().trim();
        String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        SharedPreferences mySharedPreferences = this.getSharedPreferences("com.moringa.tracks", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString("username",username);
        editor.apply();

        if(email.equals("")){
            mEmailEditText.setError("Please Enter Your Email");
            return;
        }
        if(password.equals("")){
            mPasswordEditText.setError("Password cannot be blank");
            return;
        }
        mAuthProgressDialog.show();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                mAuthProgressDialog.dismiss();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("name",username);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                if(!task.isSuccessful()){
                    Log.w(TAG, "signInWithEmail", task.getException());
                    Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_LONG).show();
                }
                if(task.isSuccessful()){

                    Toast.makeText(LoginActivity.this, "Welcome to Tracks", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListener);
}}

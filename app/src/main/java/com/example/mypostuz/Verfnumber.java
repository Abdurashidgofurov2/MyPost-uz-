package com.example.mypostuz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mypostuz.databinding.ActivityVerfnumberBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Verfnumber extends AppCompatActivity {
ActivityVerfnumberBinding binding;
FirebaseAuth auth;
String number;
String otpid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityVerfnumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        number=getIntent().getStringExtra("number");
        auth=FirebaseAuth.getInstance();
        tasdiqlash();


    }
    public void tasdiqlash(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number, 60, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        otpid=s;
                        super.onCodeSent(s, forceResendingToken);

                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signphone(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                    }
                }
        );
    }
    private void signphone(PhoneAuthCredential credential){
        auth.signInWithCredential(credential).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(Verfnumber.this,Asosiy.class));
                    finish();
                }

            }
        });

    }
    public void kirish(View v){
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(otpid,binding.phonecode.getText().toString());
        signphone(credential);
    }
}
package com.example.mypostuz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mypostuz.databinding.ActivitySignupBinding;

public class Signup extends AppCompatActivity {
ActivitySignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
binding.sign.setOnClickListener(s->{
    if (binding.name.getText().toString().trim().length()>4){
        startActivity(new Intent(Signup.this,Asosiy.class));
        finish();
    }
    else {
        binding.namell.setError("ism kamida 5 harfdan iborat bo'lishi kerak !");
    }
});

    }
}
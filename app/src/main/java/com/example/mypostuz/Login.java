package com.example.mypostuz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mypostuz.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.edname.getText().toString().length()==9){
                    startActivity(new Intent(Login.this,Check_code.class));
                    binding.namel.setError(null);
                }
                else {
                    binding.namel.setError("raqamni to'ri kiriting !\n 90 123 45 67");
                }
            }
        });
        



    }
}
package com.example.mypostuz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mypostuz.databinding.ActivityCheckCodeBinding;

public class Check_code extends AppCompatActivity {
ActivityCheckCodeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCheckCodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       binding.tasdiqlash.setOnClickListener(s->{
           if (binding.edname.getText().toString().length()==6){
               startActivity(new Intent(Check_code.this,Signup.class));
           }
           else {
               binding.codeinput.setError("tasdiqlash kodi noto'g'ri qayta uring !");
           }
       });
    }
}
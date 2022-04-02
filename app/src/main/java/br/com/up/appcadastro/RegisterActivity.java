package br.com.up.appcadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import br.com.up.appcadastro.model.User;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextInputEditText editTextFirstName =
                findViewById(R.id.edit_text_first_name);

        TextInputEditText editTextSurName =
                findViewById(R.id.edit_text_sur_name);

        TextInputEditText editTextPhone =
                findViewById(R.id.edit_text_phone);

        Button saveButton = findViewById(R.id.button_register);

        saveButton.setOnClickListener(v -> {

            String firstName = editTextFirstName.getText().toString();
            String surName = editTextSurName.getText().toString();
            String phone = editTextPhone.getText().toString();

            if(firstName.isEmpty()){
                editTextFirstName.setError("Favor inserir seu nome");
                return;
            }

            if(surName.isEmpty()){
                editTextSurName.setError("Favor inserir seu sobrenome");
                return;
            }

            if(phone.isEmpty()){
                editTextPhone.setError("Favor inserir seu telefone");
                return;
            }

            User user = new User(firstName,surName,phone);

            Intent intent = new Intent();
            intent.putExtra("user",user);

            setResult(RESULT_OK,intent);
            onBackPressed();

            //finish();

        });



    }
}
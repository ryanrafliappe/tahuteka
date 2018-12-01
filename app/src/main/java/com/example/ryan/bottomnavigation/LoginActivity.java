package com.example.ryan.bottomnavigation;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryan.bottomnavigation.Mitra.MitraActivity;
import com.example.ryan.bottomnavigation.admin.MainActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.et_username);
        password = (EditText)findViewById(R.id.et_password);
        btnLogin = (Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("admin") && passwordKey.equals("admin")){
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                    LoginActivity.this.startActivity(intent);
                    finish();
                }

                else if (usernameKey.equals("mitra") && passwordKey.equals("mitra")) {
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MitraActivity.class);
                    LoginActivity.this.startActivity(intent);
                    finish();
                }

                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username atau Password Salah!").setNegativeButton("Retry", null).create().show();
                }
            }
        });
    }

}

package com.example.inmobiliariakevin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel lv;
    private Button btLogin;
    private EditText etLoginUser, etLoginPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);
        //new ViewModelProvider(this).get(UnModelo.class);  FORMA Corta de iniializar el viewModel
        inicializarVista();
        lv.getMensaje().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(LoginActivity.this,s, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void inicializarVista() {
        btLogin=findViewById(R.id.btLogin);
        etLoginUser=findViewById(R.id.etLoginUser);
        etLoginPass=findViewById(R.id.etLoginPass);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv.iniciarSesion(etLoginUser.getText().toString(),etLoginPass.getText().toString());
            }
        });
    }
}

package com.example.inmobiliariakevin;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliariakevin.Request.ApiClient;
import com.example.inmobiliariakevin.modelo.Propietario;
import com.example.inmobiliariakevin.modelo.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> mensaje;
    private ApiClient.RetrofitService rfs;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<String> getMensaje(){
        if(mensaje==null){
            mensaje=new MutableLiveData<>();
        }
        return mensaje;

    }

    public void iniciarSesion(String usuario,String clave){
        rfs=ApiClient.getMyApiInterface();
        Usuario user = new Usuario(usuario, clave);
        SharedPreferences sp = context.getSharedPreferences("datos", 0);
        SharedPreferences.Editor editor = sp.edit();

        Call<String> dato=rfs.login(user);
        dato.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){

                    Log.d("token",response.body());
                    editor.putString("token", "Bearer "+response.body());
                    editor.commit();

                    //Inicie la Activity del menú
                    Intent intent=new Intent(context,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    context.startActivity(intent);

                }else{
                    Log.d("token",response.message());
                    Log.d("token", "usuario o contraseña incorrecto");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("token", "Error: " + t.getMessage());
                //Toast.makeText(MainActivity.this,"Error: " + t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });


    }


}
package com.example.inmobiliariakevin.ui.perfil;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariakevin.modelo.Propietario;
import com.example.inmobiliariakevin.Request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<Boolean> estado;
    private MutableLiveData<String> textoBoton;
    private MutableLiveData<Propietario> usuario;
    private ApiClient.RetrofitService rfs;
    private ApiClient apiClient;


    public PerfilViewModel() {
        this.apiClient = new ApiClient();
    }

    public LiveData<Boolean> getEstado(){
        if(estado==null){
            estado=new MutableLiveData<>();
        }
        return estado;
    }

    public LiveData<String> getTextoBoton(){
        if(textoBoton==null){
            textoBoton=new MutableLiveData<>();
        }
        return textoBoton;
    }
    public LiveData<Propietario> getUsuario(){
        if(usuario==null){
            usuario=new MutableLiveData<>();
        }
        return usuario;
    }

    public void accionBoton(String txtBoton,Propietario propietario, Context context){

        if(txtBoton.equals("Editar")){
            textoBoton.setValue("Guardar");
            estado.setValue(true);
        }else{
            textoBoton.setValue("Editar");
            estado.setValue(false);

            apiClient = new ApiClient();
            rfs = ApiClient.getMyApiInterface();
            if(propietario.getEstado() == 0){ propietario.setEstado((byte)1);}
            Call<Propietario> dato = rfs.updatePropietarioActual(apiClient.leerToken(context), propietario.getId(), propietario);
            dato.enqueue(new Callback<Propietario>() {
                @Override
                public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                    if(response.isSuccessful()){
                        Log.d("token", response.body().getApellido()+ " "+ response.body().getDireccion());
                        usuario.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<Propietario> call, Throwable t) {
                    Log.d("token", "Error: " + t.getMessage());
                }
            });
        }
    }

    public void traerDatos(Context context){
        apiClient = new ApiClient();

        rfs = ApiClient.getMyApiInterface();
        Call<Propietario> dato = rfs.getPropietarioActual(apiClient.leerToken(context));
        dato.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    Log.d("token", response.body().getApellido()+ " "+ response.body().getDireccion());
                    usuario.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Log.d("token", "Error: " + t.getMessage());
            }
        });
    }
}
package com.example.inmobiliariakevin.ui.perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariakevin.modelo.Propietario;
import com.example.inmobiliariakevin.Request.ApiClient;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<Boolean> estado;
    private MutableLiveData<String> textoBoton;
    private MutableLiveData<Propietario> usuario;
    private ApiClient apiClient;


    public PerfilViewModel() {
        this.apiClient = ApiClient.getApi();
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

    public void accionBoton(String txtBoton,Propietario propietario){

        if(txtBoton.equals("Editar")){
            textoBoton.setValue("Guardar");
            estado.setValue(true);
        }else{
            textoBoton.setValue("Editar");
            estado.setValue(false);
            apiClient.actualizarPerfil(propietario);
        }
    }

    public void traerDatos(){
        usuario.setValue(apiClient.obtenerUsuarioActual());
    }
}
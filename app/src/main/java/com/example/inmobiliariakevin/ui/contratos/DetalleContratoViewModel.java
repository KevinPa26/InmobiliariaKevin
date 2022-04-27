package com.example.inmobiliariakevin.ui.contratos;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.inmobiliariakevin.R;
import com.example.inmobiliariakevin.Request.ApiClient;
import com.example.inmobiliariakevin.modelo.Contrato;
import com.example.inmobiliariakevin.modelo.Inmueble;

public class DetalleContratoViewModel extends AndroidViewModel {
    private MutableLiveData<Contrato> contrato;
    private Context context;

    public DetalleContratoViewModel(@NonNull Application application) {
        super(application);
        context = application.getBaseContext();
    }

    public LiveData<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }

    public void cargarInmuebleAlquilados(Bundle bundle) {
        Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");
        ApiClient api = ApiClient.getApi();
        this.contrato.setValue(api.obtenerContratoVigente(inmueble));
    }
}
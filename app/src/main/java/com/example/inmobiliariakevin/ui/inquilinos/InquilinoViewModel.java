package com.example.inmobiliariakevin.ui.inquilinos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariakevin.Request.ApiClient;
import com.example.inmobiliariakevin.modelo.Inmueble;
import com.example.inmobiliariakevin.modelo.Inquilino;

public class InquilinoViewModel extends ViewModel {
    private MutableLiveData<Inquilino> inquilino;
    public InquilinoViewModel() {
        super();
    }

    public LiveData<Inquilino> getInquilino() {
        if (inquilino == null) {
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }

    public void cargarInquilino(Bundle bundle) {
        Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");
        ApiClient api = ApiClient.getApi();
        this.inquilino.setValue(api.obtenerInquilino(inmueble));
    }
}
package com.example.inmobiliariakevin.ui.contratos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariakevin.Request.ApiClient;
import com.example.inmobiliariakevin.modelo.Contrato;
import com.example.inmobiliariakevin.modelo.Pago;

import java.util.ArrayList;

public class PagosViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Pago>> pagos;
    public PagosViewModel() {
        super();
    }

    public LiveData<ArrayList<Pago>> getPagos() {
        if (pagos == null) {
            pagos = new MutableLiveData<>();
        }
        return pagos;
    }

    public void cargarPagosDeContratos(Bundle bundle) {
        Contrato pagosLista  = (Contrato) bundle.getSerializable("contrato");
        ApiClient api = ApiClient.getApi();
        this.pagos.setValue(api.obtenerPagos(pagosLista));
    }
}
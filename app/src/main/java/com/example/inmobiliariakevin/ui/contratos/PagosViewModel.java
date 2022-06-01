package com.example.inmobiliariakevin.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariakevin.Request.ApiClient;
import com.example.inmobiliariakevin.modelo.Contrato;
import com.example.inmobiliariakevin.modelo.Pago;
import com.google.android.gms.common.api.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagosViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Pago>> pagos;
    private Context context;
    private ApiClient apiClient;
    private ApiClient.RetrofitService rfs;

    public PagosViewModel(@NonNull Application application) {
        super(application);
        context = application.getBaseContext();
    }

    public LiveData<ArrayList<Pago>> getPagos() {
        if (pagos == null) {
            pagos = new MutableLiveData<>();
        }
        return pagos;
    }


    public void cargarPagosDeContratos(Bundle bundle) {
        Contrato contrato  = (Contrato) bundle.getSerializable("contrato");
        //this.pagos.setValue(api.obtenerPagos(pagosLista));

        apiClient = new ApiClient();
        rfs = ApiClient.getMyApiInterface();

        Call<ArrayList<Pago>> dato = rfs.getPagosPorContrato(apiClient.leerToken(context), contrato.getId());
        dato.enqueue(new Callback<ArrayList<Pago>>() {
            @Override
            public void onResponse(Call<ArrayList<Pago>> call, Response<ArrayList<Pago>> response) {
                if(response.isSuccessful()){
                    pagos.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Pago>> call, Throwable t) {
                Log.d("token", "Error: " + t.getMessage());
            }
        });
    }
}
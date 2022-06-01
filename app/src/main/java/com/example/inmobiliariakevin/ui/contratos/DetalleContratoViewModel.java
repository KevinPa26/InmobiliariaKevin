package com.example.inmobiliariakevin.ui.contratos;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleContratoViewModel extends AndroidViewModel {
    private MutableLiveData<Contrato> contrato;
    private Context context;
    private ApiClient apiClient;
    private ApiClient.RetrofitService rfs;

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


    public void cargarContratos(Bundle bundle) {
        Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");
        //this.contrato.setValue(api.obtenerContratoVigente(inmueble));

        apiClient = new ApiClient();
        rfs = ApiClient.getMyApiInterface();

        Call<ArrayList<Contrato>> dato = rfs.getContratosPorInmueble(apiClient.leerToken(context), inmueble.getId());
        dato.enqueue(new Callback<ArrayList<Contrato>>() {
            @Override
            public void onResponse(Call<ArrayList<Contrato>> call, Response<ArrayList<Contrato>> response) {
                if(response.isSuccessful()){
                    contrato.setValue(response.body().get(0));
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Contrato>> call, Throwable t) {
                Log.d("token", "Error: " + t.getMessage());
            }
        });
    }
}
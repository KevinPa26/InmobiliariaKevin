package com.example.inmobiliariakevin.ui.inmuebles;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliariakevin.Request.ApiClient;
import com.example.inmobiliariakevin.modelo.Inmueble;
import com.example.inmobiliariakevin.modelo.Propietario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InmueblesViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private Context context;
    private ApiClient apiClient;
    private ApiClient.RetrofitService rfs;


    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void cargarInmuebles() {
        //Acá traemos todos los inmuebles de la base de datos
        apiClient = new ApiClient();
        rfs = ApiClient.getMyApiInterface();

        Call<ArrayList<Inmueble>> dato = rfs.getInmuebles(apiClient.leerToken(context));
        dato.enqueue(new Callback<ArrayList<Inmueble>>() {
            @Override
            public void onResponse(Call<ArrayList<Inmueble>> call, Response<ArrayList<Inmueble>> response) {
                if(response.isSuccessful()){
                    inmuebles.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Inmueble>> call, Throwable t) {
                Log.d("token", "Error: " + t.getMessage());
            }
        });
        //ArrayList<Inmueble> inmuebles=api.obtnerPropiedades();
        //this.inmuebles.setValue(inmuebles);

    }
}
package com.example.inmobiliariakevin.ui.contratos;

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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratosViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private Context context;
    private ApiClient apiClient;
    private ApiClient.RetrofitService rfs;

    public ContratosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void cargarInmueblesAlquilados(){
        apiClient = new ApiClient();
        rfs = ApiClient.getMyApiInterface();

        Call<ArrayList<Inmueble>> dato = rfs.getInmuebles(apiClient.leerToken(context));
        dato.enqueue(new Callback<ArrayList<Inmueble>>() {
            @Override
            public void onResponse(Call<ArrayList<Inmueble>> call, Response<ArrayList<Inmueble>> response) {
                if(response.isSuccessful()){
                    ArrayList<Inmueble> inmu = new ArrayList<>();
                    for (Inmueble inmueble : response.body()) {
                        if(inmueble.getEstado() == 3){
                            inmu.add(inmueble);
                        }
                    }
                    inmuebles.setValue(inmu);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Inmueble>> call, Throwable t) {
                Log.d("token", "Error: " + t.getMessage());
            }
        });
    }

/*
    public void cargarInmueblesAlquilados() {
        //Acá traemos todos los inmuebles de la base de datos

        ApiClient api=ApiClient.getApi();
        ArrayList<Inmueble> inmuebles=api.obtenerPropiedadesAlquiladas();
        this.inmuebles.setValue(inmuebles);

    }

 */
}
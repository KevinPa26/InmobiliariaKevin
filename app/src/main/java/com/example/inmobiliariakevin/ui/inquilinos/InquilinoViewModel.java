package com.example.inmobiliariakevin.ui.inquilinos;

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
import com.example.inmobiliariakevin.modelo.Inmueble;
import com.example.inmobiliariakevin.modelo.Inquilino;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InquilinoViewModel extends AndroidViewModel {
    private MutableLiveData<Inquilino> inquilino;
    private Context context;
    private ApiClient apiClient;
    private ApiClient.RetrofitService rfs;

    public InquilinoViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<Inquilino> getInquilino() {
        if (inquilino == null) {
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }


    public void cargarInquilino(Bundle bundle) {
        Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");
        //ApiClient api = ApiClient.getApi();
        //this.inquilino.setValue(api.obtenerInquilino(inmueble));

        apiClient = new ApiClient();
        rfs = ApiClient.getMyApiInterface();

        Call<ArrayList<Inquilino>> dato = rfs.getInquilinoPorInmueble(apiClient.leerToken(context), inmueble.getId());
        dato.enqueue(new Callback<ArrayList<Inquilino>>() {
            @Override
            public void onResponse(Call<ArrayList<Inquilino>> call, Response<ArrayList<Inquilino>> response) {
                if(response.isSuccessful()){
                    inquilino.setValue(response.body().get(0));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Inquilino>> call, Throwable t) {
                Log.d("token", "Error: " + t.getMessage());
            }
        });
    }
}
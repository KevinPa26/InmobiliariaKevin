package com.example.inmobiliariakevin.ui.logout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.inmobiliariakevin.MainActivity;
import com.example.inmobiliariakevin.R;

public class LogoutViewModel extends AndroidViewModel {
    private MutableLiveData<AlertDialog.Builder> mutableDialogBuilder;

    private Context context;
    private Application application;
    public LogoutViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        this.application = application;
    }

    public LiveData<AlertDialog.Builder> getMutableDialogBuilder() {
        if(mutableDialogBuilder == null){
            mutableDialogBuilder = new MutableLiveData<>();
        }
        return mutableDialogBuilder;
    }

    public void mostrarDialog(){
        AlertDialog.Builder alertDialog =  new AlertDialog.Builder(application)
                .setTitle("Titulo")
                .setMessage("Desea cerrar la app")
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);

                    }
                }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main).navigate(R.id.nav_inicio);

            }
        });
        mutableDialogBuilder.setValue(alertDialog);
    }
    // TODO: Implement the ViewModel
}
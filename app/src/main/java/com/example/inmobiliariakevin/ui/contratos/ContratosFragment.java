package com.example.inmobiliariakevin.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inmobiliariakevin.R;
import com.example.inmobiliariakevin.modelo.Inmueble;
import com.example.inmobiliariakevin.ui.inmuebles.InmuebleAdapter;
import com.example.inmobiliariakevin.ui.inmuebles.InmueblesViewModel;

import java.util.ArrayList;

public class ContratosFragment extends Fragment {

    private RecyclerView rvContratos;
    private ContratosViewModel contratosViewModel;
    private InmueblesAlquiladosAdapter adapter;
    private Context context;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contratos, container, false);
        context = root.getContext();
        inicializar(root);
        return root;
    }
    private void inicializar(View view) {
        rvContratos = view.findViewById(R.id.rvContratos);

        contratosViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratosViewModel.class);
        contratosViewModel.getInmuebles().observe(getViewLifecycleOwner(), new Observer<ArrayList<Inmueble>>() {
            @Override
            public void onChanged(ArrayList<Inmueble> inmuebles) {
                GridLayoutManager gridLayoutManager= new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
                rvContratos.setLayoutManager(gridLayoutManager);
                adapter = new InmueblesAlquiladosAdapter(context, inmuebles, getLayoutInflater());
                rvContratos.setAdapter(adapter);
            }
        });
        contratosViewModel.cargarInmueblesAlquilados();
    }
}
package com.example.inmobiliariakevin.ui.inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.inmobiliariakevin.R;
import com.example.inmobiliariakevin.modelo.Inmueble;
import com.example.inmobiliariakevin.modelo.Inquilino;
import com.example.inmobiliariakevin.ui.inmuebles.InmuebleViewModel;

public class InquilinoFragment extends Fragment {

    private InquilinoViewModel inquilinoViewModel;
    private TextView tvCodigoInquilino;
    private TextView tvNombreInquilino;
    private TextView tvApellidoInquilino;
    private TextView tvDniInquilino;
    private TextView tvEmail;
    private TextView tvTelInquilino;
    private TextView tvGarante;
    private TextView tvTelGarante;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inquilino_fragment, container, false);
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        tvCodigoInquilino = view.findViewById(R.id.tvCodigoInquilino);
        tvNombreInquilino = view.findViewById(R.id.tvNombreInquilino);
        tvApellidoInquilino = view.findViewById(R.id.tvApellidoInquilino);
        tvDniInquilino = view.findViewById(R.id.tvDniInquilino);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvTelInquilino = view.findViewById(R.id.tvTelInquilino);
        tvGarante = view.findViewById(R.id.tvGarante);
        tvTelGarante = view.findViewById(R.id.tvTelGarante);
        inquilinoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoViewModel.class);
        inquilinoViewModel.getInquilino().observe(getActivity(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {
                tvCodigoInquilino.setText(inquilino.getIdInquilino()+ "");
                tvNombreInquilino.setText(inquilino.getNombre());
                tvApellidoInquilino.setText(inquilino.getApellido());
                tvDniInquilino.setText(inquilino.getDNI().toString());
                tvEmail.setText(inquilino.getEmail());
                tvTelInquilino.setText(inquilino.getTelefono());
                tvGarante.setText(inquilino.getNombreGarante());
                tvTelGarante.setText(inquilino.getTelefonoGarante());
            }
        });
        inquilinoViewModel.cargarInquilino(getArguments());
    }

}
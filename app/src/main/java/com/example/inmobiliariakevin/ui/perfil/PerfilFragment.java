package com.example.inmobiliariakevin.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.inmobiliariakevin.R;
import com.example.inmobiliariakevin.modelo.Propietario;


public class PerfilFragment extends Fragment {

    private EditText etDni, etNombre, etApellido, etTelefono, etContraseña, etMail, etId, etDireccion;
    private Button btEditar;
    private PerfilViewModel perfilViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        perfilViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        inicializarVista(root);

        perfilViewModel.getUsuario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                etId.setText("" +propietario.getId());
                etDireccion.setText(propietario.getDireccion());
                etDni.setText(propietario.getDni());
                etApellido.setText(propietario.getApellido());
                etNombre.setText(propietario.getNombre());
                etTelefono.setText(propietario.getTel());
                etMail.setText(propietario.getEmail());
                etContraseña.setText("");
            }
        });

        perfilViewModel.getEstado().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etDni.setEnabled(aBoolean);
                etApellido.setEnabled(aBoolean);
                etNombre.setEnabled(aBoolean);
                etTelefono.setEnabled(aBoolean);
                etMail.setEnabled(aBoolean);
                etContraseña.setEnabled(aBoolean);
            }
        });

        perfilViewModel.getTextoBoton().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                btEditar.setText(s);
            }
        });

        perfilViewModel.traerDatos(this.getContext());

        return root;
    }

    private void inicializarVista(View root) {
        etId = root.findViewById(R.id.etIdPerfil);
        etDireccion = root.findViewById(R.id.etDireccionPerfil);
        etDni = root.findViewById(R.id.etDniPerfil);
        etNombre = root.findViewById(R.id.etNombrePerfil);
        etApellido = root.findViewById(R.id.etApellidoPerfil);
        etTelefono = root.findViewById(R.id.etTelefonoPerfil);
        etMail = root.findViewById(R.id.etEmailPerfil);
        etContraseña = root.findViewById(R.id.etContraseñaPerfil);
        btEditar = root.findViewById(R.id.btEditarPerfil);

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Propietario propietario = new Propietario();
                propietario.setId(Integer.parseInt(etId.getText().toString()));
                propietario.setDireccion(etDireccion.getText().toString());
                propietario.setDni(etDni.getText().toString());
                propietario.setNombre(etNombre.getText().toString());
                propietario.setApellido(etApellido.getText().toString());
                propietario.setTel(etTelefono.getText().toString());
                propietario.setEmail(etMail.getText().toString());
                propietario.setClave(etContraseña.getText().toString());

                String texto = btEditar.getText().toString();

                perfilViewModel.accionBoton(texto,propietario, getContext());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
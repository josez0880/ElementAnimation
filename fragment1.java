package com.example.androidproyecto2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class fragment1 extends Fragment {
//   Declara elementos
    EditText etname, etlastname;
    Button bt,bt2;
    String clean="";

    public fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment1, container, false);
    }
//    Metodo que envia datos al text view
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        etname = view.findViewById(R.id.Fragment1__TextInput_nombre);
        etlastname = view.findViewById(R.id.Fragment1__TextInput_apellido);
        bt = view.findViewById(R.id.Fragment1__Button_Enviar);
        bt2=view.findViewById(R.id.Fragment1__Button_Limpiar);

        bt.setOnClickListener(view1 -> {
          /*crea objeto para transferir datos*/
            Bundle bundle = new Bundle();
          /*Crea un metodo para tranferir nombre*/
            bundle.putString("name",etname.getText().toString());
            /*Crea llave que crea un conexion para transferir datos */
            getParentFragmentManager().setFragmentResult("key", bundle);
            /*Repite proceso*/
            Bundle bundle1 =new Bundle();
            bundle1.putString("lastname",etlastname.getText().toString());
            getParentFragmentManager().setFragmentResult("key1",bundle1);


//            Desabilita boton enviar, edit text name y edit text apellido
            bt.setEnabled(false);
            etname.setEnabled(false);
            etlastname.setEnabled(false);
        });

        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Habilita btn, etname, etlastname y limpia etname, lastname
                etname.setText("");
                etlastname.setText("");
                bt.setEnabled(true);
                etname.setEnabled(true);
                etlastname.setEnabled(true);

            }
        });


    }
}
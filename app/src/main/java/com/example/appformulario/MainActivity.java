package com.example.appformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Guardar();
        Recibir();

    }


    public void Guardar() {

        final Intent siguiente = new Intent(this, ConfirmarDatos.class);

        Button btn=(Button) findViewById(R.id.btnSiguiente);
        final EditText txtNombre=(EditText) findViewById(R.id.txtNombres);
        final DatePicker dpFecha=(DatePicker) findViewById(R.id.dpFecha);
        final EditText  txtTelefono=(EditText) findViewById(R.id.txtTelefono);
        final EditText txtCorreo= (EditText) findViewById(R.id.txtCorreo);
        final EditText txtDescripcion= (EditText) findViewById(R.id.txtDescripcion);


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            Bundle b= new Bundle();

            int dia= dpFecha.getDayOfMonth();
            int mes= dpFecha.getMonth();
            int año=dpFecha.getYear();

            b.putString("nombre",txtNombre.getText().toString());
            b.putString("fecha",String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(año));
            b.putString("telefono",txtTelefono.getText().toString());
            b.putString("correo",txtCorreo.getText().toString());
            b.putString("descripcion",txtDescripcion.getText().toString());

            siguiente.putExtras(b);
            startActivity(siguiente);
            finish();
            }
        });

       }

    public void Recibir() {

        final EditText txtNombre = (EditText) findViewById(R.id.txtNombres);
        final DatePicker dpFecha = (DatePicker) findViewById(R.id.dpFecha);
        final EditText txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        final EditText txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        final EditText txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);


        Intent i = getIntent();

        Bundle b = i.getExtras();

        if (i.getExtras() != null) {

            txtNombre.setText(getIntent().getExtras().getString("nombre"));
            //dpFecha.setText(getIntent().getExtras().getString("fecha"));
            txtTelefono.setText(getIntent().getExtras().getString("telefono"));
            txtCorreo.setText(getIntent().getExtras().getString("correo"));
            txtDescripcion.setText(getIntent().getExtras().getString("descripcion"));
        }

    }




}
package com.example.appformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Recibir();
        Editar();
    }

    public void Recibir(){

        TextView tvNombre= (TextView) findViewById(R.id.tvNombre);
        TextView tvFecha= (TextView) findViewById(R.id.tvFechaNacimiento);
        TextView tvTelefono= (TextView) findViewById(R.id.tvTelefono);
        TextView tvCorreo= (TextView) findViewById(R.id.tvCorreo);
        TextView tvDescripcion= (TextView) findViewById(R.id.tvDescripcion);

        Intent i= getIntent();

        Bundle b=i.getExtras();

        tvNombre.setText(getIntent().getExtras().getString("nombre"));
        tvFecha.setText(getIntent().getExtras().getString("fecha"));
        tvTelefono.setText(getIntent().getExtras().getString("telefono"));
        tvCorreo.setText(getIntent().getExtras().getString("correo"));
        tvDescripcion.setText(getIntent().getExtras().getString("descripcion"));
    }


    public void Editar(){

        final Intent siguiente = new Intent(this,MainActivity.class);

        Button btn=(Button) findViewById(R.id.btnEditar);
        final TextView tvNombre=(TextView) findViewById(R.id.tvNombre);
        final TextView tvFecha=(TextView) findViewById(R.id.tvFechaNacimiento);
        final TextView tvTelefono=(TextView) findViewById(R.id.tvTelefono);
        final TextView tvCorreo= (TextView) findViewById(R.id.tvCorreo);
        final TextView tvDescripcion= (TextView) findViewById(R.id.tvDescripcion);


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Bundle b= new Bundle();


                b.putString("nombre",tvNombre.getText().toString());
                b.putString("fecha",tvFecha.getText().toString());
                b.putString("telefono",tvTelefono.getText().toString());
                b.putString("correo",tvCorreo.getText().toString());
                b.putString("descripcion",tvDescripcion.getText().toString());

                siguiente.putExtras(b);
                startActivity(siguiente);
                finish();
            }
        });




    }


}


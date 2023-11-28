package uaa.mx.proyectofinalgeoterra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInicio = findViewById(R.id.btnInicio);
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        System.out.println("heyhey");
        if(dbHelper.tablavacia("temas")){
            dbHelper.metertemas();
        }

        /*if(dbHelper.tablavacia("cuestionario")){
            dbHelper.meterpre();
            System.out.println("si");
        }*/


        List<HashMap<String, String>> datos = dbHelper.gettemas();
        for (HashMap<String, String> dato : datos) {
            System.out.println(dato);
        }




        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick
                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(MainActivity.this, opciones.class);
                startActivity(intent);
            }
        });

    }
}
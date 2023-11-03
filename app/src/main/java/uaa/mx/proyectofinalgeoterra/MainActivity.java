package uaa.mx.proyectofinalgeoterra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInicio = findViewById(R.id.btnInicio);

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
package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class opciones extends AppCompatActivity {

    private Button btnRegresar; //Declaramos un botón para regresar a la actividad principal
    private ImageButton btnIngresar, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones);

        btnRegresar = findViewById(R.id.btnRegresar); // Obtenemos una referencia al elemento del botón de la interfaz de usuario llamado "btnRegresar"

        //Cuando se seleccione el boton de regresar, se ejecuta el código contenido dentro del método onClick
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual y vuelve a la anterior
            }
        });

        btnIngresar = findViewById(R.id.ingresarButton);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick
                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(opciones.this, menu.class);
                startActivity(intent);
            }
        });

        btnRegistrar = findViewById(R.id.registrarButton);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick
                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(opciones.this, registro.class);
                startActivity(intent);
            }
        });
    }
}
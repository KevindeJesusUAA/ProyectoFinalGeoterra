package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class opciones extends AppCompatActivity {
    DatabaseHelper dbHelper = new DatabaseHelper(this);
    private Button btnRegresar; //Declaramos un botón para regresar a la actividad principal
    private Button btnIngresar, btnRegistrar;
    private EditText nombre,contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones);

        btnRegresar = findViewById(R.id.btnRegresar); // Obtenemos una referencia al elemento del botón de la interfaz de usuario llamado "btnRegresar"
        nombre=findViewById(R.id.ingreso);
        contrasena=findViewById(R.id.contraseña);
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
                if(!nombre.getText().toString().trim().equals("")&&!contrasena.getText().toString().trim().equals("")){
                    boolean simun = dbHelper.verificarCredenciales(nombre.getText().toString().trim(), contrasena.getText().toString().trim());
                    if(simun){
                        Toast.makeText(opciones.this, "Bienvenido: "+nombre.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(opciones.this, menu.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(opciones.this, "Usuario No Encontrado", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(opciones.this, "Faltan Datos", Toast.LENGTH_SHORT).show();
                }

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
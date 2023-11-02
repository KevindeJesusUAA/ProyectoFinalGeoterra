package uaa.mx.proyectofinalgeoterra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class explora extends AppCompatActivity {

    //En el método onCreate creamos la actividad y se configur
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Esta línea llama al método onCreate de la clase base (AppCompatActivity) para que realice sus tareas de inicialización
        setContentView(R.layout.explora_conmigo); // Se carga la interfaz de usuario de la actividad a partir del archivo de diseño para que los distintos elementos
        // estén disponibles
    }
}

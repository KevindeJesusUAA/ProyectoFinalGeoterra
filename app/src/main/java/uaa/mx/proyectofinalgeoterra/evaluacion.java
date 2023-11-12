package uaa.mx.proyectofinalgeoterra;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class evaluacion extends AppCompatActivity {

    // Variable para almacenar la respuesta correcta
    private String respuestaCorrecta = "c. México";
    private String respuestaCorrecta2 = "a. Brasil";
    private Button btnRespuesta1, btnRespuesta2, btnRespuesta3, btnRespuesta4, btnRespuesta5, btnRespuesta6, btnRespuesta7, btnRespuesta8;
    private String respuestaSeleccionada = "";
    private String respuestaSeleccionada2 = "";
    private Button botonSeleccionado = null;
    private Button botonSeleccionado2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluacion);

        // Obtener referencias a los botones
        btnRespuesta1 = findViewById(R.id.btnRespuesta1);
        btnRespuesta2 = findViewById(R.id.btnRespuesta2);
        btnRespuesta3 = findViewById(R.id.btnRespuesta3);
        btnRespuesta4 = findViewById(R.id.btnRespuesta4);
        btnRespuesta5 = findViewById(R.id.btnRespuesta5);
        btnRespuesta6 = findViewById(R.id.btnRespuesta6);
        btnRespuesta7 = findViewById(R.id.btnRespuesta7);
        btnRespuesta8 = findViewById(R.id.btnRespuesta8);

        // Establecer OnClickListener para cada botón
        btnRespuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada = "a. Brasil";
                validarRespuesta(btnRespuesta1);
            }
        });

        btnRespuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada = "b. Estados Unidos";
                validarRespuesta(btnRespuesta2);
            }
        });

        btnRespuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada = "c. México";
                validarRespuesta(btnRespuesta3);
            }
        });

        btnRespuesta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada = "d. Perú";
                validarRespuesta(btnRespuesta4);
            }
        });

        // Establecer OnClickListener para cada botón
        btnRespuesta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada2 = "a. Brasil";
                validarRespuesta2(btnRespuesta5);
            }
        });

        btnRespuesta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada2 = "b. Estados Unidos";
                validarRespuesta2(btnRespuesta6);
            }
        });

        btnRespuesta7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada2 = "c. México";
                validarRespuesta2(btnRespuesta7);
            }
        });

        btnRespuesta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                respuestaSeleccionada2 = "d. Perú";
                validarRespuesta2(btnRespuesta8);
            }
        });

        // Establecer OnClickListener para el botón "Enviar"
        findViewById(R.id.btnEnviar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar a la función para validar la respuesta
                validarRespuestaSeleccionada();
            }
        });
    }

    private void validarRespuesta(Button btnRespuesta) {
        // Restablecer el color de fondo del botón previamente seleccionado
        if (botonSeleccionado != null) {
            resetearColoresBotones();
        }
        // Cambiar el color de fondo del botón seleccionado
        btnRespuesta.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonSeleccionado)));
        // Actualizar el botón seleccionado actual
        botonSeleccionado = btnRespuesta;

    }

    private void validarRespuesta2(Button btnRespuesta2) {
        // Restablecer el color de fondo del botón previamente seleccionado
        if (botonSeleccionado2 != null) {
            resetearColoresBotones2();
        }
        btnRespuesta2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonSeleccionado)));
        // Actualizar el botón seleccionado actual
        botonSeleccionado2 = btnRespuesta2;
    }

    private void validarRespuestaSeleccionada() {
        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada.equals(respuestaCorrecta)) {
            // La respuesta es correcta
            Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
        }// Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada2.equals(respuestaCorrecta2)) {
            // La respuesta es correcta
            Toast.makeText(this, "Respuesta correcta2", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            Toast.makeText(this, "Respuesta incorrecta2", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para restablecer el color de fondo de todos los botones
    private void resetearColoresBotones() {
        btnRespuesta1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta1)));
        btnRespuesta2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta2)));
        btnRespuesta3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta3)));
        btnRespuesta4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta4)));
    }
    private void resetearColoresBotones2() {
        btnRespuesta5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta1)));
        btnRespuesta6.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta2)));
        btnRespuesta7.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta3)));
        btnRespuesta8.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorBotonRespuesta4)));
    }
}

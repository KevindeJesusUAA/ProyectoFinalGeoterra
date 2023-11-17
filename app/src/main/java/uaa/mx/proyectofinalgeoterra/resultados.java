package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class resultados extends AppCompatActivity {

    private String respuestaCorrecta = "c. México";
    private String respuestaCorrecta2 = "a. Brasil";
    private String respuestaCorrecta3 = "d. Coliseo";
    private String respuestaCorrecta4 = "b. Machu Pichu";
    private String respuestaCorrecta5 = "a. Taj Mahal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultados);

        // Obtener las respuestas seleccionadas del Intent
        Intent intent = getIntent();
        String respuestaSeleccionada1 = intent.getStringExtra("respuestaSeleccionada1");
        String respuestaSeleccionada2 = intent.getStringExtra("respuestaSeleccionada2");
        String respuestaSeleccionada3 = intent.getStringExtra("respuestaSeleccionada3");
        String respuestaSeleccionada4 = intent.getStringExtra("respuestaSeleccionada4");
        String respuestaSeleccionada5 = intent.getStringExtra("respuestaSeleccionada5");



        // Referencias a los TextViews en el layout
        TextView txtRespuesta1 = findViewById(R.id.txtRespuesta1);
        TextView txtRespuesta2 = findViewById(R.id.txtRespuesta2);
        TextView txtRespuesta3 = findViewById(R.id.txtRespuesta3);
        TextView txtRespuesta4 = findViewById(R.id.txtRespuesta4);
        TextView txtRespuesta5 = findViewById(R.id.txtRespuesta5);

        // Establecer el texto de los TextViews con las respuestas correctas
        txtRespuesta1.setText(respuestaSeleccionada1);
        txtRespuesta2.setText(respuestaSeleccionada2);
        txtRespuesta3.setText(respuestaSeleccionada3);
        txtRespuesta4.setText(respuestaSeleccionada4);
        txtRespuesta5.setText(respuestaSeleccionada5);

        // Obtener las referencias a las ImageView en el layout
        ImageView imgRespuesta1 = findViewById(R.id.imagenPregunta1);
        ImageView imgRespuesta2 = findViewById(R.id.imagenPregunta2);
        ImageView imgRespuesta3 = findViewById(R.id.imagenPregunta3);
        ImageView imgRespuesta4 = findViewById(R.id.imagenPregunta4);
        ImageView imgRespuesta5 = findViewById(R.id.imagenPregunta5);

        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada1.equals(respuestaCorrecta)) {
            // La respuesta es correcta
            imgRespuesta1.setImageResource(R.drawable.palomita); // Asigna la imagen de la palomita
            Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            imgRespuesta1.setImageResource(R.drawable.tacha); // Asigna la imagen de la tacha
            Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
        }

        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada2.equals(respuestaCorrecta2)) {
            // La respuesta es correcta
            imgRespuesta2.setImageResource(R.drawable.palomita); // Asigna la imagen de la palomita
            Toast.makeText(this, "Respuesta correcta2", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            imgRespuesta2.setImageResource(R.drawable.tacha); // Asigna la imagen de la tacha
            Toast.makeText(this, "Respuesta incorrecta2", Toast.LENGTH_SHORT).show();
        }

        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada3.equals(respuestaCorrecta3)) {
            // La respuesta es correcta
            imgRespuesta3.setImageResource(R.drawable.palomita); // Asigna la imagen de la palomita
            Toast.makeText(this, "Respuesta correcta3", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            imgRespuesta3.setImageResource(R.drawable.tacha); // Asigna la imagen de la tacha
            Toast.makeText(this, "Respuesta incorrecta3", Toast.LENGTH_SHORT).show();
        }

        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada4.equals(respuestaCorrecta4)) {
            // La respuesta es correcta
            imgRespuesta4.setImageResource(R.drawable.palomita); // Asigna la imagen de la palomita
            Toast.makeText(this, "Respuesta correcta4", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            imgRespuesta4.setImageResource(R.drawable.tacha); // Asigna la imagen de la tacha
            Toast.makeText(this, "Respuesta incorrecta4", Toast.LENGTH_SHORT).show();
        }

        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada5.equals(respuestaCorrecta5)) {
            // La respuesta es correcta
            imgRespuesta5.setImageResource(R.drawable.palomita); // Asigna la imagen de la palomita
            Toast.makeText(this, "Respuesta correcta5", Toast.LENGTH_SHORT).show();
        } else {
            // La respuesta es incorrecta
            imgRespuesta5.setImageResource(R.drawable.tacha); // Asigna la imagen de la tacha
            Toast.makeText(this, "Respuesta incorrecta5", Toast.LENGTH_SHORT).show();
        }

    }
}

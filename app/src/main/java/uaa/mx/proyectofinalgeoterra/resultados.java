package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicReference;

public class resultados extends AppCompatActivity {

    private String respuestaCorrecta = "c. México";
    private String respuestaCorrecta2 = "a. Brasil";
    private String respuestaCorrecta3 = "d. Coliseo";
    private String respuestaCorrecta4 = "b. Machu Pichu";
    private String respuestaCorrecta5 = "a. Taj Mahal";
    private String Nombre,id,tema;
    private  int correct=0;
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
        Bundle recibeIngreso = getIntent().getExtras();
        tema = recibeIngreso.getString("Tema");
        Nombre = recibeIngreso.getString("Nombre"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        id= recibeIngreso.getString("Idusu");
        System.out.println("kevin res: tema: "+tema+" Nombre:"+Nombre+" id: "+id);


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
            //Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
            correct++;
        } else {
            // La respuesta es incorrecta
            imgRespuesta1.setImageResource(R.drawable.tacha); // Asigna la imagen de la tacha
            //Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
        }

        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada2.equals(respuestaCorrecta2)) {
            // La respuesta es correcta
            imgRespuesta2.setImageResource(R.drawable.palomita); // Asigna la imagen de la palomita
            //Toast.makeText(this, "Respuesta correcta2", Toast.LENGTH_SHORT).show();
            correct++;
        } else {
            // La respuesta es incorrecta
            imgRespuesta2.setImageResource(R.drawable.tacha); // Asigna la imagen de la tacha
            //Toast.makeText(this, "Respuesta incorrecta2", Toast.LENGTH_SHORT).show();
        }

        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada3.equals(respuestaCorrecta3)) {
            // La respuesta es correcta
            imgRespuesta3.setImageResource(R.drawable.palomita); // Asigna la imagen de la palomita
            //Toast.makeText(this, "Respuesta correcta3", Toast.LENGTH_SHORT).show();
            correct++;
        } else {
            // La respuesta es incorrecta
            imgRespuesta3.setImageResource(R.drawable.tacha); // Asigna la imagen de la tacha
            //Toast.makeText(this, "Respuesta incorrecta3", Toast.LENGTH_SHORT).show();
        }

        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada4.equals(respuestaCorrecta4)) {
            // La respuesta es correcta
            imgRespuesta4.setImageResource(R.drawable.palomita); // Asigna la imagen de la palomita
            //Toast.makeText(this, "Respuesta correcta4", Toast.LENGTH_SHORT).show();
            correct++;
        } else {
            // La respuesta es incorrecta
            imgRespuesta4.setImageResource(R.drawable.tacha); // Asigna la imagen de la tacha
            //Toast.makeText(this, "Respuesta incorrecta4", Toast.LENGTH_SHORT).show();
        }

        // Comparar la respuesta seleccionada con la respuesta correcta
        if (respuestaSeleccionada5.equals(respuestaCorrecta5)) {
            // La respuesta es correcta
            imgRespuesta5.setImageResource(R.drawable.palomita); // Asigna la imagen de la palomita
            //Toast.makeText(this, "Respuesta correcta5", Toast.LENGTH_SHORT).show();
            correct++;
        } else {
            // La respuesta es incorrecta
            imgRespuesta5.setImageResource(R.drawable.tacha); // Asigna la imagen de la tacha
            //Toast.makeText(this, "Respuesta incorrecta5", Toast.LENGTH_SHORT).show();
        }
        float promedio=(correct*10)/5;
        TextView promediotx=findViewById(R.id.promedio);
        promediotx.setText( String.valueOf(promedio));
        Button btnEnviar = new Button(this);

        btnEnviar.setText("Siguiente");
        btnEnviar.setTextColor(getResources().getColor(android.R.color.white)); // Establecer color de texto
        btnEnviar.setTextSize(30); // Establecer tamaño de texto
        btnEnviar.setTypeface(null, Typeface.BOLD); // Establecer estilo de texto a negrita
        btnEnviar.setBackgroundColor(Color.parseColor("#FF99FF")); // Establecer color de fondo


        if(promedio<7){
            btnEnviar.setOnClickListener(v -> {
                Toast.makeText(this, "Sorry no Pasaste", Toast.LENGTH_SHORT).show();
                finish();
            });
        }else{
            btnEnviar.setOnClickListener(v -> {
                /*Intent intent2 = new Intent(resultadosdin.this, menu.class);
                Toast.makeText(this, "Felicidades pasaste"+Nombre+" id:"+id, Toast.LENGTH_SHORT).show();
                intent2.get().putExtra("Nombre",Nombre);
                intent2.get().putExtra("Idusu",id);
                startActivity(intent2);*/
                Toast.makeText(this, "Felicidades pasaste"+Nombre+" id:"+id, Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(resultados.this, menu.class);

                System.out.println("vaya");
                // Poner las respuestas seleccionadas como extras en el Intent

                intent2.putExtra("Nombre",Nombre);
                intent2.putExtra("Idusu",id);
                intent2.putExtra("Tema","3");
                DatabaseHelper dbHelper = new DatabaseHelper(this);
                dbHelper.ingpro(String.valueOf(promedio),id,tema);




                startActivity(intent2);

            });
        }


        // Crear un LinearLayout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.gravity = Gravity.CENTER;
        params.setMargins(0, 40, 0, 0); // Establecer márgenes
        LinearLayout principal=findViewById(R.id.muestra);
        principal.addView(btnEnviar);



    }

}
/*
*
*
*
* */
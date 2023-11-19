package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class resultadosdin extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultadodin);
        Intent intent = getIntent();
        boolean[] vectorBooleanos = intent.getBooleanArrayExtra("revision");
        String[] vectorStrings = intent.getStringArrayExtra("correcta");
        System.out.println( "Vector de booleanos:");
        for (boolean valor : vectorBooleanos) {
            System.out.println( String.valueOf(valor));
        }

        System.out.println( "Vector de strings:");
        for (String valor : vectorStrings) {
            System.out.println(valor);
        }
        LinearLayout principal = findViewById(R.id.resul);

        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(
                70, // Ancho en píxeles
                70, // Alto en píxeles
                LinearLayout.LayoutParams.WRAP_CONTENT));
        imageView.setImageResource(R.drawable.palomita);

        TextView preguntaTextView = new TextView(this);
        LinearLayout.LayoutParams preguntaParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                70, // Alto en píxeles
                LinearLayout.LayoutParams.MATCH_PARENT);
        preguntaParams.setMargins(10, 10, 10, 10); // Márgenes (izquierda, arriba, derecha, abajo)
        preguntaTextView.setLayoutParams(preguntaParams);
        preguntaTextView.setText("Pregunta 1");
        preguntaTextView.setTextColor(Color.parseColor("#020242"));
        preguntaTextView.setTextSize(25);
        preguntaTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        preguntaTextView.setGravity(Gravity.CENTER);

        TextView respuestaTextView = new TextView(this);
        LinearLayout.LayoutParams respuestaParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                70, // Alto en píxeles
                LinearLayout.LayoutParams.WRAP_CONTENT);
        respuestaParams.setMargins(10, 10, 10, 10); // Márgenes (izquierda, arriba, derecha, abajo)
        respuestaTextView.setLayoutParams(respuestaParams);
        respuestaTextView.setText("México");
        respuestaTextView.setTextColor(Color.parseColor("#020242"));
        respuestaTextView.setTextSize(25);
        respuestaTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        respuestaTextView.setGravity(Gravity.CENTER);

        principal.addView(imageView);
        principal.addView(preguntaTextView);
        principal.addView(respuestaTextView);

    }
}

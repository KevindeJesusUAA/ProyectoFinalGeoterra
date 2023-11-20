package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class resultadosdin extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultadodin);
        Intent intent = getIntent();
        boolean[] vectorBooleanos = intent.getBooleanArrayExtra("revision");
        String[] vectorStrings = intent.getStringArrayExtra("correcta");
        System.out.println("Vector de booleanos:");
        for (boolean valor : vectorBooleanos) {
            System.out.println(String.valueOf(valor));
        }

        System.out.println("Vector de strings:");
        for (String valor : vectorStrings) {
            System.out.println(valor);
        }
        LinearLayout principal = findViewById(R.id.resul);
        for(int u=0;u<vectorStrings.length;u++){
            if(vectorStrings[u]!=null&&!vectorStrings[u].equals("")){

                LinearLayout textLayout = new LinearLayout(this);
                textLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                textLayout.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout Guarda = new LinearLayout(this);
                textLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                textLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView = new ImageView(this);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(
                        70, // Ancho en píxeles
                        70, // Alto en píxeles
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                if(vectorBooleanos[u]){
                    imageView.setImageResource(R.drawable.palomita);
                }else{
                    imageView.setImageResource(R.drawable.tacha);
                }


                TextView preguntaTextView = new TextView(this);
                LinearLayout.LayoutParams preguntaParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        70, // Alto en píxeles
                        LinearLayout.LayoutParams.MATCH_PARENT);
                preguntaParams.setMargins(10, 10, 10, 10); // Márgenes (izquierda, arriba, derecha, abajo)
                preguntaTextView.setLayoutParams(preguntaParams);
                preguntaTextView.setText("Pregunta "+(u+1));
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
                respuestaTextView.setText(vectorStrings[u]);
                respuestaTextView.setTextColor(Color.parseColor("#020242"));
                respuestaTextView.setTextSize(25);
                respuestaTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                respuestaTextView.setGravity(Gravity.CENTER);
                Guarda.addView(imageView);
                textLayout.addView(preguntaTextView);
                textLayout.addView(respuestaTextView);
                Guarda.addView(textLayout);

                principal.addView(Guarda);
            }

       }
        Button btnEnviar = new Button(this);

        btnEnviar.setText("Siguiente");
        btnEnviar.setTextColor(getResources().getColor(android.R.color.white)); // Establecer color de texto
        btnEnviar.setTextSize(30); // Establecer tamaño de texto
        btnEnviar.setTypeface(null, Typeface.BOLD); // Establecer estilo de texto a negrita
        btnEnviar.setBackgroundColor(Color.parseColor("#FF99FF")); // Establecer color de fondo
        //Sacar promedio
        int con=0,tot=0;
        for(int a=0;a<vectorStrings.length;a++){
            if(vectorStrings[a]!=null&&!vectorStrings[a].equals("")) {
                if(vectorBooleanos[a]){
                    con++;
                }
                tot++;
            }
        }
        System.out.println(con+" "+tot);
        float promediof=(con*10)/tot;
        //mostrar
        TextView promedio = new TextView(this);
        LinearLayout.LayoutParams preguntaParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                70, // Alto en píxeles
                LinearLayout.LayoutParams.MATCH_PARENT);
        preguntaParams.setMargins(10, 10, 10, 10); // Márgenes (izquierda, arriba, derecha, abajo)
        promedio.setLayoutParams(preguntaParams);
        promedio.setText("Promedio tot: "+(promediof));
        promedio.setTextColor(Color.parseColor("#020242"));
        promedio.setTextSize(25);
        promedio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        promedio.setGravity(Gravity.CENTER);
        principal.addView(promedio);
        // Configurar el evento clic del botón (puedes personalizarlo según tus necesidades)
        if(promediof<7){
            btnEnviar.setOnClickListener(v -> {
                Toast.makeText(this, "Sorry no Pasaste", Toast.LENGTH_SHORT).show();
                finish();
            });
        }else{
            btnEnviar.setOnClickListener(v -> {
                Intent intent2 = new Intent(resultadosdin.this, menu.class);
                Toast.makeText(this, "Felicidades pasaste", Toast.LENGTH_SHORT).show();

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
        principal.addView(btnEnviar);



    }
}

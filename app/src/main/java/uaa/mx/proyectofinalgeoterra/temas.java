package uaa.mx.proyectofinalgeoterra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class temas extends AppCompatActivity {
    private String cadena="";
    private int longitud=0;
    private  ArrayList<ArrayList<String>> separado = new ArrayList<>();
    LinearLayout linearLayout ;
    private String para;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);

        Bundle recibeIngreso = getIntent().getExtras(); //Vamos a recibir los datos del parametro, obteniendo el intento y llamamos al método de getExtras
        // para obtener un objeto Bundle que contiene los datos

        para = recibeIngreso.getString("parametro"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        // y vamos a almacenarlos en una variable de tipo string

        linearLayout= findViewById(R.id.info);
        inicializa();

    }
    public void inicializa(){
        if(para.equals("pais")){
            cadena="(TI,Título:) (TE,Dice qué tipo de información contiene el mapa o el lugar que se representa.\n" +
                    "El título de este mapa es: “Carreteras y principales ciudades de México”.\n" +
                    "Rosa de los vientos: Es el símbolo que señala los cuatro puntos cardinales; Norte,\n" +
                    "Sur, Este y Oeste. En los mapas, la rosa de los vientos siempre orientará\n" +
                    "geográficamente señalando el norte hacia arriba. )(IM,https://i0.wp.com/alpoma.net/carto/wp-content/uploads/2019/07/An_Animated_Map_of_the_Earth.gif?ssl=1)";
            longitud=cadena.length();
            muestra();
        }

    }
    public void muestra(){
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        int divide=longitud;
        Pattern pattern = Pattern.compile("\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(cadena);
        int index=1;
        while (matcher.find()) {
            // Obtiene el código encontrado
            String codigo = matcher.group(1);
            System.out.println(  codigo);
            if(codigo.substring(0, 2).contains("TE")){
                TextView textView = new TextView(this);
                textView.setText(codigo.substring(3));
                // Cambia el color del texto
                textView.setTextColor(Color.argb(255,2,2,66));
                textView.setTextSize(26);
                textView.setTypeface(Typeface.DEFAULT);
                textView.setId(index);
                linearLayout.addView(textView);
            }else if (codigo.substring(0, 2).contains("TI")){
                System.out.println("ES TITULO");
                TextView textView = new TextView(this);
                textView.setText(codigo.substring(3)); // Configura el texto del TextView
                textView.setTextSize(32);
                textView.setTextColor(Color.argb(255,2,2,66));
                textView.setTypeface(null, Typeface.BOLD);
                textView.setGravity(Gravity.CENTER);
                textView.setId(index);
                linearLayout.addView(textView);
            }else if (codigo.substring(0, 2).contains("IM")){
                System.out.println("ES IMAGENES");
                //https://assets.stickpng.com/images/584df3ad6a5ae41a83ddee08.png
                ImageView imageView = new ImageView(this);

                // Definir el ancho y alto del ImageView
                int widthPixels = 300; // Ancho en píxeles
                int heightPixels = 400; // Alto en píxeles

                // Asignar las dimensiones al ImageView
                imageView.setLayoutParams(new LinearLayout.LayoutParams(widthPixels, heightPixels));

                // URL de la imagen en Internet que deseas cargar
                String imageUrl = codigo.substring(3);

                // Usar Glide para cargar la imagen desde Internet y asignarla al ImageView
                Glide.with(this)
                        .load(imageUrl)
                        .into(imageView);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,  // Ancho
                        LinearLayout.LayoutParams.WRAP_CONTENT   // Alto
                );

                layoutParams.gravity = Gravity.CENTER;  // Centra el ImageView en el LinearLayout
                imageView.setId(index);
                imageView.setLayoutParams(layoutParams);
                linearLayout.addView(imageView);
            }
            index++;
        }

    }
}

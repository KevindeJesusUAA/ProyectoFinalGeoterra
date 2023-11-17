package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class menu extends AppCompatActivity {
    private Button btnRegresar; //Declaramos un botón para regresar a la actividad principal
    private ImageButton btnMapas, btnContinentes, btnPaises, btnMaravillas, btnEstados;

    private String parametro;

    //En el método onCreate creamos la actividad y se configura
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Esta línea llama al método onCreate de la clase base (AppCompatActivity) para que realice sus tareas de inicialización
        setContentView(R.layout.menu); // Se carga la interfaz de usuario de la actividad a partir del archivo de diseño para que los distintos elementos
        // estén disponibles

        btnRegresar = findViewById(R.id.btnRegresar); // Obtenemos una referencia al elemento del botón de la interfaz de usuario llamado "btnRegresar"

        //Cuando se seleccione el boton de regresar, se ejecuta el código contenido dentro del método onClick
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual y vuelve a la anterior
            }
        });

        ImageView animatedImageView = findViewById(R.id.button5);

        // Carga y muestra el GIF animado en el ImageView
        Glide.with(this)
                .asGif()
                .load(R.drawable.paises)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(animatedImageView);

        btnMapas = findViewById(R.id.button3);

        btnMapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick

                Bundle parametro = new Bundle(); //Se crea una instancia de la clase Bundle
                parametro.putString("parametro", "mapas");//Vamos a asignar el tipo de dato que queremos compartir,
                // asignamos una llave o identificador para posteriormente recibirlo en la otra actividad
                // y por último, agregamos el texto que queremos compartir

                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(menu.this, temas.class);
                intent.putExtras(parametro); //Ahora vamos a agregar el parametro, al objeto intent
                startActivity(intent);

            }
        });

        btnContinentes = findViewById(R.id.button4);

        btnContinentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick

                Bundle parametro = new Bundle(); //Se crea una instancia de la clase Bundle
                parametro.putString("parametro", "continentes");//Vamos a asignar el tipo de dato que queremos compartir,
                // asignamos una llave o identificador para posteriormente recibirlo en la otra actividad
                // y por último, agregamos el texto que queremos compartir

                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(menu.this, temas.class);
                intent.putExtras(parametro); //Ahora vamos a agregar los datos del ingreso que proporcionó el usuario, al objeto intent
                startActivity(intent);

            }
        });

        btnPaises = findViewById(R.id.button5);

        btnPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick

                Bundle parametro = new Bundle(); //Se crea una instancia de la clase Bundle
                parametro.putString("parametro", "pais");//Vamos a asignar el tipo de dato que queremos compartir,
                // asignamos una llave o identificador para posteriormente recibirlo en la otra actividad
                // y por último, agregamos el texto que queremos compartir, que será la infomración del EditText

                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(menu.this, memorama.class); // Reemplaza "NuevaActividad" con el nombre de tu nueva actividad
                intent.putExtras(parametro); //Ahora vamos a agregar los datos del ingreso que proporcionó el usuario, al objeto intent
                startActivity(intent);

            }
        });

        btnMaravillas = findViewById(R.id.button6);

        btnMaravillas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick

                //Bundle parametro = new Bundle(); //Se crea una instancia de la clase Bundle
                //parametro.putString("parametro", "pais");//Vamos a asignar el tipo de dato que queremos compartir,
                // asignamos una llave o identificador para posteriormente recibirlo en la otra actividad
                // y por último, agregamos el texto que queremos comparti

                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(menu.this, explora.class);
                //intent.putExtras(parametro); //Ahora vamos a agregar los datos del ingreso que proporcionó el usuario, al objeto intent
                startActivity(intent);

            }
        });

        btnEstados = findViewById(R.id.button7);

        btnEstados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick

                //Bundle parametro = new Bundle(); //Se crea una instancia de la clase Bundle
                //parametro.putString("parametro", "pais");//Vamos a asignar el tipo de dato que queremos compartir,
                // asignamos una llave o identificador para posteriormente recibirlo en la otra actividad
                // y por último, agregamos el texto que queremos comparti

                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(menu.this, estadosMexico.class);
                //intent.putExtras(parametro); //Ahora vamos a agregar los datos del ingreso que proporcionó el usuario, al objeto intent
                startActivity(intent);

            }
        });
        
    }
}
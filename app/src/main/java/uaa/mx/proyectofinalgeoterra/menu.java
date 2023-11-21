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
    private String Nombre,id;
    //En el método onCreate creamos la actividad y se configura

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Esta línea llama al método onCreate de la clase base (AppCompatActivity) para que realice sus tareas de inicialización
        setContentView(R.layout.menu); // Se carga la interfaz de usuario de la actividad a partir del archivo de diseño para que los distintos elementos
        // estén disponibles
        //Regresa los datos
        Bundle recibeIngreso = getIntent().getExtras(); //Vamos a recibir los datos del parametro, obteniendo el intento y llamamos al método de getExtras
        // para obtener un objeto Bundle que contiene los datos

        Nombre = recibeIngreso.getString("Nombre"); //Para recoger los datos, utilizamos la variable de bundle y con el metodo getstring obtenemos la clave de parametro
        id= recibeIngreso.getString("Idusu");
        //System.out.println(Nombre+" "+id);
        // y vamos a almacenarlos en una variable de tipo string

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
                parametro.putString("parametro", "1");//Vamos a asignar el tipo de dato que queremos compartir,
                Bundle nom = new Bundle(); //Se crea una instancia de la clase Bundle
                nom.putString("Nombre", Nombre);
                Bundle ids = new Bundle(); //Se crea una instancia de la clase Bundle
                ids.putString("Idusu", id);

                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(menu.this, temas.class);
                intent.putExtras(parametro);
                intent.putExtras(nom);
                intent.putExtras(ids);
                startActivity(intent);

            }
        });

        btnContinentes = findViewById(R.id.button4);

        btnContinentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick


                Bundle parametro = new Bundle(); //Se crea una instancia de la clase Bundle
                parametro.putString("parametro", "2");//Vamos a asignar el tipo de dato que queremos compartir,
                Bundle nom = new Bundle(); //Se crea una instancia de la clase Bundle
                nom.putString("Nombre", Nombre);
                Bundle ids = new Bundle(); //Se crea una instancia de la clase Bundle
                ids.putString("Idusu", id);

                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(menu.this, temas.class);
                intent.putExtras(parametro);
                intent.putExtras(nom);
                intent.putExtras(ids);
                startActivity(intent);

            }
        });

        btnPaises = findViewById(R.id.button5);

        btnPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick

                Bundle parametro = new Bundle(); //Se crea una instancia de la clase Bundle
                parametro.putString("parametro", "2");//Vamos a asignar el tipo de dato que queremos compartir,
                Bundle nom = new Bundle(); //Se crea una instancia de la clase Bundle
                nom.putString("Nombre", Nombre);
                Bundle ids = new Bundle(); //Se crea una instancia de la clase Bundle
                ids.putString("Idusu", id);

                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(menu.this, memorama.class);
                intent.putExtras(parametro);
                intent.putExtras(nom);
                intent.putExtras(ids);
                startActivity(intent);
            }
        });

        btnMaravillas = findViewById(R.id.button6);

        btnMaravillas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Declaramos el método onClick

                Bundle parametro = new Bundle(); //Se crea una instancia de la clase Bundle
                parametro.putString("parametro", "2");//Vamos a asignar el tipo de dato que queremos compartir,
                Bundle nom = new Bundle(); //Se crea una instancia de la clase Bundle
                nom.putString("Nombre", Nombre);
                Bundle ids = new Bundle(); //Se crea una instancia de la clase Bundle
                ids.putString("Idusu", id);

                // Inicia la nueva actividad cuando se hace clic en el botón
                Intent intent = new Intent(menu.this, explora.class);
                intent.putExtras(parametro);
                intent.putExtras(nom);
                intent.putExtras(ids);
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

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        if( dbHelper.existeRegistro(""+id,"1")){
            btnMapas.setBackgroundResource(R.drawable.t_mapa);
        }
        if ( dbHelper.existeRegistro(""+id,"2")) {
            System.out.println(":)");
            btnContinentes.setBackgroundResource(R.drawable.t_continentes);
        }
        if ( dbHelper.existeRegistro(""+id,"3")) {
            btnPaises.setBackgroundResource(R.drawable.t_paisesc);
        }
        if ( dbHelper.existeRegistro(""+id,"4")) {
            btnMaravillas.setBackgroundResource(R.drawable.t_maravillas);
        }
        if ( dbHelper.existeRegistro(""+id,"5")) {
            btnEstados.setBackgroundResource(R.drawable.t_estados);
        }


    }
}
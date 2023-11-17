package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;

public class registro extends AppCompatActivity {
    private Button btnRegresar,btnavanza,btncolor; //Declaramos un botón para regresar a la actividad principal
    private ImageButton btnMapas, btnContinentes, btnPaises;

    private String parametro;

    private static final int SELECT_PICTURE = 1;
    private Button cargarImagenButton;
    private String ruta="";
    private EditText da1,da2,da3,da4;
    private int colors=-1;
    private static final int PICK_IMAGE_REQUEST = 1;
    //En el método onCreate creamos la actividad y se configura
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Esta línea llama al método onCreate de la clase base (AppCompatActivity) para que realice sus tareas de inicialización
        setContentView(R.layout.registro); // Se carga la interfaz de usuario de la actividad a partir del archivo de diseño para que los distintos elementos
        // estén disponibles
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        /*dbHelper.agregarDato("Ejemplo 1");
        List<String> datos = dbHelper.obtenerTodosLosDatos();
        for (String dato : datos) {
            System.out.println(dato);
        }*/
        //mysqlConnection.ejecutarConsulta("Select * from Usuarios");
        btnRegresar = findViewById(R.id.btnRegresar); // Obtenemos una referencia al elemento del botón de la interfaz de usuario llamado "btnRegresar"
        btncolor=findViewById(R.id.color);
        da1=findViewById(R.id.ingreso);
        da2=findViewById(R.id.edad);
        da3=findViewById(R.id.contra);
        //Cuando se seleccione el boton de regresar, se ejecuta el código contenido dentro del método onClick
        btncolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    pickercolor();

            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;


                finish(); // Cierra la actividad actual y vuelve a la anterior
            }
        });
        btnavanza=findViewById(R.id.avanzarButton);


        cargarImagenButton = findViewById(R.id.cargarImagenButton);
        btnavanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(colors!=-1&&!ruta.equals("")&&!da1.getText().toString().trim().equals("")&&!da2.getText().toString().trim().equals("")&&!da3.getText().toString().trim().equals("")){
                    long newRowId =dbHelper.insertUsuario(String.valueOf(da1.getText()),String.valueOf(da3.getText()),String.valueOf(da2.getText()), String.valueOf(colors),ruta);
                    if (newRowId != -1) {
                        // Inserción exitosa
                        Toast.makeText(registro.this, "Nuevo Usuario Registrado", Toast.LENGTH_SHORT).show();
                        List<HashMap<String, String>> users = dbHelper.getAllUsers();

                        for (HashMap<String, String> user : users) {
                            String id = user.get("id");
                            String nombre = user.get("nombre");
                            String contraseña = user.get("contraseña");
                            String edad = user.get("edad");
                            String color = user.get("color");
                            String direccion = user.get("direccion");
                            String userData = "ID: " + id + ", Nombre: " + nombre + ", Contraseña: " + contraseña + ", Edad: " + edad + ", Color: " + color+", direccion "+direccion;
                            System.out.println(userData);
                        }
                        finish();
                    } else {
                        // Manejo de error
                        Toast.makeText(registro.this, "No Se Pudo Registrar", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(registro.this, "Ups Faltan Datos Por Dar", Toast.LENGTH_SHORT).show();
                }



            }
        });
        cargarImagenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, SELECT_PICTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                ImageView imageView = findViewById(R.id.imageView); // Reemplaza R.id.imageView con el ID real de tu ImageView
                imageView.setImageBitmap(bitmap);
                ruta= String.valueOf(selectedImageUri);
                System.out.println("imagen:::::::::::::"+selectedImageUri);

                // Realiza acciones con la imagen cargada
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    void pickercolor(){
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, 0 , new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                // color is the color selected by the user.
                colors=color;
                ImageView imageView = findViewById(R.id.imageView2);
                imageView.setBackgroundColor(colors); // Establece el color de fondo en rojo



            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // cancel was selected by the user
            }
        });
        dialog.show();
    }


    public void seleccionarImagen(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen"), PICK_IMAGE_REQUEST);
    }

}
package uaa.mx.proyectofinalgeoterra;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.io.IOException;

public class registro extends AppCompatActivity {
    private Button btnRegresar; //Declaramos un botón para regresar a la actividad principal
    private ImageButton btnMapas, btnContinentes, btnPaises;

    private String parametro;

    private static final int SELECT_PICTURE = 1;
    private Button cargarImagenButton;

    //En el método onCreate creamos la actividad y se configura
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Esta línea llama al método onCreate de la clase base (AppCompatActivity) para que realice sus tareas de inicialización
        setContentView(R.layout.registro); // Se carga la interfaz de usuario de la actividad a partir del archivo de diseño para que los distintos elementos
        // estén disponibles

        btnRegresar = findViewById(R.id.btnRegresar); // Obtenemos una referencia al elemento del botón de la interfaz de usuario llamado "btnRegresar"

        //Cuando se seleccione el boton de regresar, se ejecuta el código contenido dentro del método onClick
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad actual y vuelve a la anterior
            }
        });


        cargarImagenButton = findViewById(R.id.cargarImagenButton);

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
                // Realiza acciones con la imagen cargada
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
package uaa.mx.proyectofinalgeoterra;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ReconocimientoActivity extends AppCompatActivity {

    private String nombre, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconocimiento);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String fechaActual = dateFormat.format(calendar.getTime());

        Bundle recibeIngreso = getIntent().getExtras();
        if (recibeIngreso != null) {
            nombre = recibeIngreso.getString("Nombre");
            id = recibeIngreso.getString("Idusu");
        }

        CanvasView canvasView = findViewById(R.id.canvasView);
        canvasView.setData(fechaActual, nombre);
    }
}
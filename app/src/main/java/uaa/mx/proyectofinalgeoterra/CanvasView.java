package uaa.mx.proyectofinalgeoterra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CanvasView extends View {

    private Paint paint;
    private String fechaActual;
    private String nombre;

    public CanvasView(Context context) {
        super(context);
        init();
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(50);
        paint.setColor(Color.WHITE);
    }

    public void setData(String fechaActual, String nombre) {
        this.fechaActual = fechaActual;
        this.nombre = nombre;
        invalidate(); // Vuelve a dibujar la vista
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Marco con imagen de fondo
        drawFrame(canvas);

        // Texto de fecha y nombre
        drawText(canvas, fechaActual, 630);
        drawText(canvas, nombre, 500);
    }

    private void drawCenteredText(Canvas canvas, String text, float y) {
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        float x = (canvas.getWidth() - bounds.width()) / 2f;
        canvas.drawText(text, x, y, paint);
    }
    private void drawFrame(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fondoreco);

        // Definir las coordenadas del rectángulo que ocupará la imagen de fondo
        float left = 20;
        float top = 100;

        // Calcular la relación de aspecto de la imagen original
        float originalWidth = bitmap.getWidth();
        float originalHeight = bitmap.getHeight();
        float aspectRatio = originalWidth / originalHeight;

        // Calcular la nueva altura basada en el ancho del rectángulo
        float rectangleWidth = canvas.getWidth() - 40; // Ancho del rectángulo
        float rectangleHeight = rectangleWidth / aspectRatio;

        float right = canvas.getWidth() - 20;
        float bottom = top + rectangleHeight;

        if (bitmap != null) {
            canvas.drawBitmap(bitmap, null, new RectF(left, top, right, bottom), paint);
        }
    }

    private void drawText(Canvas canvas, String text, float y) {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(40);

        drawCenteredText(canvas, text, y);
    }
}
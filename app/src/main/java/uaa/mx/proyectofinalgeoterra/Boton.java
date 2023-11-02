package uaa.mx.proyectofinalgeoterra;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

public class Boton extends androidx.appcompat.widget.AppCompatButton{

    float escala = getResources().getDisplayMetrics().density;
    Paint pFondo = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pFondoPress = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pTexto = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Boton(Context context){
        super(context);
        inicializa();
    }
    public Boton(Context context, AttributeSet attrs){
        super(context, attrs);
        inicializa();
    }
    public Boton(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        inicializa();
    }
    private void inicializa(){
        pFondo.setColor(Color.BLUE);
        pFondo.setStyle(Paint.Style.FILL);

        pFondoPress.setColor(Color.GREEN);
        pFondoPress.setStyle(Paint.Style.FILL);

        pTexto.setColor(Color.WHITE);
        pTexto.setTextSize(50f);
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(this.isPressed()){
            canvas.drawRect(0,
                    0,
                    getWidth()*escala,
                    getHeight()*escala,pFondoPress);
        }else{
            canvas.drawRect(0,
                    0,
                    getWidth()*escala,
                    getHeight()*escala,pFondo);
        }
        canvas.drawText(getText().toString(),
                10*escala,
                getHeight()-5*escala,pTexto);


    }
}

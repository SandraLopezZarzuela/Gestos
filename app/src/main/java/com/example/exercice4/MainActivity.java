package com.example.exercice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private GestureDetector gestos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        gestos = new GestureDetector(this, new EscuchaGestos());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Si no hacemos este codigo no podremos llamar nunca a la clase escuchagestos
        gestos.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    //Utilizamos simple para sobreescribir sus metodos
    class EscuchaGestos extends GestureDetector.SimpleOnGestureListener {

        @Override
        public void onLongPress(MotionEvent e) {
            tv1.setText("Presion larga");
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            tv1.setText("Doble toque");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            tv1.setText("Presion");
        }

        //Metodo desplazamiento
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float ancho = Math.abs(e2.getX() - e1.getX());
            float alto = Math.abs(e2.getY() - e1.getY());
            if (ancho > alto) {
                if (e2.getX() > e1.getX()) {
                    tv1.setText("derecha");
                } else {
                    tv1.setText("izquierda");
                }

            } else {
                if (e2.getY() > e1.getY()) {
                    tv1.setText("abajo");
                } else {
                    tv1.setText("arriba");
                }
            }
            return true;
        }
    }
}
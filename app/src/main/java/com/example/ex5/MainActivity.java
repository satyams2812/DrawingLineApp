package com.example.ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity implements View.OnTouchListener
{
    ImageView iv;
    Bitmap b;
    Canvas c;
    Paint p;
    float dx=0,dy=0,ux=0,uy=0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView)this.findViewById(R.id.imageView1);
        Display d = getWindowManager().getDefaultDisplay();
        float dw = d.getWidth();
        float dh = d.getHeight();
        b	= Bitmap.createBitmap((int) dw, (int) dh,Bitmap.Config.ARGB_8888);
        c	= new Canvas(b);

        p = new Paint();
        p.setColor(Color.BLUE);
        iv.setImageBitmap(b);
        iv.setOnTouchListener((View.OnTouchListener) this);



    }

    public boolean onTouch(View v, MotionEvent event) {

  int action = event.getAction(); switch (action)
        {
            case MotionEvent.ACTION_DOWN:

                dx = event.getX();
                dy = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                ux = event.getX();
                uy = event.getY();
                c.drawLine(dx, dy, ux, uy, p);
                iv.invalidate();
                break;
            case MotionEvent.ACTION_CANCEL:

                break;
            default:
                break;
        }
        return true;

    }

}


package com.example.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.shape.TriangleEdgeTreatment;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText= new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),R.color.purple_200, null));
        mPaintText.setTextSize(80);
    }

    public void drawSomething(View view) {
        int vWidth=view.getWidth();
        int vHeight=view.getHeight();
        mBitmap=Bitmap.createBitmap(vWidth,vHeight,Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas=new Canvas(mBitmap);
        mCanvas.drawColor(Color.RED);
        mCanvas.drawText("Ninin",500,500,mPaintText);

        mPaint.setColor(Color.MAGENTA);

        Path path= new Path();
        path.moveTo(100, 200);
        path.lineTo(300, 100);
        path.lineTo(500, 200);
        //path.lineTo(700, 800);
        mPaint.setColor(Color.MAGENTA);
        mCanvas.drawPath(path,mPaint);

        mPaint.setColor(Color.GRAY);
        Rect mRect= new Rect();
        mRect.set(100,200,500,400);
        mCanvas.drawRect(mRect,mPaint);

        mPaint.setColor(Color.WHITE);
        mRect.set(250,275,350,400);
        mCanvas.drawRect(mRect,mPaint);
    }
}

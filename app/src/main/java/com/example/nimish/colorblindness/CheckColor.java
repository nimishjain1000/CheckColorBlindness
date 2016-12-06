package com.example.nimish.colorblindness;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckColor extends AppCompatActivity {

    ImageView imageView;
    TextView pixelpoint;
//    CreateHashMap hash;
    public void upload(View v) {
        Intent i = new Intent(getApplicationContext(),CheckColor.class);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_color);
        imageView=(ImageView)findViewById(R.id.imageView);
        pixelpoint = (TextView)findViewById(R.id.textView);
        Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null)
        {
            //Bundle video = data.getExtras();
            Uri  mImageCaptureUri = data.getData();
            imageView.setImageURI(mImageCaptureUri);
            imageView.setOnTouchListener(imgViewOnTouchListener);
        }
    }

    View.OnTouchListener imgViewOnTouchListener
            = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View view, MotionEvent event) {

            float eventX = event.getX();
            float eventY = event.getY();
            float[] eventXY = new float[] {eventX, eventY};

            Matrix invertMatrix = new Matrix();
            ((ImageView)view).getImageMatrix().invert(invertMatrix);

            invertMatrix.mapPoints(eventXY);
            int x = Integer.valueOf((int)eventX);
            int y = Integer.valueOf((int)eventY);

            Drawable imgDrawable = ((ImageView)view).getDrawable();
            Bitmap bitmap = ((BitmapDrawable)imgDrawable).getBitmap();


            //Limit x, y range within bitmap
            if(x < 0){
                x = 0;
            }else if(x > bitmap.getWidth()-1){
                x = bitmap.getWidth()-1;
            }

            if(y < 0){
                y = 0;
            }else if(y > bitmap.getHeight()-1){
                y = bitmap.getHeight()-1;
            }

            int touchedRGB = bitmap.getPixel(x, y);

            int redValue = Color.red(touchedRGB);
            int blueValue = Color.blue(touchedRGB);
            int greenValue = Color.green(touchedRGB);


            pixelpoint.setText(""+String.valueOf(redValue)+" "+String.valueOf(blueValue)+" "+String.valueOf(greenValue));
            pixelpoint.setTextColor(touchedRGB);

            return true;
        }};

    public void exit(View view)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }



}

package joni.tattoo.studio;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Joni on 3/3/14.
 */







public class AddTattoo1 extends Activity implements SurfaceHolder.Callback {
    Camera camera;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    boolean previewing = false;
    LayoutInflater controlInflater = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.addtattoo1);

        final ImageButton btnTakePhoto = (ImageButton)findViewById(R.id.btnTakePhoto);

        surfaceView = (SurfaceView)findViewById(R.id.camerapreview);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);


        controlInflater = LayoutInflater.from(this);

        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera.autoFocus(new Camera.AutoFocusCallback() {
                    @Override
                    public void onAutoFocus(boolean success, Camera camera) {
                        takePhoto(btnTakePhoto);
                    }
                });

            }
        });

        Button nextbut= (Button) findViewById(R.id.nextbutton);
        nextbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddTattoo1.this, AddTattoo2.class));
            }
        });

    }

    private void takePhoto(View v){
        prepareCamera();
        try {
            camera.takePicture(null, null, null, new Camera.PictureCallback() {

                @Override
                public void onPictureTaken(byte[] data, Camera camera) {
                    try{
                        Bitmap photo = BitmapFactory.decodeByteArray(data, 0, data.length);
                        ((ImageView)findViewById(R.id.imageView)).setVisibility(View.VISIBLE);
                        ((ImageView)findViewById(R.id.imageView)).setImageBitmap(photo);
                    }catch (OutOfMemoryError oom){
                        oom.printStackTrace();
                        ((ImageView)findViewById(R.id.imageView)).setVisibility(View.GONE);
                        prepareCamera();
                    }

                }
            });
        }catch (RuntimeException e){
            e.printStackTrace();
            Toast.makeText(AddTattoo1.this, "Taking picture failed!", Toast.LENGTH_LONG).show();
        }
    }

    private void savePicture(byte[] bytes){
        try{
            Matrix Samsung = new Matrix();
            Samsung.postRotate(90);

            Bitmap photo = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            //Bitmap croppedBmp = Bitmap.createBitmap(photo,photo.getWidth()/2-800, photo.getHeight()/2-800, 1600, 1600,Samsung,false);

            //ByteArrayOutputStream testbyte=new ByteArrayOutputStream();
            //croppedBmp.compress(Bitmap.CompressFormat.JPEG,80,testbyte);
            //byte[] testarray=testbyte.toByteArray();

            ((ImageView)findViewById(R.id.kutiyka)).setImageBitmap(photo);

            File Snimka = new File("/storage/emulated/0/JoniInkImages");
            if(!Snimka.exists()) {
                Snimka.mkdir();
            }

            FileOutputStream fos = new FileOutputStream("/storage/emulated/0/JoniInkImages"+"/"+getDate()+".jpg");
            fos.write(bytes);
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy'_'HH:mm:ss");
        return sdf.format(new Date());
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        camera = Camera.open();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if(previewing){
            camera.stopPreview();
            previewing = false;
        }
        prepareCamera();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        destroyCamera();
    }

    void prepareCamera(){
        if(camera==null)
            camera = Camera.open();

        if (camera != null){
            try {
                camera.setPreviewDisplay(surfaceHolder);
                camera.startPreview();
                previewing = true;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    void destroyCamera(){
        if(camera!=null){
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }
}
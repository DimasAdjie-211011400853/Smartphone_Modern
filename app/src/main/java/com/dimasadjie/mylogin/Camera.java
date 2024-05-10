package com.dimasadjie.mylogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {
    private com.google.android.material.button.MaterialButton cam;
    private ImageView hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        cam = (com.google.android.material.button.MaterialButton) findViewById(R.id.cam);
        hasil = (ImageView) findViewById(R.id.imgview);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            },0);
        }

        cam.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                takePict();
            }
        });
    }

    public void takePict(){
        Intent picIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(picIntent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            Bitmap img = (Bitmap) data.getExtras().get("data");
            hasil.setImageBitmap(img);
        }
    }

}
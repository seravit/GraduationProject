package com.example.graduationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int PERMISSION_CAMERA = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int perm = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        if (perm != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 승인 하지않음",
                    Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA},
                    PERMISSION_CAMERA);
        }
        else { //권한 승인 상태
            //카메라 띄우기
        }

    }

    public void onRequestPermissionsResult (int requestCode,
                                            @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "권한 승인 상태", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "권한 미승인 상태", Toast.LENGTH_LONG).show();
                this.finish();
            }
        }
    }
}
package com.islavdroid.surfaceapp;

import android.hardware.Camera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Camera mCamera = null;
    private Camera frontCamera = null;
    public int time = 0;
    TextView timer;
    private CameraView mCameraView = null;
    private CameraView frontCameraView = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         timer =(TextView)findViewById(R.id.timer);
        TimerTextHelper timerTextHelper = new TimerTextHelper(timer);
        timerTextHelper.start();


     /*   Timer t = new Timer();

        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        timer.setText(String.valueOf(time));
                        time += 1;
                    }
                });
            }
        }, 0, 1000);*/





    try{
        //Camera frontCamera =Camera.open(1);
       // frontCamera=Camera.open(1);
            mCamera = Camera.open(1);//you can use open(int) to use different cameras
        } catch (Exception e){
            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
        }

        if(mCamera != null) {
            mCameraView = new CameraView(this, mCamera);//create a SurfaceView to show camera data
           // frontCameraView=new CameraView(this, frontCamera);
            FrameLayout camera_view = (FrameLayout)findViewById(R.id.camera_view);
            FrameLayout frontcamera_view = (FrameLayout)findViewById(R.id.frontcamera_view);
            //camera_view.addView(mCameraView);//add the SurfaceView to the layout
            frontcamera_view.addView(mCameraView);
        }

        //btn to close the application
       /* ImageButton imgClose = (ImageButton)findViewById(R.id.imgClose);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });*/
    }}
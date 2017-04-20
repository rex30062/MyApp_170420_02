package com.cclz.myapp_170420_02;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream is=getResources().openRawResource(R.raw.test1);
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String str=null;
        try {
            str=br.readLine();
            br.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("MFILE", str);
    }

    public void click1(View v){
        File f1= Environment.getExternalStorageDirectory();
        Log.d("MFILE", "f1: " + f1.toString());
        File f2=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        Log.d("MFILE", "f2: " + f2.toString());
        try {
            FileWriter fw=new FileWriter((f1.toString() + File.separator + "test2.txt"));
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("Hello");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

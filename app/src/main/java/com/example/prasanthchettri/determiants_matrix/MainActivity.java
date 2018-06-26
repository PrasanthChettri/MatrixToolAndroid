package com.example.prasanthchettri.determiants_matrix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    public Button but , but2 , but3;
    public MainAlgorithm algo ;
    public EditText input[][] ;
    public int refinedInput[][] , size ;
    public TextView tex[][];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = new EditText[4][4];
        tex = new TextView[4][4];
        but = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but3 = findViewById(R.id.but3);
        algo = new MainAlgorithm();
        but.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        getelements();
                        Toast.makeText(getApplicationContext(), String.valueOf(algo.mainlooper(refinedInput , size)), Toast.LENGTH_LONG).show();
                    }
                }
        );
        but2.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        getelements();
                        for (int i = 0 ; i < size ; i++){
                            for (int j = 0 ; j < size ; j++){
                                tex[i][j].setText(String.valueOf((float)(algo.mainloop_adjont()[i][j]/algo.mainlooper(refinedInput , size))) );
                            }
                        }
                    }
                }
        );
        but3.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        getelements();
                        for (int i = 0 ; i < size ; i++){
                            for (int j = 0 ; j < size ; j++){
                                tex[i][j].setText(Integer.toString(algo.transpose(size , refinedInput)[i][j]));
                            }
                        }
                    }
                }
        );


    }

    //utility functions
    void getelements(){
        size();
        refinedInput = new int[size][size];
        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ; j++)
                refinedInput[i][j] = Integer.parseInt(input[i][j].getText().toString());
        }
        algo.getdata(refinedInput);
    }
    void  size() {
        int sizef = 4 ;
        boolean k  = true ;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                input[i][j] = findViewById(getResources().getIdentifier("ed" +i+ j , "id" , getPackageName())) ;
                tex[i][j] = findViewById(getResources().getIdentifier("tex" + i + j , "id" ,getPackageName()));
                if (input[i][j].getText().toString().equals("") && k){
                    sizef = j ;
                    k = false ;
                }
            }
            }
             size  = sizef;
        }

}

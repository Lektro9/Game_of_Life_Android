package com.example.gameoflifemyapp.scoop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameoflifemyapp.R;

public class MainActivity extends AppCompatActivity{


    private TextView myText;
    private EditText heightText;
    private EditText probText;
    private EditText sizeModText;
    private EditText cycleTimeText;

    int height = 200;
    int probability = 20;
    int sizeMod = 2;
    int cycleTime = 50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        Button btnClick = findViewById(R.id.button2);
        myText = findViewById(R.id.text);
        heightText = findViewById(R.id.editText);
        probText = findViewById(R.id.editText3);
        sizeModText = findViewById(R.id.editText4);
        cycleTimeText = findViewById(R.id.editText5);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hInput = heightText.getText().toString().trim();
                String pInput = probText.getText().toString().trim();
                String smInput = sizeModText.getText().toString().trim();
                String ctInput = cycleTimeText.getText().toString().trim();

                if(hInput.isEmpty() || hInput.length() == 0 || hInput.equals("") || hInput == null)
                {
                    //EditText is empty
                }
                else
                {
                    height = Integer.parseInt(hInput);
                }


                if(pInput.isEmpty() || pInput.length() == 0 || pInput.equals("") || pInput == null)
                {
                    //EditText is empty
                }
                else
                {
                    probability = Integer.parseInt(pInput);
                }

                if(smInput.isEmpty() || smInput.length() == 0 || smInput.equals("") || smInput == null)
                {
                    //EditText is empty
                }
                else
                {
                    sizeMod = Integer.parseInt(smInput);
                }

                if(ctInput.isEmpty() || ctInput.length() == 0 || ctInput.equals("") || ctInput == null)
                {
                    //EditText is empty
                }
                else
                {
                    cycleTime = Integer.parseInt(ctInput);
                }
                openGoLAcitivity();
            }
        });
        super.onCreate(savedInstanceState);

    }
    public void openGoLAcitivity() {
        System.out.println(height);
        Intent intent = new Intent(this, GoLActivity.class);
        intent.putExtra("height", height);
        intent.putExtra("probability", probability);
        intent.putExtra("sizeMod", sizeMod);
        intent.putExtra("cycleTime", cycleTime);
        startActivity(intent);
    }
}

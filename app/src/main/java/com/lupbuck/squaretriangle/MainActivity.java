package com.lupbuck.squaretriangle;

import static android.content.ContentValues.TAG;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber;
    private Button bVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumber = findViewById(R.id.etNumber);
        bVerify = findViewById(R.id.bVerify);

        bVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(etNumber.getText().toString());
                verify(num);
            }
        });

    }

    public void verify(int num) {
        String answer = "";
        if(isSquare(num) && isTriangle(num)) {
           answer = " is square an triangle";
        } else if(isSquare(num)) {
            answer = " is Square but not a triangle";
        } else if(isTriangle(num)) {
            answer = " is not a square but is Triangle";
        } else {
            answer = " Is not a square and is not a Triangle";
        }
        Toast.makeText(this, num + answer, Toast.LENGTH_LONG).show();
    }

    private boolean isSquare(int num) {
       boolean square = false;
       int sqrt = (int)(Math.sqrt(num));
       if(sqrt*sqrt == num) {
           square = true;
       }
       return square;
    }

    private boolean isTriangle(int num) {
        boolean triangle = false;
        int i = 1;
        int sum = 0;
        while(sum < num){
            sum += i;
            i++;
        }
        Log.w(TAG, "isTriangle: "+sum + " y " + num );
        if(sum == num){
            triangle = true;
        }

        return triangle;
    }
}
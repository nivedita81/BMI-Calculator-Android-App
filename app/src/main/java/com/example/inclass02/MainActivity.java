/* Assignment InClass02
FileName: MainActivity.java
Team Members : Vaishali Krishnamurthy,Nivedita Veeramanigandan
 */
package com.example.inclass02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private EditText et_weight;
    private EditText et_height_feet;
    private EditText et_height_inch;

    private TextView tv_result;
    private TextView tv_verdict;

    private Button bmi_button;

    double weight = 0.0;
    int feet = 0;
    int inches = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_weight = findViewById(R.id.et_weight);
        et_height_feet = findViewById(R.id.et_heightfeet);
        et_height_inch = findViewById(R.id.et_heightinch);

        tv_result = findViewById(R.id.tv_result);
        tv_verdict = findViewById(R.id.tv_verdict);

        bmi_button = findViewById(R.id.bmi_button);

        bmi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight_text = et_weight.getText().toString();
                String feet_text = et_height_feet.getText().toString();
                String inches_text = et_height_inch.getText().toString();

                if(weight_text.equals("")){
                    et_weight.setError("Can't be empty!");
                    Toast.makeText(MainActivity.this, "Can't be empty!!!", Toast.LENGTH_SHORT).show();
                }else{
                    weight = Double.parseDouble(weight_text);
                }


                if (feet_text.equals("")){
                    et_height_feet.setError("Can't be empty!");
                    Toast.makeText(MainActivity.this, "Can't be empty!!!", Toast.LENGTH_SHORT).show();
                }else {
                    feet = Integer.parseInt(feet_text);
                }


                if(inches_text.equals("")){
                    et_height_inch.setError("Can't be empty!");
                    Toast.makeText(MainActivity.this, "Can't be empty!!!", Toast.LENGTH_SHORT).show();
                }else{
                    inches = Integer.parseInt(inches_text);
                }

                inches = inches + feet*12;
                double bmi = (weight/(inches*inches))*703;
                double bmi_round = Math.round(bmi*100)/100.00;

                Log.d("demo", "weight"+weight+"feet"+feet+"inches"+inches);

                tv_result.setText("Your BMI: " + bmi_round);

                if(bmi<=18.5){
                    tv_verdict.setText("You are underweight");
                }else if(bmi>18.5 && bmi<=24.9){
                    tv_verdict.setText("You are normal weight");
                }else if(bmi>25 && bmi<=29.9){
                    tv_verdict.setText("You are overweight");
                }else{
                    tv_verdict.setText("You are obese");
                }

                Toast.makeText(MainActivity.this,"BMI Calculated",Toast.LENGTH_SHORT).show();

            }
        });
    }
}

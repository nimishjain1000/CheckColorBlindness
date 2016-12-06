package com.example.nimish.colorblindness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Test2Actvity extends AppCompatActivity {


    CheckBox ONE,TWO,THREE,FOUR;
    Button MultiData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2_actvity);

        ONE = (CheckBox)findViewById(R.id.checkbox1);
        TWO = (CheckBox)findViewById(R.id.checkbox2);
        THREE = (CheckBox)findViewById(R.id.checkBox3);
        FOUR = (CheckBox)findViewById(R.id.checkBox4);

        MultiData = (Button)findViewById(R.id.button1);

        MultiData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(ONE.isChecked())
                {
                    Toast.makeText(Test2Actvity.this, "Red Green color blindness", Toast.LENGTH_SHORT).show();

                }
                if(TWO.isChecked())
                {
                    Toast.makeText(Test2Actvity.this, "Red Green color blindness", Toast.LENGTH_SHORT).show();

                }
                if(THREE.isChecked())
                {
                    Toast.makeText(Test2Actvity.this, "Normal", Toast.LENGTH_SHORT).show();
                }
                if(FOUR.isChecked())
                {
                    Toast.makeText(Test2Actvity.this, "You are fibbling", Toast.LENGTH_SHORT).show();

                }
                Toast.makeText(Test2Actvity.this, "Now check color of any image", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),CheckColor.class);
                startActivity(intent);

            }
        });


    }

}

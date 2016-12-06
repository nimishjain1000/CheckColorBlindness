package com.example.nimish.colorblindness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by Nimish on 06-Dec-16.
 */

public class TestActivity extends AppCompatActivity {

    CheckBox ONE,TWO,THREE,FOUR;
    Button MultiData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);

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
                    Toast.makeText(TestActivity.this, "false", Toast.LENGTH_SHORT).show();

                }
                if(TWO.isChecked())
                {
                    Toast.makeText(TestActivity.this, "false", Toast.LENGTH_SHORT).show();

                }
                if(THREE.isChecked())
                {
                    Toast.makeText(TestActivity.this, "true", Toast.LENGTH_SHORT).show();
                }
                if(FOUR.isChecked())
               {
                    Toast.makeText(TestActivity.this, "false", Toast.LENGTH_SHORT).show();

                }
                Intent intent = new Intent(getApplicationContext(),Test1Activity.class);
                startActivity(intent);

            }
        });


    }

}


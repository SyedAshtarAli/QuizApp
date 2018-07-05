package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText name;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Quiz Mania");


        switching_Activity();




    }
    public void switching_Activity()
    {
        name=(EditText)findViewById(R.id.main_editText_name);
        btn= (Button) findViewById(R.id.main_btn_start);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().equals(""))
                {
                    print_mesg();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("Name", name.getText().toString());
                    startActivity(intent);
                }
            }
        });





    }
    public void print_mesg()
    {
        Toast.makeText(this, "Enter your name.", Toast.LENGTH_LONG).show();
    }

}





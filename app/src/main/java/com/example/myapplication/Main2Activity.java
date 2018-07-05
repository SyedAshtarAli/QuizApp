package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    String[][] str= new String[5][5];
    TextView quesNo;
    TextView Statement;
    RadioButton op1;
    RadioButton op2;
    RadioButton op3;
    RadioButton op4;
    Button nextBtn;
    Button finish;
    RadioGroup rg;
    TextView total, obt;

    int score=0;
    int count=0;
    TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("Quiz Mania");
        rg=findViewById(R.id.radioGroup2);


        set_options(count);




        count++;
        print_Name();

        nextBtn=findViewById(R.id.quiz_btn_next);
        op1=findViewById(R.id.quiz_radio_op1);
        op2=findViewById(R.id.quiz_radio_op2);
        op3=findViewById(R.id.quiz_radio_op3);
        op4=findViewById(R.id.quiz_radio_op4);

        finish=findViewById(R.id.quiz_btn_finish);
        finish.setVisibility(View.GONE);
        total=findViewById(R.id.quiz_text_total);
        obt=findViewById(R.id.quiz_text_obt);
        total.setVisibility(View.GONE);
        obt.setVisibility(View.GONE);




       nextBtn.setOnClickListener(this);
       finish.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        int a=rg.getCheckedRadioButtonId();
        rg.clearCheck();
        if(a==R.id.quiz_radio_op1 || a==R.id.quiz_radio_op2 ||a==R.id.quiz_radio_op3 || a==R.id.quiz_radio_op4){
            //Toast.makeText(this,"Choose an option",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Choose an option",Toast.LENGTH_LONG).show();
            return;

        }
        if(view==nextBtn){
            if(R.id.quiz_radio_op1==a && count==2)
            {
                score=score+10;
            }
            if(R.id.quiz_radio_op1==a && count==3)
            {
                score=score+10;
            }
            if(R.id.quiz_radio_op3==a && count==4)
            {
                score=score+10;
            }

            if(count>0) {
                if(R.id.quiz_radio_op4==a && count==1)
                {
                    score=score+10;
                }
               set_options(count);
                count++;
            }

            if(count==5)
            {

                nextBtn.setVisibility(View.GONE);
                finish.setVisibility(View.VISIBLE);
            }

        }
        else if(view==finish)
        {
            if(count==78){
                Toast.makeText(this,"Choose an option",Toast.LENGTH_LONG).show();
                return;

            }
            if(R.id.quiz_radio_op3==a && count==5)
            {
                score=score+10;
            }
            quesNo.setVisibility(View.GONE);
            Statement.setVisibility(View.GONE);
            op1.setVisibility(View.GONE);
            op2.setVisibility(View.GONE);
            op3.setVisibility(View.GONE);
            op4.setVisibility(View.GONE);
            total.setVisibility(View.VISIBLE);
            obt.setVisibility(View.VISIBLE);



            obt.setText("Obtained Score: "+score+"");
        }
    }






































    public void print_Name()
    {
        nameText= findViewById(R.id.quiz_text_name);
        nameText.setText(getIntent().getExtras().getString("Name"));
    }
    public void set_options(int q)
    {
        quesNo=findViewById(R.id.quiz_textView_quesNo);
        Statement= findViewById(R.id.quiz_text_ques);
        op1=findViewById(R.id.quiz_radio_op1);
        op2=findViewById(R.id.quiz_radio_op2);
        op3=findViewById(R.id.quiz_radio_op3);
        op4=findViewById(R.id.quiz_radio_op4);

        quesNo.setText("Question "+(q+1));
        Statement.setText(questions(q,0));
        op1.setText(questions(q,1));
        op2.setText(questions(q,2));
        op3.setText(questions(q,3));
        op4.setText(questions(q,4));

    }
    public String questions(int a, int b)
    {
        str[0][0]="What is the meaning of Pakistan?";
        str[0][1]="Muslim Land ";
        str[0][2]="Land of five rivers ";
        str[0][3]="Desert ";
        str[0][4]="Holy Land ";

        str[1][0]="Who is the first Governor General of Pakistan?";
        str[1][1]="Mohammad Ali Jinnah";
        str[1][2]="Liaquat Ali Khan";
        str[1][3]="Ayub Khan";
        str[1][4]="Iskander Mirza ";

        str[2][0]="What was the major event of 1971?";
        str[2][1]="Bangladesh broke away from Pakistan";
        str[2][2]="Explosion of nuclear bomb";
        str[2][3]="Tashkent Agreement";
        str[2][4]="Nawaz Sharif became Prime Minister";

        str[3][0]="When Musharraf overthrew the government of Nawaz Sharif what designation did he take?";
        str[3][1]="Dictator";
        str[3][2]="Prime Minister";
        str[3][3]="Chief Executive";
        str[3][4]="President";

        str[4][0]="In which year did Pakistan win the Cricket World Cup?";
        str[4][1]="1975";
        str[4][2]="1985";
        str[4][3]="1992";
        str[4][4]="1995";

        return str[a][b];

    }

}

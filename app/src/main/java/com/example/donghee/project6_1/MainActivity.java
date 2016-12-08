package com.example.donghee.project6_1;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    RadioButton rd1, rd2;
    CalendarView cal;
    TimePicker timeP;
    TextView tview;
    Chronometer chro;
    int y,m,d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);      // 예약시작 버튼
        btn2 = (Button) findViewById(R.id.button3);
        rd1 = (RadioButton) findViewById(R.id.radioButton1);
        rd2 = (RadioButton) findViewById(R.id.radioButton2);
        cal = (CalendarView) findViewById(R.id.calendarView11);
        timeP = (TimePicker) findViewById(R.id.timePicker3);
        tview = (TextView) findViewById(R.id.textView1);
        chro = (Chronometer) findViewById(R.id.chronometer);

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                y = year;
                m = month +1;
                d = dayOfMonth;
            }
        });


        timeP.setVisibility(View.INVISIBLE);
        cal.setVisibility(View.INVISIBLE);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chro.setBase(SystemClock.elapsedRealtime());
                chro.start();
                chro.setTextColor(Color.RED);   // 텍스트를 레드로 바꿈

            }
        });

        rd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setVisibility(View.VISIBLE);
                timeP.setVisibility(View.INVISIBLE);
            }
        });

        rd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setVisibility(View.INVISIBLE);
                timeP.setVisibility(View.VISIBLE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chro.stop();
                chro.setTextColor(Color.BLUE);

                tview.setText(y+"년 "+m+"월 "+d+"일 "+
                        (Integer.toString(timeP.getCurrentHour()))+"시 "+(Integer.toString(timeP.getCurrentMinute()))+"분 예약됨");
            }
        });
    }
}

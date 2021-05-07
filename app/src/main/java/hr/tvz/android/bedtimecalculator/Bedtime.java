package hr.tvz.android.bedtimecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Bedtime extends AppCompatActivity {

    int hours;
    int minutes;
    TextView time1;
    TextView time2;
    TextView time3;
    TextView time4;
    TextView time5;
    TextView time6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedtime);

        Intent intent = getIntent();
        hours = intent.getExtras().getInt("hours");
        minutes = intent.getExtras().getInt("minutes");

        time1 = findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);
        time3 = findViewById(R.id.time3);
        time4 = findViewById(R.id.time4);
        time5 = findViewById(R.id.time5);
        time6 = findViewById(R.id.time6);
        bedtime(hours, minutes);

        Button alarm = findViewById(R.id.setAlarm);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                startActivity(alarmIntent);
            }
        });
    }

    private void bedtime(int hours, int minutes) {
        LocalTime providedValue = LocalTime.of(hours, minutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "HH:mm" );
        time1.setText(formatter.format(providedValue.minusHours(9)));
        time2.setText(formatter.format(providedValue.minusHours(7).minusMinutes(30)));
        time3.setText(formatter.format(providedValue.minusHours(6)));
        time4.setText(formatter.format(providedValue.minusHours(4).minusMinutes(30)));
        time5.setText(formatter.format(providedValue.minusHours(3)));
        time6.setText(formatter.format(providedValue.minusHours(1).minusMinutes(30)));
    }
}
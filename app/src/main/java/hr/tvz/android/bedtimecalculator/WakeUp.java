package hr.tvz.android.bedtimecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WakeUp extends AppCompatActivity {

    TextView time1;
    TextView time2;
    TextView time3;
    TextView time4;
    TextView time5;
    TextView time6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake_up);

        time1 = findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);
        time3 = findViewById(R.id.time3);
        time4 = findViewById(R.id.time4);
        time5 = findViewById(R.id.time5);
        time6 = findViewById(R.id.time6);

        wakeup();

        Button alarm = findViewById(R.id.setAlarm2);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                startActivity(alarmIntent);
            }
        });
    }

    private void wakeup() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "HH:mm" );
        time1.setText(formatter.format(now.plusHours(9)));
        time2.setText(formatter.format(now.plusHours(7).plusMinutes(30)));
        time3.setText(formatter.format(now.plusHours(6)));
        time4.setText(formatter.format(now.plusHours(4).plusMinutes(30)));
        time5.setText(formatter.format(now.plusHours(3)));
        time6.setText(formatter.format(now.plusHours(1).plusMinutes(30)));
    }
}
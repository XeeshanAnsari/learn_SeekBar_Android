package com.example.xesshan.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static SeekBar seek_bar;
    private static TextView text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar();
    }
    public void seekBar(){
        seek_bar=(SeekBar)findViewById(R.id.seekBar);
        text_view=(TextView)findViewById(R.id.textView);
        text_view.setText("Covered"+seek_bar.getProgress()+"/"+seek_bar.getMax());
        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                   int progress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value=progress;
                        text_view.setText("Covered"+progress+"/"+seek_bar.getMax());
                        Toast.makeText(MainActivity.this,"Seekbar is progress",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar){
                        Toast.makeText(MainActivity.this,"Seekbar is StartTracking",Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_view.setText("Covered"+progress_value+"/"+seek_bar.getMax());
                        Toast.makeText(MainActivity.this,"Seekbar is StopTracking",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}

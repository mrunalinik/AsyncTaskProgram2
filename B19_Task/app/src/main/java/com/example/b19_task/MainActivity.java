package com.example.b19_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.b19_task.interfaces.DataCallback;
import com.example.b19_task.tasks.MyTask;

public class MainActivity extends AppCompatActivity {

    private Button downloadBtn;
    private TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Load the UI
        setContentView(R.layout.activity_main);

        downloadBtn = (Button)findViewById(R.id.downloadBtn);
        resultTv = (TextView)findViewById(R.id.resultTv);


        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start the task

                MyTask myTask = new MyTask(dataCallback);
                myTask.execute();
            }
        });
    }


    DataCallback dataCallback = new DataCallback() {
        @Override
        public void getServerResult(String data) {
            resultTv.setText(data);
        }
    };

}

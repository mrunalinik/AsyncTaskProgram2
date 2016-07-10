package com.example.b19_task.tasks;

import android.os.AsyncTask;

import com.example.b19_task.interfaces.DataCallback;

/**
 * Created by chethan on 11/17/2015.
 */
public class MyTask extends AsyncTask<Void, Void, String>{

    private DataCallback dataCallback;


    public MyTask(DataCallback dataCallback){
        this.dataCallback = dataCallback;
    }

    //Runs on the non ui thread
    @Override
    protected String doInBackground(Void... params) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String message = "This message is from the server";


        return message;
    }


    //Runs on the ui thread
    @Override
    protected void onPostExecute(String data) {
        dataCallback.getServerResult(data);
    }
}

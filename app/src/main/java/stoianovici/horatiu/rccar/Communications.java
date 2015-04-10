package stoianovici.horatiu.rccar;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by horatiu_stoianovici on 4/10/2015.
 */
public class Communications {
    volatile Socket s;
    DataOutputStream outputStream;
    BufferedReader bufferedReader;
    int success = -1;

    public Communications(){
            new AsyncTask<Void, Void, Void>(){

                @Override
                protected Void doInBackground(Void... params) {
                    try {
                        s = new Socket("192.168.1.80", 6005);
                        outputStream = new DataOutputStream(s.getOutputStream());
                        bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        success = 1;
                    }
                    catch(Exception e){
                        Log.e("error", e.getLocalizedMessage());
                        success = 0;
                    }

                    return null;
                }
            }.execute();
    }

    private void sendMessage(String message){
        while(success == -1);

        try {
            if(success == 0){
                throw new Error("No connection!");
            }
            outputStream.writeBytes(message);
        } catch (Exception e) {
            Log.e("error", e.getLocalizedMessage());
        }
    }

    public void startLeft(){
        sendMessage("LD");
    }

    public void stopLeft(){
        sendMessage("LU");
    }

    public void startRight(){
        sendMessage("RD");
    }

    public void stopRight(){
        sendMessage("RU");
    }

    public void startForward(){
        sendMessage("FD");
    }

    public void stopForward(){
        sendMessage("FU");
    }

    public void startBackward(){
        sendMessage("BD");
    }

    public void stopBackward(){
        sendMessage("BU");
    }

}

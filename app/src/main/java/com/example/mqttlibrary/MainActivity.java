package com.example.mqttlibrary;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mqttlibrary2.MqttHelper;
import com.example.mqttlibrary2.OnMessageArrived;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {


    //serverUri="clientID://server:port"

    final String serverUri = "tcp://iot.eclipse.org:1883";

    // clientId="unique ID"
    final String clientId = "ExampleAndroidClient";

    //subscriptionTopic="Topic to subscribe
    final String subscriptionTopic = "sensor/temp";


    final String username = "orshqvfh";

    final String password = "z83EyRPZbZJC";

    private TextView txtMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage=findViewById(R.id.txtMessage);

        startMqtt();

    }

    private void startMqtt(){

        // initilize mqtt helper.
        MqttHelper mqttHelper=new MqttHelper(getApplicationContext(),serverUri,clientId,subscriptionTopic,username,password , new OnMessageArrived() {
            @Override
            public void onMessage(String msg) {

                txtMessage.setText(msg);
            }
        });
    }
}

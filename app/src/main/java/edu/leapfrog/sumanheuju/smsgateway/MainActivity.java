package edu.leapfrog.sumanheuju.smsgateway;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    Button sendBtn;
    EditText txtphoneNo;
    EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button) findViewById(R.id.btnSendSMS);
        txtphoneNo = (EditText) findViewById(R.id.editText);
        txtMessage = (EditText) findViewById(R.id.editText2);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }

    protected void sendSMSMessage() {

        String phoneNo = txtphoneNo.getText().toString();
        String message = txtMessage.getText().toString();

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();

//        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
//// Invokes only SMS/MMS clients
//        smsIntent.setType("vnd.android-dir/mms-sms");
//// Specify the Phone Number
//        smsIntent.putExtra("address", phoneNo);
//// Specify the Message
//        smsIntent.putExtra("sms_body", message);
//
//// Shoot!
//        startActivity(smsIntent);
    }

}

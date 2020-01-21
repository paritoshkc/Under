package ie.tcd.cs7cs3.under;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ie.tcd.cs7cs3.wifiP2P.WifiMainActivity;

public class UnderMainActivity extends AppCompatActivity {
    Button btnWifiP2p, btnUserLocation, btnGroupManager, btnDataStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_under_activity);
        init();
        //exqListener();

    }


    private void init() {
        btnWifiP2p=(Button) findViewById(R.id.wifiP2p);

        btnWifiP2p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WifiMainActivity.class);
                view.getContext().startActivity(intent);}
        });


//        btnOnOff=(Button) findViewById(R.id.onOff);
//        btnOnOff=(Button) findViewById(R.id.onOff);
//        btnOnOff=(Button) findViewById(R.id.onOff);




//        btnDiscover=(Button) findViewById(R.id.discover);
//        btnSend=(Button) findViewById(R.id.sendButton);
//        listView=(ListView) findViewById(R.id.peerListView);
//        read_msg_box=(TextView) findViewById(R.id.readMsg);
//        WriteMsg=(EditText) findViewById(R.id.writeMsg);
//        connectionStatus = (TextView) findViewById(R.id.connectionStatus);
//
//        wifiManager= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//        mManager= (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
//        mChannel=mManager.initialize(this, getMainLooper(),null);
//
//        mReceiver=new WifiDirectBroadcastReceiver(mManager, mChannel, this);
//
//        mIntentFilter=new IntentFilter();
//        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
//        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
//        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
//        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
    }
}

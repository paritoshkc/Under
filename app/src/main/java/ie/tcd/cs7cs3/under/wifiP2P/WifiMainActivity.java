package ie.tcd.cs7cs3.under.wifiP2P;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ie.tcd.cs7cs3.under.R;

public class WifiMainActivity extends AppCompatActivity {

    Button btnOnOff, btnDiscover, btnSend;
    ListView listView;
    public TextView read_msg_box, connectionStatus;
    EditText WriteMsg;

    WifiManager wifiManager;
    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;

    BroadcastReceiver mReceiver;
    IntentFilter mIntentFilter;

    List<WifiP2pDevice> peers=new ArrayList<WifiP2pDevice>();
    String[] deviceNameArray;
    WifiP2pDevice[] deviceArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_wifip2p_activity);
        initialWork();
        exqListener();
    }

    @SuppressWarnings({"MissingPermission"})
    private void exqListener() {
        btnOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wifiManager.isWifiEnabled()){
                    Log.d("#911","wifi on");
                    wifiManager.setWifiEnabled(false);
                    btnOnOff.setText("ON");
                } else {
                    Log.d("#911","wifi oFF");
                    wifiManager.setWifiEnabled(true);
                    btnOnOff.setText("OFF");
                }
            }
        });

        btnDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {
                    @Override
                    public void onSuccess() {
                        connectionStatus.setText("Discovery Started");
                    }

                    @Override
                    public void onFailure(int reason) {
                        connectionStatus.setText("Discovery Starting Failed");
                    }
                });
            }
        });

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                final WifiP2pDevice device=deviceArray[i];
                WifiP2pConfig config=new WifiP2pConfig();
                config.deviceAddress=device.deviceAddress;

                mManager.connect(mChannel, config, new WifiP2pManager.ActionListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplicationContext(), "Connected to"+device.deviceName, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int reason) {
                        Toast.makeText(getApplicationContext(), "Not Connected to", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initialWork() {
        btnOnOff=(Button) findViewById(R.id.onOff);
        btnDiscover=(Button) findViewById(R.id.discover);
        btnSend=(Button) findViewById(R.id.sendButton);
        listView=(ListView) findViewById(R.id.peerListView);
        read_msg_box=(TextView) findViewById(R.id.readMsg);
        WriteMsg=(EditText) findViewById(R.id.writeMsg);
        connectionStatus = (TextView) findViewById(R.id.connectionStatus);

        wifiManager= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        mManager= (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel=mManager.initialize(this, getMainLooper(),null);

        mReceiver=new WifiDirectBroadcastReceiver(mManager, mChannel, this);

        mIntentFilter=new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
    }

    public void AddPeersAvailable(WifiP2pDeviceList peerList) {

        if(!peerList.getDeviceList().equals(peers)){
            //peers.clear();
            peers.addAll(peerList.getDeviceList());

            deviceNameArray=new String[peerList.getDeviceList().size()];
            deviceArray=new WifiP2pDevice[ peerList.getDeviceList().size()];
            int index=0;

            for(WifiP2pDevice device : peerList.getDeviceList()){
                deviceNameArray[index]=device.deviceName;
                deviceArray[index]=device;
                index++;
            }

            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,deviceNameArray);
            listView.setAdapter(adapter);
        }

        if(peers.size() == 0){
            Toast.makeText(getApplicationContext(), "No device Found", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public WifiP2pManager.PeerListListener peerListListener=new WifiP2pManager.PeerListListener() {
        @Override
        public void onPeersAvailable(WifiP2pDeviceList peerList) {
            if(!peerList.getDeviceList().equals(peers)){
                peers.clear();
                peers.addAll(peerList.getDeviceList());

                deviceNameArray=new String[peerList.getDeviceList().size()];
                deviceArray=new WifiP2pDevice[ peerList.getDeviceList().size()];
                int index=0;

                for(WifiP2pDevice device : peerList.getDeviceList()){
                    deviceNameArray[index]=device.deviceName;
                    deviceArray[index]=device;
                    index++;
                }

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,deviceNameArray);
                listView.setAdapter(adapter);
            }

            if(peers.size() == 0){
                Toast.makeText(getApplicationContext(), "No device Found", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    };



    public WifiP2pManager.ConnectionInfoListener connectionInfoListener=new WifiP2pManager.ConnectionInfoListener() {
        @Override
        public void onConnectionInfoAvailable(WifiP2pInfo wifiP2pinfo) {

            final InetAddress groupOwnerAddress= wifiP2pinfo.groupOwnerAddress;

            if(wifiP2pinfo.groupFormed && wifiP2pinfo.isGroupOwner){
                connectionStatus.setText("Host");
            } else if(wifiP2pinfo.groupFormed){
                connectionStatus.setText("Client");
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    //inner Server Class
    public class ServerClass extends Thread{
         Socket socket;
         ServerSocket serverSocket;

        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(8888);
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package ie.tcd.cs7cs3.under;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ie.tcd.cs7cs3.under.GroupManager.MainActivity;
import ie.tcd.cs7cs3.under.locationmanager.Navigation;
import ie.tcd.cs7cs3.under.storage.ListUsersActivity;
import ie.tcd.cs7cs3.under.wifiP2P.WifiMainActivity;

public class UnderMainActivity extends AppCompatActivity {
    Button btnWifiP2p, btnUserLocation, btnGroupManager, btnDataStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_under_activity);
        init();
    }

    private void init() {
        btnWifiP2p=(Button) findViewById(R.id.wifiP2p);

        btnWifiP2p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WifiMainActivity.class);
                view.getContext().startActivity(intent);}
        });

        btnUserLocation=(Button) findViewById(R.id.userLocation);

        btnUserLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Navigation.class);
                view.getContext().startActivity(intent);}
        });

        btnDataStorage=(Button) findViewById(R.id.dataStorage);

        btnDataStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListUsersActivity.class);
                view.getContext().startActivity(intent);}
        });

        btnGroupManager = (Button) findViewById(R.id.groupManager );

        btnGroupManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);}
        });
    }
}

package ie.tcd.cs7cs3.under.GroupManager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ie.tcd.cs7cs3.under.R;

public class MainActivity extends AppCompatActivity {
    Button createGroupButton;
    Button joinGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        exqListener();

    }
    private void init() {
        createGroupButton = (Button) findViewById(R.id.CreateGroup);
        joinGroupButton = (Button) findViewById(R.id.JoinGroup);
    }

    private void exqListener() {
        Stubs stubs = new Stubs();

        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stubs.createExampleGroup();
                Log.d("#911", "Create Group");
                createGroupButton.setText("Group created successfully.");

                TextView stringTextView = (TextView) findViewById(R.id.textView1);
                stringTextView.setText("Group ID: " + GroupManager.findSimilarDestinationGroups(50,50)  );
            }
        });

        joinGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stubs.createExampleGroup();
                Log.d("#911", "Join Group");
                joinGroupButton.setText("Group joined successfully.");

                TextView stringTextView = (TextView) findViewById(R.id.textView2);
                stringTextView.setText("Users in that Group " + GroupManager.findSimilarDestinationGroups(50,50).get(0).getUsersOfGroup().get(0) + "<br />" + GroupManager.findSimilarDestinationGroups(50,50).get(0).getUsersOfGroup().get(1)  );

            }
        });
    }
}
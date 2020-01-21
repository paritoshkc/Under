//package ie.tcd.cs7cs3.under.locationmanager;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import ie.tcd.cs7cs3.under.R;
//import ie.tcd.cs7cs3.under.locationmanager.Navigation;
//import ie.tcd.cs7cs3.under.locationmanager.test;
//
//public class LocationManagerMainActivity extends AppCompatActivity
//{
//    Button locationManagerButton, testButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        locationManagerButton = (Button) findViewById(R.id.locationManagerButton);
//        testButton = (Button) findViewById(R.id.testButton);
//
//        locationManagerButton.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
////                Toast.makeText(getApplicationContext(), "Location Manager Button", Toast.LENGTH_LONG).show();//display the text of button1
//                Intent navigationActivity = new Intent(getApplicationContext(), Navigation.class);
//                startActivity(navigationActivity);
//            }
//        });
////        testButton.setOnClickListener(new View.OnClickListener()
////        {
////
////            @Override
////            public void onClick(View v)
////            {
////                Intent testActivity = new Intent(getApplicationContext(), test.class);
////                startActivity(testActivity);
////            }
////        });
//    }
//
//}

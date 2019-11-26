package ie.tcd.cs7cs3.storage;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ie.tcd.cs7cs3.under.R;
import java.util.UUID;

public class AddUserActivity extends AppCompatActivity {
  private UserEntityDAO users;
  private UserRatingEntityDAO ratings;

  private static final String TAG = AddUserActivity.class.getName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AppDatabase appDatabase = AppDatabase.getAppDatabase(getApplicationContext());
    this.users = appDatabase.getUserEntityDao();
    this.ratings = appDatabase.getUserRatingEntityDao();

    setContentView(R.layout.activity_add_user);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    Log.i(TAG, "all users: " + users.all());

    final Button submitButton = findViewById(R.id.submit_button);
    submitButton.setOnClickListener(v -> {
      final EditText nameEdit = findViewById(R.id.edit_person_name);
      final EditText ageEdit = findViewById(R.id.edit_age);
      final EditText genderEdit = findViewById(R.id.edit_gender);
      final EditText addressEdit = findViewById(R.id.edit_address);

      final String name = nameEdit.getText().toString();
      final int age = Integer.valueOf(ageEdit.getText().toString()); // XXX
      final String gender = genderEdit.getText().toString();
      final String address = addressEdit.getText().toString();
      final double randomLat = Math.random() * 180;
      final double randomLng = Math.random() * 90;

      final String uuid = UUID.randomUUID().toString();
      final UserEntity ue = new UserEntity(uuid, false, name, age, gender, address, randomLat, randomLng);
      this.users.insert(ue);

      Toast.makeText(getApplicationContext(), "Created user: " + ue.toString(), Toast.LENGTH_SHORT).show();
      finish();
    });
  }

}

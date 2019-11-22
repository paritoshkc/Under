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
    AppDatabase appDatabase = AppDatabase.getInMemoryAppDatabase(getApplicationContext());
    this.users = appDatabase.getUserEntityDao();
    this.ratings = appDatabase.getUserRatingEntityDao();

    seedData();

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
    });
  }

  void seedData() {
    this.users.insert(new UserEntity(UUID.randomUUID().toString(), true, "root", 9999, "undefined", "localhost", 0.0, 0.0));
    this.users.insert(new UserEntity(UUID.randomUUID().toString(), false, "John", 23, "male", "123 Main Street", Math.random() * 180, Math.random() * 90));
    this.users.insert(new UserEntity(UUID.randomUUID().toString(), false, "Mary", 24, "female", "234 Old Lane", Math.random() * 180, Math.random() * 90));
  }

}

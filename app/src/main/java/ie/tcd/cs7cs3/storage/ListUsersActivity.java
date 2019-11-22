package ie.tcd.cs7cs3.storage;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import ie.tcd.cs7cs3.under.R;
import java.util.List;
import java.util.UUID;

public class ListUsersActivity extends AppCompatActivity {
  private UserEntityDAO users;
  private UserRatingEntityDAO ratings;

  private static final String TAG = AddUserActivity.class.getName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_users);
    Toolbar toolbar = findViewById(R.id.toolbar);

    AppDatabase appDatabase = AppDatabase.getAppDatabase(getApplicationContext());
    this.users = appDatabase.getUserEntityDao();
    this.ratings = appDatabase.getUserRatingEntityDao();

    setSupportActionBar(toolbar);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Add", null).show());

    seedData();
    dumpAllUsers();
  }

  void seedData() {
    try {
      this.users.insert(new UserEntity("sample UUID 1", true, "root", 9999, "undefined", "localhost", 0.0, 0.0));
      this.users.insert(new UserEntity("sample UUID 2", false, "John", 23, "male", "123 Main Street", Math.random() * 180, Math.random() * 90));
    } catch (final Exception e) {
      Log.w(TAG, e.getMessage());
    }
  }


  void dumpAllUsers() {
    TextView dump = findViewById(R.id.dump);
    final StringBuilder sb = new StringBuilder();
    for (final UserEntity u: users.all()) {
      sb.append("UUID: ");
      sb.append(u.getUuid());
      sb.append("\n");
      sb.append("Name: ");
      sb.append(u.getName());
      sb.append("\n");
      sb.append("Age: ");
      sb.append(u.getAge());
      sb.append("\n");
      sb.append("Gender: ");
      sb.append(u.getGender());
      sb.append("\n");
      sb.append("Address: ");
      sb.append(u.getAddress());
      sb.append("\n");
      sb.append("Address Co-ordinates: ");
      sb.append("(");
      sb.append(u.getAddressLat());
      sb.append(",");
      sb.append(u.getAddressLng());
      sb.append(")\n");
    }
    dump.setText(sb.toString());
  }
}

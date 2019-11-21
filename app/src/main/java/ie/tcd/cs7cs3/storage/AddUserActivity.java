package ie.tcd.cs7cs3.storage;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import ie.tcd.cs7cs3.under.R;

public class AddUserActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_user);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    final EditText nameEditText = findViewById(R.id.edit_person_name);
    nameEditText.setOnEditorActionListener((v, actionId, event) -> {
      if (actionId != EditorInfo.IME_ACTION_DONE) {
        return false;
      }
      return true;
    });
  }

}

package science.aperture.tts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {
    public static String EXTRA = "GELUD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        final EditText name = findViewById(R.id.editText);
        findViewById(R.id.confirm_add_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ContactListFragment.class);
                intent.putExtra(EXTRA, name.getText().toString());
                setResult(ContactListFragment.RESULT_CODE, intent);
                finish();
            }
        });
    }
}

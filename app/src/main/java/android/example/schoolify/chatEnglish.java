package android.example.schoolify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class chatEnglish extends AppCompatActivity {
    ListView listView;
    List list;

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_english);

        listView = findViewById(R.id.list_of_messages);

        list = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setSelectedItemId(R.id.chat);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    if (item.getItemId() == R.id.dashboard) {
                        startActivity(new Intent(getApplicationContext(), dashboard_main.class));
                        overridePendingTransition(0, 0);
                        return true;
                    }
                    return false;
                });


        FloatingActionButton fab =
                findViewById(R.id.fab);

        fab.setOnClickListener(view -> {
            EditText input = findViewById(R.id.input);
            String value = input.getText().toString();

            list.add(value);
            listView.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        });

    }


}
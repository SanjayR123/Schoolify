package android.example.schoolify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button choose_school;
    String mSpnValue;
    Spinner school_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choose_school = findViewById(R.id.continue_button);

        choose_school.setOnClickListener(view -> openLoginActivity());

        school_spinner = findViewById(R.id.school_spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.schools));
            myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            school_spinner.setAdapter(myAdapter);

        school_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //stuff here to handle item selection

                mSpnValue=school_spinner.getSelectedItem().toString();

                Log.d("Spinner", mSpnValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }



    public void openLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        Log.d("Spinner", "Intent is " + mSpnValue);
        intent.putExtra("school_name", mSpnValue);
        startActivity(intent);
    }
}
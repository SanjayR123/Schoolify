package android.example.schoolify;

import android.content.Intent;
import android.example.schoolify.R;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    TextView school_name_text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //get the current intent
        Intent intent = getIntent();

        //get the attached extras from the intent
//we should use the same key as we used to attach the data.
        String school_name = intent.getStringExtra("school_name");

        school_name_text = findViewById(R.id.school_name_text);
        school_name_text.setText(school_name);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(view -> openDashBoardActivity());


    }
    public void openDashBoardActivity(){
        Intent intent = new Intent(this, dashboard_main.class);
        startActivity(intent);
    }

}
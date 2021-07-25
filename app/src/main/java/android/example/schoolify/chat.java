package android.example.schoolify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import javax.security.auth.Subject;

public class chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

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


        ListView mListview = findViewById(R.id.listView);
        Subjects Chemistry = new Subjects("Chemistry");
        Subjects Physics = new Subjects("Physics");
        Subjects English = new Subjects("English");
        Subjects History = new Subjects("History");
        Subjects Algorithmics = new Subjects("Algorithmics");
        Subjects Drama = new Subjects("Drama");
        Subjects Careers = new Subjects("Careers");
        Subjects Music = new Subjects("Music");
        Subjects Welfare = new Subjects("Welfare");

        ArrayList<Subjects> subjectList = new ArrayList<>();
        subjectList.add(Chemistry);
        subjectList.add(Physics);
        subjectList.add(English);
        subjectList.add(History);
        subjectList.add(Algorithmics);
        subjectList.add(Drama);
        subjectList.add(Careers);
        subjectList.add(Music);
        subjectList.add(Welfare);

        SubjectListAdapter adapter = new SubjectListAdapter(this, R.layout.adapter_view_layout, subjectList);
        mListview.setAdapter(adapter);

        mListview.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(this, chatEnglish.class);
            startActivity(intent);
        });
    }

}
package android.example.schoolify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class dashboard_main extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String,List<String>> listItem;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_main);

        expandableListView = findViewById(R.id.expandable_listview);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this, listGroup, listItem);
        expandableListView.setAdapter(adapter);
        initListData();


        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.chat:
                            startActivity(new Intent(getApplicationContext(), chat.class));
                            overridePendingTransition(0,0);
                            return true;

                    }
                    return false;
                });
    }

    private void initListData(){
        listGroup.add(getString(R.string.TodayClasses));
        listGroup.add(getString(R.string.MessageSchool));

        String[] array;
        List<String> list = new ArrayList<>();
        array = getResources().getStringArray(R.array.TodayClasses);
        for (String item : array){
            list.add(item);
        }

        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.schoolMessages);
        for (String item : array){
            list1.add(item);

        }

        listItem.put(listGroup.get(0), list);
        listItem.put(listGroup.get(1), list1);
        adapter.notifyDataSetChanged();
    }
}
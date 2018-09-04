package br.com.leandro.videogames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nintendo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nintendo);

        String [] nintendoArray = getResources().getStringArray(R.array.nintendo_games);

        final String [] nintendoDescArray = getResources().getStringArray(R.array.nintendo_desc);

        ArrayList<Item> list = new ArrayList<>();

        for (int i=0; i< 10; i++){

            String title = nintendoArray[i];
            String description = nintendoDescArray[i];

            Item item = new Item(title, description, R.drawable.nintendoicon);

            list.add(item);
        }


        ItemAdapter adapter = new ItemAdapter(this,list,R.color.nintendo_categoria);

        ListView listView = findViewById(R.id.rooNintendo);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String desc = nintendoDescArray[position];
                Toast.makeText(Nintendo.this,desc,Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);

    }
}

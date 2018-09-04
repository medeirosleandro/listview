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

public class Silvio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silvio);

        String[] silvioArray = getResources().getStringArray(R.array.silvio_games);
        final String [] silvioDescArray = getResources().getStringArray(R.array.silvio_desc);

        ArrayList<Item> list = new ArrayList<>();

        for (int i=0; i< 10; i++){

            String title = silvioArray[i];
            String description = silvioDescArray[i];

            Item item = new Item(title, description, R.drawable.silvioicon);

            list.add(item);
        }


        ItemAdapter adapter = new ItemAdapter(this,list,R.color.silvio_categoria);

        ListView listView = findViewById(R.id.rootSilvio);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String desc = silvioDescArray[position];
                Toast.makeText(Silvio.this,desc,Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);

    }
}

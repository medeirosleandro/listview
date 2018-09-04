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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sony extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sony);

        String [] sonyArray = getResources().getStringArray(R.array.sony_games);

        final String [] sonyDescArray = getResources().getStringArray(R.array.sony_desc);

        ArrayList<Item> list = new ArrayList<>();

        for (int i=0; i< 10; i++){

            String title = sonyArray[i];
            String description = sonyDescArray[i];

            Item item = new Item(title, description, R.drawable.sonyicon);

            list.add(item);
        }

        ItemAdapter adapter = new ItemAdapter(this,list,R.color.sony_categoria);

        ListView listView = findViewById(R.id.rootSony);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String desc = sonyDescArray[position];
                Toast.makeText(Sony.this,desc,Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);

    }
}

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

public class Microsoft extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microsoft);

        String [] microsoftArray = getResources().getStringArray(R.array.microsoft_games);

        final String [] microsoftDescArray = getResources().getStringArray(R.array.Microsoft_description);

        ArrayList<Item> list = new ArrayList<>();

        for (int i=0; i< 10; i++){

            String title = microsoftArray[i];
            String description = microsoftDescArray[i];

            Item item = new Item(title, description, R.drawable.microsofticon);

            list.add(item);
        }



        ItemAdapter adapter = new ItemAdapter(this,list,R.color.microsoft_categoria);

        ListView listView = findViewById(R.id.rootMicrosoft);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String desc = microsoftDescArray[position];
                Toast.makeText(Microsoft.this,desc,Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);

    }
}

package br.com.leandro.videogames;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    private int backgroundColor;


    public ItemAdapter(Context context, ArrayList<Item> list, int backgroundcolor){

        super(context,0, list);
        this.backgroundColor = backgroundcolor;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View itemView = convertView;

        if(itemView ==null){

            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Item item = getItem(position);

        TextView title = itemView.findViewById(R.id.title_id);
        title.setText(item.getTitle());

        TextView desc= itemView.findViewById(R.id.description_id);
        desc.setText(item.getDescription());

        ImageView icone = itemView.findViewById(R.id.image_id);
        icone.setImageResource(item.getImage());

        LinearLayout layoutTitles = itemView.findViewById(R.id.linearLayout_id);

        int cor = ContextCompat.getColor(getContext(), backgroundColor);
        layoutTitles.setBackgroundColor(cor);



        return itemView;
    }
}

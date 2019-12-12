package com.example.magazine;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListProjectHolder> {

    private ArrayList<Integer>imageid;
    private Context mcontext;

    ListAdapter(ArrayList imageid)
    {
        this.imageid = imageid;
    }



    @NonNull
    @Override
    public ListAdapter.ListProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listitem = inflater.inflate(R.layout.array,parent,false);
        ListAdapter.ListProjectHolder viewHolder = new ListAdapter.ListProjectHolder(listitem);

        return viewHolder;


    }






    @Override
    public void onBindViewHolder(@NonNull final ListProjectHolder holder, final int position) {
      holder.image.setImageResource (imageid.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(holder.itemView.getContext(),galery.class);
                intent.putExtra("mog",imageid.get(position));

                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageid.size();
    }

    class ListProjectHolder extends RecyclerView.ViewHolder{

       public ImageView image;
        public ListProjectHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);

        }
    }
}

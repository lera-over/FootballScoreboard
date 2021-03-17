package com.example.librarydb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private Cursor cursor;
    private ArrayList<Integer> IDs;

    MyAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
        Database mDBHelper = new Database(context);
        mDBHelper.updateDataBase();

        cursor.moveToFirst();
        IDs = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        if (cursor != null && !cursor.isAfterLast()) {
            fillData(viewHolder);
            IDs.add(Integer.valueOf(cursor.getString(0)));
            viewHolder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, InformationOfBook.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("key", IDs.get(position));
                    context.startActivity(intent);
                }
            });
            cursor.moveToNext();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.book);
        }
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    @SuppressLint("SetTextI18n")
    private void fillData(ViewHolder viewHolder) {
        viewHolder.title.setText(cursor.getString(0) + ". " + cursor.getString(1) + " " + cursor.getString(2) + ", " + cursor.getString(3) + ", " + cursor.getString(4) + " г." + '\n');
    }
}

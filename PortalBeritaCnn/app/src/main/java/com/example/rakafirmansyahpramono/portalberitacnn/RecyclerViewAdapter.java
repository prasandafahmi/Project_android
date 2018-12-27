package com.example.rakafirmansyahpramono.portalberitacnn;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<DataFilter> dataList;
    private Context context;

    RecyclerViewAdapter(ArrayList<DataFilter> dataList){
        this.dataList = dataList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Judul, Edisi, Penulis;
        private ImageButton Overflow;

        ViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            Judul = itemView.findViewById(R.id.Judul);
            Edisi = itemView.findViewById(R.id.Edisi);
            Penulis = itemView.findViewById(R.id.Penulis);
            Overflow = itemView.findViewById(R.id.overflow);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final String Judul = dataList.get(position).getJudul();
        final String Edisi = dataList.get(position).getEdisi();
        final String Penulis = dataList.get(position).getPenulis();
        holder.Judul.setText(Judul);
        holder.Edisi.setText(Edisi);
        holder.Penulis.setText(Penulis);

        holder.Overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.delete:
                                DBBerita getDatabase = new DBBerita(view.getContext());
                                SQLiteDatabase DeleteData = getDatabase.getWritableDatabase();
                                String selection = DBBerita.MyColumns.Judul + " LIKE ?";
                                String[] selectionArgs = {Judul};
                                DeleteData.delete(DBBerita.MyColumns.NamaTabel, selection, selectionArgs);

                                String position2 = String.valueOf(Judul.indexOf(Judul));
                                dataList.remove(position);
                                notifyItemRemoved(position);
                                if (position2 == null) {
                                    notifyItemRangeChanged(Integer.parseInt(position2), dataList.size());
                                }
                                break;

                            case R.id.update:
                                Intent dataForm = new Intent(view.getContext(), UpdateActivity.class);
                                dataForm.putExtra("SendJudul", Judul);
                                context.startActivity(dataForm);
                                ((Activity)context).finish();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    void setFilter(ArrayList<DataFilter> filterList){
        dataList = new ArrayList<>();
        dataList.addAll(filterList);
        notifyDataSetChanged();
    }

}
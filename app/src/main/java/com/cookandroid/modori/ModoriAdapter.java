package com.cookandroid.modori;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//리스트
public class ModoriAdapter extends BaseAdapter {
    ArrayList<Modori> modoriArrayList = new ArrayList<>();
    Context mContext;

    public ModoriAdapter(ArrayList<Modori> modoriArrayList, Context mContext) {
        this.modoriArrayList = modoriArrayList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return modoriArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return modoriArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.diary, parent,false);

        TextView tvTitle = itemView.findViewById(R.id.memo_title);
        TextView tvContents = itemView.findViewById(R.id.memo_contents);

        tvTitle.setText(modoriArrayList.get(position).title);
        tvContents.setText(modoriArrayList.get(position).contents);

        return itemView;
    }
}

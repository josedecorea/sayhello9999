package com.example.josedecorea.myapplication99;

/**
 * Created by jose de corea on 2017-02-05.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
    private ArrayList<ListViewItem> arraylist;
    int layout;

    // ListViewAdapter의 생성자
    public ListViewAdapter(Context context, int alayout, ArrayList<ListViewItem> aarSrc ) {
        mContext = context;
        layout = alayout;
        this.listViewItemList = aarSrc;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<ListViewItem>();
        this.arraylist.addAll(listViewItemList);
    }

    public class ViewHolder {
        ImageView iconImageView;
        TextView titleTextView;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            holder.iconImageView = (ImageView) view.findViewById(R.id.imageView1);
            holder.titleTextView = (TextView) view.findViewById(R.id.textView1);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.iconImageView.setImageResource(listViewItemList.get(position).getIcon());
        holder.titleTextView.setText(listViewItemList.get(position).getTitle());

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext, HelloActivity.class);
                intent.putExtra("nation_code",(listViewItemList.get(position).getNcode()));
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        listViewItemList.clear();
        if (charText.length() == 0) {
            listViewItemList.addAll(arraylist);
        }
        else
        {
            for (ListViewItem wp : arraylist)
            {
                if (wp.getTitle().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    listViewItemList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

}


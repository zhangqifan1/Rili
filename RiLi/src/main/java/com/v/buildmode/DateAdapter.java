package com.v.buildmode;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/12/5.
 */

public class DateAdapter extends BaseAdapter {
    private int[] days = new int[42];
    private Context context;
    private int year;
    private int month;
private TextView textView;
    private String s;

    public DateAdapter(Context context, int[][] days, int year, int month,TextView textView) {
        this.context = context;
        this.textView=textView;
        int dayNum = 0;
        for (int i = 0; i < days.length; i++) {
            for (int j = 0; j < days[i].length; j++) {
                this.days[dayNum] = days[i][j];
                dayNum++;
            }
        }
        this.year = year;
        this.month = month;
    }

    @Override
    public int getCount() {
        return days.length;
    }

    @Override
    public Object getItem(int i) {
        return days[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.date_item, null);
            viewHolder = new ViewHolder();
            viewHolder.date_item = (TextView) view.findViewById(R.id.date_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (i < 7 && days[i] > 20) {
            viewHolder.date_item.setTextColor(Color.rgb(204, 204, 204));//将上个月的和下个月的设置为灰色
        } else if (i > 20 && days[i] < 15) {
            viewHolder.date_item.setTextColor(Color.rgb(204, 204, 204));
        }
        if(textView!=null){
            s = textView.getText().toString();
        }else{
            s="2016年8月21日";
        }
        viewHolder.date_item.setText(days[i] + "");

        viewHolder.date_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+s+days[i], Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    class ViewHolder {
        TextView date_item;
    }
}
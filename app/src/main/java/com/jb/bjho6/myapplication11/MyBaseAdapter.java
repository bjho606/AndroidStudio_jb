package com.jb.bjho6.myapplication11;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bjho6 on 2017-07-03.
 */

public class MyBaseAdapter extends BaseAdapter {

    MainActivity activityContext;
    int iLayoutResID;
    ArrayList<String> arrBindedData;

    public MyBaseAdapter(MainActivity activityContext, int iLayoutResID, ArrayList<String> arrBindedData) {
        this.activityContext = activityContext;
        this.iLayoutResID = iLayoutResID;
        this.arrBindedData = arrBindedData;
    }

    @Override
    public int getCount() {
        return arrBindedData.size();
    }

    @Override
    public Object getItem(int position) {
        return arrBindedData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        해쉬코드를 재사용 가능하게 만드는 코드
        View inflatedView;
        inflatedView = convertView;
        if(inflatedView == null);{
            LayoutInflater layoutInflater = activityContext.getLayoutInflater();
            inflatedView = layoutInflater.inflate(R.layout.listview_item4, null);
        }

        TextView tv = (TextView) inflatedView;
        String strData = arrBindedData.get(position);
        tv.setText(strData);

        StringBuilder msg = new StringBuilder();
        msg.append("getView()함수가 호출됨. position : " + position + "\n");
        msg.append("\tinflatedView : " + inflatedView + "\n");
        msg.append("\tconvertdView : " + convertView + "\n");
        Log.d("TAG", msg.toString());

        return inflatedView;
    }
}

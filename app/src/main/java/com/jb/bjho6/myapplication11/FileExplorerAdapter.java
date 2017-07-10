package com.jb.bjho6.myapplication11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bjho6 on 2017-07-05.
 */

public class FileExplorerAdapter extends BaseAdapter {

    Main2Activity activityContext;
    int iLayoutResId;
    ArrayList<FileInfo> arrBindedData;

    public FileExplorerAdapter(Main2Activity activityContext, int iLayoutResId, ArrayList<FileInfo> arrBindedData) {
        this.activityContext = activityContext;
        this.iLayoutResId = iLayoutResId;
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
        LinearLayout inflatedView = (LinearLayout)convertView;
        ChildViewInfo childViewInfo = null;

        if(inflatedView == null){
            LayoutInflater layoutInflater = activityContext.getLayoutInflater();
            inflatedView = (LinearLayout)layoutInflater.inflate(iLayoutResId, null);

            ImageView iv = (ImageView)inflatedView.findViewById(R.id.item_image);
            TextView tvFileName = (TextView)inflatedView.findViewById(R.id.item_filename);
            TextView tvFileSize = (TextView)inflatedView.findViewById(R.id.item_filesize);

            childViewInfo = new ChildViewInfo();
            childViewInfo.iv = iv;
            childViewInfo.tvFileName = tvFileName;
            childViewInfo.tvFileSize = tvFileSize;
            inflatedView.setTag(childViewInfo);
        } else{
            childViewInfo = (ChildViewInfo)inflatedView.getTag();
        }

        FileInfo fileInfo = arrBindedData.get(position);
        childViewInfo.iv.setImageResource(fileInfo.iDrawableResId);
        childViewInfo.tvFileName.setText(fileInfo.strFileName);
        childViewInfo.tvFileSize.setText(fileInfo.lFileSize + "\tByte");

        return inflatedView;
    }

    public class ChildViewInfo{
        ImageView iv;
        TextView tvFileName;
        TextView tvFileSize;
    }

    public void add(FileInfo item){
        arrBindedData.add(item);
        notifyDataSetChanged();
    }

    public void delete(FileInfo item){
        arrBindedData.remove(item);
        notifyDataSetChanged();
    }

}

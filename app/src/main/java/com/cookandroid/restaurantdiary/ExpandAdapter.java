package com.cookandroid.restaurantdiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.Vector;

public class ExpandAdapter extends BaseExpandableListAdapter {
    private static final int RESTAURANT_LIST= R.layout.restaurant_list;
    private static final int DIARY_LIST = R.layout.diary_list;
    private Context context;
    private Vector<ParentData> data;
    private LayoutInflater inflater = null;

    public ExpandAdapter(Context context, Vector<ParentData> data){
        this.data = data;
        this.context = context;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(convertView == null){
            convertView = inflater.inflate(this.RESTAURANT_LIST, parent, false);
        }

        TextView restaurantName = (TextView)convertView.findViewById(R.id.textRestName);
        TextView address = (TextView)convertView.findViewById(R.id.textAddress);
        TextView tel = (TextView)convertView.findViewById(R.id.textTel);
        restaurantName.setText(data.get(groupPosition).getRestName());
        address.setText(data.get(groupPosition).getAddress());
        tel.setText(data.get(groupPosition).getTel());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(convertView == null){
            convertView = inflater.inflate(this.DIARY_LIST, parent, false);
        }

        TextView date = (TextView)convertView.findViewById(R.id.textDate);
        TextView menu = (TextView)convertView.findViewById(R.id.textMenu);
        TextView friend = (TextView)convertView.findViewById(R.id.textFriend);
        date.setText(data.get(groupPosition).child.get(childPosition).getDate());
        menu.setText(data.get(groupPosition).child.get(childPosition).getMenu());
        friend.setText(data.get(groupPosition).child.get(childPosition).getFriend());
        return convertView;
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return data.get(groupPosition).child.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return data.get(groupPosition).child.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return true;
    }

}

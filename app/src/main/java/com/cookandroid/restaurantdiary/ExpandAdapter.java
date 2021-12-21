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

    // 리스트 각각의 row에 view를 설정
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        // convertView가 비어있을 경우 xml파일을 inflate해줌
        if(convertView == null){
            convertView = inflater.inflate(this.RESTAURANT_LIST, parent, false);
        }

        // View들은 반드시 아이템 레이아웃을 inflate한 뒤에 작성할 것
        TextView restaurantName = (TextView)convertView.findViewById(R.id.textRestName);
        TextView address = (TextView)convertView.findViewById(R.id.textAddress);
        TextView tel = (TextView)convertView.findViewById(R.id.textTel);

        // 리스트 아이템의 내용 설정
        restaurantName.setText(data.get(groupPosition).getRestName());
        address.setText(data.get(groupPosition).getAddress());
        tel.setText(data.get(groupPosition).getTel());

        return convertView;
    }

    // 리스트 각각의 row에 view를 설정
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        // convertView가 비어있을 경우 xml파일을 inflate해줌
        if(convertView == null){
            convertView = inflater.inflate(this.DIARY_LIST, parent, false);
        }

        // View들은 반드시 아이템 레이아웃을 inflate한 뒤에 작성할 것
        TextView date = (TextView)convertView.findViewById(R.id.textDate);
        TextView menu = (TextView)convertView.findViewById(R.id.textMenu);
        TextView friend = (TextView)convertView.findViewById(R.id.textFriend);

        // 리스트 아이템의 내용 설정
        date.setText(data.get(groupPosition).child.get(childPosition).getDate());
        menu.setText(data.get(groupPosition).child.get(childPosition).getMenu());
        friend.setText(data.get(groupPosition).child.get(childPosition).getFriend());
        // 여기에 이미지뷰 추가해야함

        return convertView;
    }

    // 각 리스트의 크기 반환
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

    // 각 리스트의 아이템 반환
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

    // 각 리스트 아이템의 id 반환
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

    // 동일한 id가 항상 동일한 개체를 참조하는지 여부를 반환
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

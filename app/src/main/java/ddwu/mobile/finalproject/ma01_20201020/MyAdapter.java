package ddwu.mobile.finalproject.ma01_20201020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter  extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Post> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<Post> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return myDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return myDataList.get(i).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {

        final int position = pos;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, viewGroup, false);
        }


        TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tv_place =(TextView) convertView.findViewById(R.id.tv_place);
        TextView tv_date = (TextView)convertView.findViewById(R.id.tv_date);
        TextView tv_content =(TextView) convertView.findViewById(R.id.tv_content);

        tv_title.setText(myDataList.get(position).getTitle());
        tv_place.setText(myDataList.get(position).getPlace());
        tv_date.setText(myDataList.get(position).getDate());
        tv_content.setText(myDataList.get(position).getContent());


        return convertView;
    }
}

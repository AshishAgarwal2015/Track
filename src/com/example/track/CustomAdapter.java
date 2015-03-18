package com.example.track;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// Referenced classes of package com.example.track:
//            DataView

public class CustomAdapter extends ArrayAdapter
{
    static class DataHolder
    {

        TextView count;
        TextView name;
        TextView pack;

    }


    Context context;
    DataView data[];
    int layoutResourceId;

    public CustomAdapter(Context context1, int i, DataView adataview[])
    {
        super(context1, i, adataview);
        data = null;
        layoutResourceId = i;
        context = context1;
        data = adataview;
        Log.d("ashish", (new StringBuilder(String.valueOf(i))).toString());
        Log.d("ashish", adataview.toString());
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Log.d("ashish", "hello15");
        Log.d("ashish", "hello16");
        View view1 = ((Activity)context).getLayoutInflater().inflate(layoutResourceId, viewgroup, false);
        Log.d("ashish", "hello1");
        DataHolder dataholder = new DataHolder();
        dataholder.pack = (TextView)view1.findViewById(R.id.pack);
        dataholder.name = (TextView)view1.findViewById(R.id.text);
        dataholder.count = (TextView)view1.findViewById(R.id.count);
        DataView dataview = data[i];
        dataholder.pack.setText(dataview.getPackName());
        dataholder.name.setText(dataview.getIdentityName());
        dataholder.count.setText(dataview.getCount());
        Log.d("ashish", view1.toString());
        return view1;
    }
}

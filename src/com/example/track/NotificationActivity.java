package com.example.track;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.example.track:
//            NotificationService, CustomAdapter, DataView

public class NotificationActivity extends Fragment
{
	ArrayList<DataView> arraylist = new ArrayList<DataView>();
	private Context context;
	
	public NotificationActivity(Context context)
	{
		this.context = context;
		
	}
   
    private void setView()
    {
        Log.d("ashish", "Notiashish");
        arraylist.add(new DataView(getResources().getString(R.string.pack),getResources().getString(R.string.text),getResources().getString(R.string.count)));
	for(String i:  NotificationService.hashMap.keySet())
	{     
		HashMap<String,Integer> hashmap = NotificationService.hashMap.get(i);
        int sum = 0;
        for(String j : NotificationService.hashMap.get(i).keySet() )
        {  
        	arraylist.add(new DataView(i, j,""+NotificationService.hashMap.get(i).get(j) ));
          sum=sum+ NotificationService.hashMap.get(i).get(j);
        }

    	 arraylist.add(new DataView(i, "total",""+sum));
	}
            
//	CustomAdapter customadapter = new CustomAdapter(this, R.layout.single_item, arraylist.toArray(new DataView[arraylist.size()]));
//     ListView listview = (ListView)findViewById(R.id.listView);
//        
//        listview.setAdapter(customadapter);
    }
//
//    @Override
//    public void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
//    {
//        super.onCreate(bundle);
//        setContentView(R.layout.list_data);
//        setView();
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_data, container, false);
        ListView lv = (ListView) view.findViewById(R.id.listView);
        setView();
        CustomAdapter customadapter = new CustomAdapter(context, R.layout.single_item, arraylist.toArray(new DataView[arraylist.size()]));   
        lv.setAdapter(customadapter);             
        return view;
    }


}

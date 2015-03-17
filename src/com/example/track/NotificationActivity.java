package com.example.track;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.example.track:
//            NotificationService, CustomAdapter, DataView

public class NotificationActivity extends Activity
{

    private void setView()
    {
        ArrayList<DataView> arraylist = new ArrayList<DataView>();
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
            
	CustomAdapter customadapter = new CustomAdapter(this, R.layout.single_item, arraylist.toArray(new DataView[arraylist.size()]));
     ListView listview = (ListView)findViewById(R.id.listView);
        
        listview.setAdapter(customadapter);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.list_data);
        setView();
    }
}

package com.example.track;

import android.R.bool;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.example.track:
//            NotificationActivity

public class MainActivity extends ActionBarActivity
{
	static boolean first = true;

	public MainActivity()
	{
	}

	protected void onCreate(Bundle bundle)
	{
		Log.d("ashish", "hello");
		super.onCreate(bundle);
		setContentView(R.layout.activity_main);
		if (first)
		{
		startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
	  first = false;
		}
	}

	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem menuitem)
	{
		if (menuitem.getItemId() == R.id.action_settings)
		{
			return true;
		}
		else
		{
			return super.onOptionsItemSelected(menuitem);
		}
	}

	public void showNoti(View view)
	{
//		Log.d("ashish", "ashish5");
//		Intent intent = new Intent(this, NotificationActivity.class);
//		Log.d("ashish", "ashish5");
//		startActivity(intent);
//		Log.d("ashish", "ashish5");
//		 FragmentManager fm = getParent().getFragmentManager();
//	        FragmentTransaction ft = fm.beginTransaction();
//	        NotificationActivity f = new NotificationActivity(getApplicationContext());
//	        ft.replace(R.id.article_fragment, f);
//	        ft.commit();
		 FrameLayout framelayout = (FrameLayout)findViewById(R.id.mainframe); 
	     Log.d("ashish","ashish"+framelayout.getVisibility());   
	        NotificationActivity myf = new NotificationActivity(this);
	        FragmentTransaction transaction = getFragmentManager().beginTransaction();
	      //  transaction.add(R.id.mainframe, myf);
	        transaction.replace(R.id.mainframe, myf);
	        transaction.commit();
	       
	}
}

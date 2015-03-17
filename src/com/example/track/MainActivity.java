package com.example.track;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package com.example.track:
//            NotificationActivity

public class MainActivity extends ActionBarActivity
{

	public MainActivity()
	{
	}

	protected void onCreate(Bundle bundle)
	{
		Log.d("ashish", "hello");
		super.onCreate(bundle);
		setContentView(R.layout.activity_main);
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
		Log.d("ashish", "ashish5");
		Intent intent = new Intent(this, NotificationActivity.class);
		Log.d("ashish", "ashish5");
		startActivity(intent);
		Log.d("ashish", "ashish5");
	}
}

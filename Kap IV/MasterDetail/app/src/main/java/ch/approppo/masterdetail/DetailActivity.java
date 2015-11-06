package ch.approppo.masterdetail;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;

public class DetailActivity extends AppCompatActivity {
	
	private static final String LOG_TAG = MainActivity.LOG_BASE_TAG + ".DetailActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(LOG_TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		if (getResources().getBoolean(R.bool.twoPaneMode)) {
			finish();
		}
	}
}

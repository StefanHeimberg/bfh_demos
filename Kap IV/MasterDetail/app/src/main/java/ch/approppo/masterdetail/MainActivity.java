package ch.approppo.masterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MyListFragment.ListFragmentCallback {

	private static final String TAG_DETAIL_FRAGMENT = "DETAIL_FRAGMENT";

	public static final String TAG_ID = "tag_id";

	public static final String LOG_BASE_TAG = "MasterDetail";

	private static final String LOG_TAG = LOG_BASE_TAG + ".MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(LOG_TAG, "onCreate");
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main_single_pane);
//		if(getResources().getBoolean(R.bool.twoPaneMode)) {
//			setContentView(R.layout.activity_main_dual_pane);
//		}else {
//			setContentView(R.layout.activity_main_single_pane);
//		}
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onListItemSelected(int id) {
		Log.d(LOG_TAG, "Callback onListItemSelected with id " + id);

		if (getResources().getBoolean(R.bool.twoPaneMode)) {
			Log.d(LOG_TAG, "two pane mode, create new DetailFragment");
			DetailFragment detailFragment = new DetailFragment();
			Bundle args = new Bundle();
			args.putInt(TAG_ID, id);
			detailFragment.setArguments(args);
			getSupportFragmentManager().beginTransaction().replace(R.id.container, detailFragment, TAG_DETAIL_FRAGMENT).commit();
		}
		else {
			Log.d(LOG_TAG, "single pane mode, start DetailActivity");
			Intent intent = new Intent(this, DetailActivity.class);
			intent.putExtra(TAG_ID, id);
			startActivity(intent);
		}
	}
}

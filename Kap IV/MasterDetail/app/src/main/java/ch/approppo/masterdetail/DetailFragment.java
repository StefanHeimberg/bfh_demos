package ch.approppo.masterdetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

	private TextView textView;
	
	private static final String LOG_TAG = MainActivity.LOG_BASE_TAG+".DetailFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(LOG_TAG,"onCreateView");
		return inflater.inflate(R.layout.fragment_detail, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		Log.d(LOG_TAG,"onViewCreated");
		super.onViewCreated(view, savedInstanceState);
		textView = (TextView) view.findViewById(R.id.detailTextView);
		int id = 0;
		if (getArguments() != null && getArguments().containsKey(MainActivity.TAG_ID)) {
			id = getArguments().getInt(MainActivity.TAG_ID) +1;

		} else {
			id = getActivity().getIntent().getIntExtra(MainActivity.TAG_ID, -1) + 1;
		}
		textView.setText("This is a detail text for the item: " + id);
	}
}

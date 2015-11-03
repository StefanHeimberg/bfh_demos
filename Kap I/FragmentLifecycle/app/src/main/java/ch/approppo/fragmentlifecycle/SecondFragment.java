package ch.approppo.fragmentlifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Martin Neff @approppo GmbH on 01.11.15.
 */
public class SecondFragment extends Fragment {

	private static final String LOG_TAG = SecondFragment.class.getSimpleName();

	private String dummyString;

	public SecondFragment(){
//		setRetainInstance(true);
		Log.d(LOG_TAG, "SecondFragment constructor");
	}

	@Override public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
		super.onInflate(context, attrs, savedInstanceState);
		Log.d(LOG_TAG, "onInflate");
	}

	@Override public void onAttach(Context context) {
		super.onAttach(context);
		Log.d(LOG_TAG, "onAttach");
	}

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState == null) {
			dummyString = "ich bin ein dummy string";
			Log.d(LOG_TAG, "Dummy String created");
		}
		Log.d(LOG_TAG, "onCreate " + (savedInstanceState == null ? " no bundle" : " with saved bundle"));
	}

	@Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.d(LOG_TAG, "onCreateView");
		return inflater.inflate(R.layout.fragment_second, container, false);
	}

	@Override public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Log.d(LOG_TAG, "onViewCreated");
	}

	@Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(LOG_TAG, "onActivityCreated");
	}

	@Override public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
		super.onViewStateRestored(savedInstanceState);
		Log.d(LOG_TAG, "onViewStateRestored");
		Log.d(LOG_TAG, "Dummy String is " + (dummyString == null ? "null" : dummyString));
	}

	@Override public void onStart() {
		super.onStart();
		Log.d(LOG_TAG, "onStart");
	}

	@Override public void onResume() {
		super.onResume();
		Log.d(LOG_TAG, "onResume");
	}

	@Override public void onPause() {
		Log.d(LOG_TAG, "onPause");
		super.onPause();
	}

	@Override public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override public void onStop() {
		Log.d(LOG_TAG, "onStop");
		super.onStop();
	}

	@Override public void onDestroyView() {
		Log.d(LOG_TAG, "onDestroyView");
		super.onDestroyView();
	}

	@Override public void onDestroy() {
		Log.d(LOG_TAG, "onDestroy");
		super.onDestroy();
	}

	@Override public void onDetach() {
		Log.d(LOG_TAG, "onDetach");
		super.onDetach();
	}
}

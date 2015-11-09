package ch.approppo.masterdetail;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.concurrent.CopyOnWriteArrayList;

public class MyListFragment extends ListFragment {

	private ListFragmentCallback callback;

	private Integer activatedArticleId;

	private static final String BUNDLE_TAG_ARTICLE_ID = "bundle_tag_article_id";

	private static final String LOG_TAG = MainActivity.LOG_BASE_TAG + ".MyListFragment";

	public interface ListFragmentCallback {
		public void onListItemSelected(int id);
	}

	private String[] items = new String[] { "Item1" , "Item2" , "Item3" };

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			callback = (ListFragmentCallback) getActivity();
		}
		catch (ClassCastException e) {
			throw new ClassCastException(getActivity().toString() + " must implement ListFragmentCallback");
		}
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		Log.d(LOG_TAG, "onViewCreated");
		super.onViewCreated(view, savedInstanceState);
		getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, items));

		if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_TAG_ARTICLE_ID)) {
			Log.d(LOG_TAG, "savedInstanceState != null and the key of a selected item found");
			activatedArticleId = savedInstanceState.getInt(BUNDLE_TAG_ARTICLE_ID);

			setSelection(activatedArticleId);

			if (getResources().getBoolean(R.bool.twoPaneMode)) {
				callback.onListItemSelected(activatedArticleId);
			}
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Log.d(LOG_TAG, "User clicked on Item with id " + id);
		callback.onListItemSelected(position);
		activatedArticleId = position;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		Log.d(LOG_TAG, "onSavedInstanceState called");
		if (activatedArticleId != null) {
			outState.putInt(BUNDLE_TAG_ARTICLE_ID, activatedArticleId);
		}
		super.onSaveInstanceState(outState);
	}
}

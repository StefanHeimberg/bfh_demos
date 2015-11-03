package ch.approppo.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScrollViewActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scroll_view);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		populate((ViewGroup) findViewById(R.id.container), createSuperLongList());
	}

	private void populate(ViewGroup viewGroup,List<String> list){
		View v;
		for(String s : list){
			v = LayoutInflater.from(this).inflate(R.layout.item_layout,viewGroup, false);
			((TextView)v.findViewById(R.id.text)).setText(s);
			viewGroup.addView(v);
		}
	}

	public static  List<String> createSuperLongList() {
		List<String> superLongList = new ArrayList<>();
		for (int i = 0 ; i < 1000 ; i++) {
			superLongList.add("Item " + i);
		}
		return superLongList;
	}

}

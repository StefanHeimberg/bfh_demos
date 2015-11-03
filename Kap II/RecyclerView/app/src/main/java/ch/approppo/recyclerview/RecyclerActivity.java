package ch.approppo.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycler);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
		LinearLayoutManager lm  = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(lm);

		recyclerView.setAdapter(new MyAdapter(ScrollViewActivity.createSuperLongList()));

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "number of views: " + recyclerView.getChildCount(), Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});
	}

	private static class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

		private List<String> mData;

		public MyAdapter(List<String> mData){
			this.mData = mData;
		}

		@Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,false);
			return new MyViewHolder(v);
		}

		@Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
			((MyViewHolder)holder).textView.setText(mData.get(position));
		}

		@Override public int getItemCount() {
			return mData.size();
		}
	}

	private static class MyViewHolder extends RecyclerView.ViewHolder {

		TextView textView;

		public MyViewHolder(View itemView) {
			super(itemView);
			textView = (TextView)itemView.findViewById(R.id.text);
		}
	}

}

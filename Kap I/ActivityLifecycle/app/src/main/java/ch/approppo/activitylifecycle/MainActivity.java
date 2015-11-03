package ch.approppo.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private TextView textView;

	private static final String LOG_TAG = MainActivity.class.getSimpleName();

	private String dummyString;

	private static final String STRING_KEY = "key";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView = (TextView) findViewById(R.id.textview);
		textView.append("\n onCreate with " + (savedInstanceState == null ? "no bundle" : "saved bundle"));
		Log.d(LOG_TAG, "onCreate with " + (savedInstanceState == null ? "no bundle" : "saved bundle"));

		findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				textView.setText("");
			}
		});

		if (savedInstanceState == null) {
			dummyString = "Ich bin ein dummy String";
			Log.d(LOG_TAG, "Dummy String created");
		}
		else {
			dummyString = savedInstanceState.getString(STRING_KEY);
			Log.d(LOG_TAG, "Dummy String restored: " + dummyString);
		}
	}

//	@Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
//		super.onRestoreInstanceState(savedInstanceState);
//		textView.append("\n onRestoreInstanceState");
//		Log.d(LOG_TAG, "onRestoreInstanceState");
//		Log.d(LOG_TAG, "Dummy String in savedInstanceState: " + savedInstanceState.getString(STRING_KEY));
//	}

	@Override protected void onStart() {
		super.onStart();
		textView.append("\n onStart");
		Log.d(LOG_TAG, "onStart");
	}

	@Override protected void onResume() {
		super.onResume();
		textView.append("\n onResume");
		Log.d(LOG_TAG, "onResume");
	}

	@Override protected void onSaveInstanceState(Bundle outState) {
		textView.append("\n onSaveInstanceState");
		Log.d(LOG_TAG, "onSaveInstanceState");
		if (dummyString != null) {
			outState.putString(STRING_KEY, dummyString);
			Log.d(LOG_TAG, "Dummy String stored in out bundle");
		}
		super.onSaveInstanceState(outState);
	}

	@Override protected void onPause() {
		textView.append("\n onPause");
		Log.d(LOG_TAG, "onPause");
		super.onPause();
	}

	@Override protected void onStop() {
		textView.append("\n onStop");
		Log.d(LOG_TAG, "onStop");
		super.onStop();
	}

	@Override protected void onDestroy() {
		textView.append("\n onDestroy");
		Log.d(LOG_TAG, "onDestroy");
		super.onDestroy();

	}
}

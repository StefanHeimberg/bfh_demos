package ch.approppo.fragmentlifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().replace(R.id.container, new SecondFragment()).commit();
		}
	}
}

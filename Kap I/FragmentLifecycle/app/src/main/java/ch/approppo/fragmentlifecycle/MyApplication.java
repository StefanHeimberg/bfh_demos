package ch.approppo.fragmentlifecycle;

import android.app.Application;
import android.content.Context;

/**
 * Created by Martin Neff @approppo GmbH on 02.11.15.
 */
public class MyApplication extends Application {

	private static Context context;

	@Override public void onCreate() {
		super.onCreate();
	}

	public static Context getContext(){
		return context;
	}
}

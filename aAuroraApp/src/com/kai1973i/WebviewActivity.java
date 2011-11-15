/**
 * Copyright (C) 2011 Kai Otte
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.kai1973i;

import java.util.Timer;
import java.util.TimerTask;

import com.kai1973i.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * @author Kai
 * 
 */
public class WebviewActivity extends Activity {

	WebView webview;
	Timer t = null;
	int time;

	public void InitializeUI() {
		// Makes Progressbar visible

		this.getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
				Window.PROGRESS_VISIBILITY_ON);

		// WebView settings
		webview = (WebView) findViewById(R.id.webview);
		webview.getSettings().setJavaScriptEnabled(true);

		// Setup Zoom in WebView
		webview.getSettings().setSupportZoom(true);
		webview.getSettings().setBuiltInZoomControls(true);

		// webview.setWebViewClient(new WebViewClient());

		// Wer hat den Intent ausgelöst?
		final Intent intent = this.getIntent();

		// Setze Webview-Titel
		final String title = intent.getStringExtra("name");

		// this.setTitle(intent.getStringExtra("name"));

		// WebAdresse laden
		webview.loadUrl(intent.getStringExtra("url"));

		time = intent.getIntExtra("timer", 5000);
		// Wenn time > 0 Alle x ms reloaden

		if (time > 0) {
			t = new Timer();
			Log.d("WebviewActivity_Timer", String.valueOf(time));

			t.scheduleAtFixedRate(new TimerTask() {

				@Override
				public void run() {
					webview.reload();

				}
			}, 0, time);

		}

		final Activity myActivity = this;
		webview.setWebChromeClient(new WebChromeClient() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * android.webkit.WebChromeClient#onProgressChanged(android.webkit
			 * .WebView, int)
			 */
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				myActivity.setTitle("Loading...");
				myActivity.setProgress(newProgress * 100);

				if (newProgress == 100) {
					myActivity.setTitle(myActivity.getIntent().getStringExtra(
							"name"));
					Log.d("setTitle", title);
				}

				super.onProgressChanged(view, newProgress);
			}

		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// Add Progressbar support
		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);

		setContentView(R.layout.webview);

		InitializeUI();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {

		Log.d("Webview", "onStop");

		webview.stopLoading();

		// Close Timer
		if (t != null) {
			t.purge();
			t.cancel();
		}

		finish();
		super.onStop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.app.Activity#onConfigurationChanged(android.content.res.Configuration
	 * )
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		Log.d("Webview", "onConfigurationChanged");
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			Log.d("Webview", "onConfigurationChanged_Landscape");
		}
		if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
			Log.d("Webview", "onConfigurationChanged_Portrait");
		}
		super.onConfigurationChanged(newConfig);
		//setContentView(R.layout.webview);

		//InitializeUI();

	}

}


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

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.security.auth.PrivateCredentialPermission;

import org.apache.http.HttpException;

import com.kai1973i.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class Auroramain extends Activity {

	WebView webview;

	private final ImageDownloader imageDownloader = new ImageDownloader();
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// XRay Status
		imageDownloader.download("http://www.n3kl.org/sun/images/status.gif?", (ImageView)findViewById(R.id.imageView1));
		
		//Geomagnetic Field status
		imageDownloader.download("http://www.n3kl.org/sun/images/kpstatus.gif?", (ImageView)findViewById(R.id.imageView2));
		
		
		final Intent intent = new Intent(this, WebviewActivity.class);
		
		final Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				intent.putExtra("url",
						"http://www.swpc.noaa.gov/ace/Mag_swe_24h.gif");
				intent.putExtra("name", "MAG SWEPAM 24h");
				intent.putExtra("timer", 60000);
				
				startActivity(intent);

			}
		});
		
		final Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				intent.putExtra("url",
						"http://www.swpc.noaa.gov/ace/Mag_swe_6h.gif");
				intent.putExtra("name", "MAG SWEPAM 6h");
				intent.putExtra("timer", 60000);

				startActivity(intent);

			}
		});

		final Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				intent.putExtra("url",
						"http://www.n3kl.org/sun/images/noaa_xrays.gif");
				intent.putExtra("name", "NOAA XRays");
				
				intent.putExtra("timer", 60000);

				startActivity(intent);

			}
		});

		final Button button4 = (Button) findViewById(R.id.button4);

		button4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				intent.putExtra("url",
						"http://www.swpc.noaa.gov/ace/Epam_3d.gif");
				intent.putExtra("name", "EPAM 3d");
				
				intent.putExtra("timer", 60000);

				startActivity(intent);

			}
		});

		final Button button5 = (Button) findViewById(R.id.button5);

		button5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				intent.putExtra("url",
						"http://www.swpc.noaa.gov/ftpdir/latest/RSGA.txt");
				intent.putExtra("name", "RSGA");
				
				intent.putExtra("timer", 0);

				startActivity(intent);

			}
		});

		final Button button6 = (Button) findViewById(R.id.button6);

		button6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				intent.putExtra("url",
						"http://www.swpc.noaa.gov/ftpdir/latest/wwv.txt");
				intent.putExtra("name", "Geophy. Alert Message");
				
				intent.putExtra("timer", 0);

				startActivity(intent);

			}
		});

		final Button button7 = (Button) findViewById(R.id.button7);

		button7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				intent.putExtra("url",
						"http://www.swpc.noaa.gov/ftpdir/latest/daypre.txt");
				intent.putExtra("name", "3-day Space Weather Predictions");
				
				intent.putExtra("timer", 0);

				startActivity(intent);

			}
		});
		
		final Button button8 = (Button) findViewById(R.id.button8);

		button8.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				intent.putExtra("url",
						"http://www.swpc.noaa.gov/pmap/gif/pmapN.gif");
				intent.putExtra("name", "Auroral Activity (N)");
				
				intent.putExtra("timer", 60000);

				startActivity(intent);

			}
		});
		
		
		

	}
	
	
}



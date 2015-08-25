package tw.edu.isu.ecgviewer;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ECGActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ecg);
		
		String myURL = "http://140.127.194.187:8080/ECGStore/Login.jsp";
		WebView myBrowse = (WebView)findViewById(R.id.webView);
		
		WebSettings websettings = myBrowse.getSettings();
		websettings.setSupportZoom(true);
		websettings.setBuiltInZoomControls(true);
		websettings.setJavaScriptEnabled(true);
		
		myBrowse.setWebViewClient(new WebViewClient());
		myBrowse.loadUrl(myURL);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ecg, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// 返回键
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	if (keyCode == KeyEvent.KEYCODE_BACK) { // 如果是手机上的返回键
		ECGActivity.this.finish();
		ECGViewer.instance.finish();
	}
	return super.onKeyDown(keyCode, event);
	}
}

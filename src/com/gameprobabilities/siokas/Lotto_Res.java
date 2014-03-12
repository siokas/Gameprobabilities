package com.gameprobabilities.siokas;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Lotto_Res extends Activity {
	WebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lotto_res);
		mWebView = (WebView) findViewById(R.id.LottoWeb);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.loadUrl("http://m.mykosmos.gr/mob_mk/lotto.asp");

	}

}

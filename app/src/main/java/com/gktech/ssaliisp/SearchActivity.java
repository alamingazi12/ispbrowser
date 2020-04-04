package com.gktech.ssaliisp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {
    WebView webView;
    String url;
    EditText inputtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        url=getIntent().getStringExtra("url");
        initAll();
        openWeb();
         findViewById(R.id.button_home).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         });

    }

    private void initAll() {
        inputtext=findViewById(R.id.editText_search);
        webView=findViewById(R.id.web_search_view);

    }

    public void openWeb(){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.co.id/search?q="+url);
        webView.setWebViewClient(new MyWebClient());
    }

    public class MyWebClient extends WebViewClient {
        public MyWebClient() {
            super();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            inputtext.setText(url);

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }



    }
}

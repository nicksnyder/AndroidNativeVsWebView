package com.example.androidnativevsweb;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;

public class LaunchActivity extends AppCompatActivity {
  private FragmentTabHost mTabHost;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Fresco.initialize(this);
    setContentView(R.layout.activity_launch);
    ActionBar bar = getSupportActionBar();
    if (bar != null) {
      bar.hide();
    }

    mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

    mTabHost.addTab(mTabHost.newTabSpec("reset").setIndicator("Reset"), ResetFragment.class, null);
    //mTabHost.addTab(mTabHost.newTabSpec("webview10").setIndicator("WebView10"), CustomWebViewFragment.class, CustomWebViewFragment.getArgsBundle("file:///android_asset/list10.html"));
    //mTabHost.addTab(mTabHost.newTabSpec("webview20").setIndicator("WebView20"), CustomWebViewFragment.class, CustomWebViewFragment.getArgsBundle("file:///android_asset/list20.html"));
    mTabHost.addTab(mTabHost.newTabSpec("webview100").setIndicator("WebView100"), CustomWebViewFragment.class, CustomWebViewFragment.getArgsBundle("file:///android_asset/list100.html"));
    mTabHost.addTab(mTabHost.newTabSpec("fresco").setIndicator("Fresco"), ItemsRecyclerViewFrescoFragment.class, ItemsRecyclerViewFrescoFragment.getArgsBundle(100));
    //mTabHost.addTab(mTabHost.newTabSpec("glide").setIndicator("Glide"), ItemsRecyclerViewFrescoFragment.class, ItemsRecyclerViewGlideFragment.getArgsBundle(100));
    mTabHost.addTab(mTabHost.newTabSpec("frescolist").setIndicator("FrescoList"), ItemListFragment.class, ItemListFragment.getArgsBundle(100));
  }
}

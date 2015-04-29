package com.example.androidnativevsweb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 */
public class CustomWebViewFragment extends SupportWebViewFragment {
  private static final String ARG_URL = "url";

  private String mUrl;

  /**
   * @param url The URL to load.
   * @return A new instance of fragment CustomWebViewFragment.
   */
  public static CustomWebViewFragment newInstance(String url) {
    CustomWebViewFragment fragment = new CustomWebViewFragment();
    fragment.setArguments(getArgsBundle(url));
    return fragment;
  }

  public static Bundle getArgsBundle(String url) {
    Bundle args = new Bundle();
    args.putString(ARG_URL, url);
    return args;
  }

  public CustomWebViewFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mUrl = getArguments().getString(ARG_URL);
    }
  }

  @Override
  public void onStart() {
    super.onStart();
    getWebView().loadUrl(mUrl);
  }

  @Override
  public void onStop() {
    super.onStop();
  }
}

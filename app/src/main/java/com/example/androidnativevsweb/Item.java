package com.example.androidnativevsweb;

import android.net.Uri;

/**
 * Created by nsnyder on 4/29/15.
 */
public class Item {
  String mText;
  Uri[] mImageUrls;

  public Item(String text, Uri[] imageUrls) {
    mText = text;
    mImageUrls = imageUrls;
  }
}


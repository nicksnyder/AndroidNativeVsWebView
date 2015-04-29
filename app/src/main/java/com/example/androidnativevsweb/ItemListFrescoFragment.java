package com.example.androidnativevsweb;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 */
public class ItemListFrescoFragment extends ListFragment {

  private static final String TAG = ItemListFrescoFragment.class.getName();
  private static final String ARG_COUNT = "count";

  private int mCount;

  public static ItemListFrescoFragment newInstance(int count) {
    ItemListFrescoFragment fragment = new ItemListFrescoFragment();
    fragment.setArguments(getArgsBundle(count));
    return fragment;
  }

  public static Bundle getArgsBundle(int count) {
    Bundle args = new Bundle();
    args.putInt(ARG_COUNT, count);
    return args;
  }

  public ItemListFrescoFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mCount = getArguments().getInt(ARG_COUNT);
    }
    ItemListAdapter listAdapter = new ItemListAdapter(getActivity(), R.layout.fragment_item_list);
    listAdapter.addAll(generateItems());
    setListAdapter(listAdapter);
  }

  private Item[] generateItems() {
    Item[] items = new Item[mCount];
    for (int i=0; i<mCount; i++) {
      items[i] = new Item("Row " + i, new Uri[] {
          Uri.parse("http://lorempixel.com/100/100/?item=0&section=" + i),
          Uri.parse("http://lorempixel.com/100/100/?item=1&section=" + i),
          Uri.parse("http://lorempixel.com/100/100/?item=2&section=" + i),
          Uri.parse("http://lorempixel.com/100/100/?item=3&section=" + i),
          Uri.parse("http://lorempixel.com/100/100/?item=4&section=" + i),
          Uri.parse("http://lorempixel.com/100/100/?item=5&section=" + i),
          Uri.parse("http://lorempixel.com/100/100/?item=6&section=" + i),
          Uri.parse("http://lorempixel.com/100/100/?item=7&section=" + i),
          Uri.parse("http://lorempixel.com/100/100/?item=8&section=" + i)
      });
    }
    return items;
  }

  public class ItemListAdapter extends ArrayAdapter<Item> {

    public ItemListAdapter(Context context, int resource) {
      super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ViewHolder viewHolder;
      if (convertView == null) {
        LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row_item_fresco, null);
        viewHolder = new ViewHolder(convertView);
        convertView.setTag(viewHolder);
      } else {
        viewHolder = (ViewHolder) convertView.getTag();
      }

      Item item = getItem(position);
      viewHolder.mTextView.setText(item.mText);
      viewHolder.mTextView.setText(item.mText);
      viewHolder.mImageView0.setImageURI(item.mImageUrls[0]);
      viewHolder.mImageView1.setImageURI(item.mImageUrls[1]);
      viewHolder.mImageView2.setImageURI(item.mImageUrls[2]);
      viewHolder.mImageView3.setImageURI(item.mImageUrls[3]);
      viewHolder.mImageView4.setImageURI(item.mImageUrls[4]);
      viewHolder.mImageView5.setImageURI(item.mImageUrls[5]);
      viewHolder.mImageView6.setImageURI(item.mImageUrls[6]);
      viewHolder.mImageView7.setImageURI(item.mImageUrls[7]);
      return convertView;
    }
  }

  private static class ViewHolder {
    final TextView mTextView;
    final ImageView mImageView0;
    final ImageView mImageView1;
    final ImageView mImageView2;
    final ImageView mImageView3;
    final ImageView mImageView4;
    final ImageView mImageView5;
    final ImageView mImageView6;
    final ImageView mImageView7;

    public ViewHolder(View v) {
      mTextView = (TextView) v.findViewById(R.id.textView);
      mImageView0 = (ImageView) v.findViewById(R.id.imageView0);
      mImageView1 = (ImageView) v.findViewById(R.id.imageView1);
      mImageView2 = (ImageView) v.findViewById(R.id.imageView2);
      mImageView3 = (ImageView) v.findViewById(R.id.imageView3);
      mImageView4 = (ImageView) v.findViewById(R.id.imageView4);
      mImageView5 = (ImageView) v.findViewById(R.id.imageView5);
      mImageView6 = (ImageView) v.findViewById(R.id.imageView6);
      mImageView7 = (ImageView) v.findViewById(R.id.imageView7);
    }
  }
}

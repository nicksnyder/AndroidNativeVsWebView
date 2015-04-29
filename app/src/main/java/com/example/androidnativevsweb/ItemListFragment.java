package com.example.androidnativevsweb;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 */
public class ItemListFragment extends ListFragment {

  private static final String TAG = ItemListFragment.class.getName();
  private static final String ARG_COUNT = "count";

  private int mCount;

  public static ItemListFragment newInstance(int count) {
    ItemListFragment fragment = new ItemListFragment();
    fragment.setArguments(getArgsBundle(count));
    return fragment;
  }

  public static Bundle getArgsBundle(int count) {
    Bundle args = new Bundle();
    args.putInt(ARG_COUNT, count);
    return args;
  }

  public ItemListFragment() {
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
        convertView = inflater.inflate(R.layout.row_item, null);
        viewHolder = new ViewHolder(convertView);
        convertView.setTag(viewHolder);
      } else {
        viewHolder = (ViewHolder) convertView.getTag();
      }

      Item item = getItem(position);
      viewHolder.mTextView.setText(item.mText);
      Glide.with(ItemListFragment.this).load(item.mImageUrls[0]).into(viewHolder.mImageView0);
      Glide.with(ItemListFragment.this).load(item.mImageUrls[1]).into(viewHolder.mImageView1);
      Glide.with(ItemListFragment.this).load(item.mImageUrls[2]).into(viewHolder.mImageView2);
      Glide.with(ItemListFragment.this).load(item.mImageUrls[3]).into(viewHolder.mImageView3);
      Glide.with(ItemListFragment.this).load(item.mImageUrls[4]).into(viewHolder.mImageView4);
      Glide.with(ItemListFragment.this).load(item.mImageUrls[5]).into(viewHolder.mImageView5);
      Glide.with(ItemListFragment.this).load(item.mImageUrls[6]).into(viewHolder.mImageView6);
      Glide.with(ItemListFragment.this).load(item.mImageUrls[7]).into(viewHolder.mImageView7);
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

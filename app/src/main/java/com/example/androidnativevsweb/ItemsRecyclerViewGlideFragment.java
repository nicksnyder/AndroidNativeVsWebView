package com.example.androidnativevsweb;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 */
public class ItemsRecyclerViewGlideFragment extends Fragment {
  private static final String TAG = ItemsRecyclerViewGlideFragment.class.getName();
  private static final String ARG_COUNT = "count";

  private int mCount;
  private Item[] mItems;

  public static ItemsRecyclerViewGlideFragment newInstance(int count) {
    ItemsRecyclerViewGlideFragment fragment = new ItemsRecyclerViewGlideFragment();
    fragment.setArguments(getArgsBundle(count));
    return fragment;
  }

  public static Bundle getArgsBundle(int count) {
    Bundle args = new Bundle();
    args.putInt(ARG_COUNT, count);
    return args;
  }

  public ItemsRecyclerViewGlideFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mCount = getArguments().getInt(ARG_COUNT);
    }
    initItems();
  }

  private void initItems() {
    Log.d(TAG, "initItems start");
    mItems = new Item[mCount];
    for (int i=0; i<mCount; i++) {
      mItems[i] = new Item("Random 8 imgs", new Uri[] {
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
    Log.d(TAG, "initItems finish");
  }

  private static class Item {
    String mText;
    Uri[] mImageUrls;

    public Item(String text, Uri[] imageUrls) {
      mText = text;
      mImageUrls = imageUrls;
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_items_recycler_view, container, false);
    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(new ItemAdapter(mItems));
    return rootView;
  }

  private class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final Item[] mItems;

    public ItemAdapter(Item[] items) {
      mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
      return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
      Item item = mItems[i];
      viewHolder.mTextView.setText(item.mText);
      Glide.with(ItemsRecyclerViewGlideFragment.this).load(item.mImageUrls[0]).into(viewHolder.mImageView0);
      Glide.with(ItemsRecyclerViewGlideFragment.this).load(item.mImageUrls[1]).into(viewHolder.mImageView1);
      Glide.with(ItemsRecyclerViewGlideFragment.this).load(item.mImageUrls[2]).into(viewHolder.mImageView2);
      Glide.with(ItemsRecyclerViewGlideFragment.this).load(item.mImageUrls[3]).into(viewHolder.mImageView3);
      Glide.with(ItemsRecyclerViewGlideFragment.this).load(item.mImageUrls[4]).into(viewHolder.mImageView4);
      Glide.with(ItemsRecyclerViewGlideFragment.this).load(item.mImageUrls[5]).into(viewHolder.mImageView5);
      Glide.with(ItemsRecyclerViewGlideFragment.this).load(item.mImageUrls[6]).into(viewHolder.mImageView6);
      Glide.with(ItemsRecyclerViewGlideFragment.this).load(item.mImageUrls[7]).into(viewHolder.mImageView7);
    }

    @Override
    public int getItemCount() {
      return mItems.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
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
        super(v);
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
}

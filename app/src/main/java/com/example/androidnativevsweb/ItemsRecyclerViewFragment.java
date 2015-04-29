package com.example.androidnativevsweb;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 */
public class ItemsRecyclerViewFragment extends Fragment {
  private static final String TAG = ItemsRecyclerViewFragment.class.getName();
  private static final String ARG_COUNT = "count";

  private int mCount;
  private Item[] mItems;

  public static ItemsRecyclerViewFragment newInstance(int count) {
    ItemsRecyclerViewFragment fragment = new ItemsRecyclerViewFragment();
    fragment.setArguments(getArgsBundle(count));
    return fragment;
  }

  public static Bundle getArgsBundle(int count) {
    Bundle args = new Bundle();
    args.putInt(ARG_COUNT, count);
    return args;
  }

  public ItemsRecyclerViewFragment() {
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
    mItems = new Item[mCount];
    for (int i=0; i<mCount; i++) {
      mItems[i] = new Item("Row " + i, new Uri[] {
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
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_items_recycler_view, container, false);
    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
    recyclerView.setHasFixedSize(true);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(new ItemAdapter(mItems));
    return rootView;
  }

  private static class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private final Item[] mItems;

    public ItemAdapter(Item[] items) {
      mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item_fresco, viewGroup, false);
      return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
      Item item = mItems[i];
      viewHolder.mTextView.setText(item.mText);
      viewHolder.mImageView0.setImageURI(item.mImageUrls[0]);
      viewHolder.mImageView1.setImageURI(item.mImageUrls[1]);
      viewHolder.mImageView2.setImageURI(item.mImageUrls[2]);
      viewHolder.mImageView3.setImageURI(item.mImageUrls[3]);
      viewHolder.mImageView4.setImageURI(item.mImageUrls[4]);
      viewHolder.mImageView5.setImageURI(item.mImageUrls[5]);
      viewHolder.mImageView6.setImageURI(item.mImageUrls[6]);
      viewHolder.mImageView7.setImageURI(item.mImageUrls[7]);
    }

    @Override
    public int getItemCount() {
      return mItems.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
      final TextView mTextView;
      final SimpleDraweeView mImageView0;
      final SimpleDraweeView mImageView1;
      final SimpleDraweeView mImageView2;
      final SimpleDraweeView mImageView3;
      final SimpleDraweeView mImageView4;
      final SimpleDraweeView mImageView5;
      final SimpleDraweeView mImageView6;
      final SimpleDraweeView mImageView7;

      public ViewHolder(View v) {
        super(v);
        mTextView = (TextView) v.findViewById(R.id.textView);
        mImageView0 = (SimpleDraweeView) v.findViewById(R.id.imageView0);
        mImageView1 = (SimpleDraweeView) v.findViewById(R.id.imageView1);
        mImageView2 = (SimpleDraweeView) v.findViewById(R.id.imageView2);
        mImageView3 = (SimpleDraweeView) v.findViewById(R.id.imageView3);
        mImageView4 = (SimpleDraweeView) v.findViewById(R.id.imageView4);
        mImageView5 = (SimpleDraweeView) v.findViewById(R.id.imageView5);
        mImageView6 = (SimpleDraweeView) v.findViewById(R.id.imageView6);
        mImageView7 = (SimpleDraweeView) v.findViewById(R.id.imageView7);
      }
    }
  }
}

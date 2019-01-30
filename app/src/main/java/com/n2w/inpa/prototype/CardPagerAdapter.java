package com.n2w.inpa.prototype;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mCardView;
    private List<CardItem> mCardItem;
    private float mBaseElevation;
    private Activity activity;

    public CardPagerAdapter(Activity activity){
        mCardView = new ArrayList<>();
        mCardItem = new ArrayList<>();
        this.activity = activity;
    }

    public void addCardItem(CardItem item)
    {
        mCardView.add(null);
        mCardItem.add(item);
    }

    //@Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mCardView.get(position);
    }

    @Override
    public int getCount() {
        return mCardItem.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        Log.d("inst", "Instantiating Card Adapter...");

        //LayoutInflater layInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewInflate = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter_card, container,false);
        container.addView(viewInflate);
        bind(mCardItem.get(position), viewInflate);
        CardView cardView = viewInflate.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mCardView.set(position, cardView);

        return viewInflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mCardView.set(position, null);
    }

    private void bind(CardItem item, View view) {

        RequestOptions imgReqOpt = new RequestOptions();
        imgReqOpt.override(800,600);
        imgReqOpt.fitCenter();

        TextView titleTextView = view.findViewById(R.id.titleTextView);
        ImageView backViewImage = view.findViewById(R.id.backViewImage);
        titleTextView.setText(item.getTitle());
        backViewImage.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(view)
                .load("https://hikersforlife.com/wp-content/uploads/2016/06/endaurompinselaifeature.jpg")
                .apply(imgReqOpt)
                .into(backViewImage);
    }
}

package com.spotit.tonys.spottheball;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by tonys on 2/18/2016.
 */
public class CustomAdapter extends PagerAdapter{

    Context context;
    int[] imageId = {R.drawable.messi1, R.drawable.messi2, R.drawable.messi3, R.drawable.messi4};

    public CustomAdapter(Context context){
        this.context = context;

    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View viewItem = inflater.inflate(R.layout.image_item, container, false);
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView);
        imageView.setImageResource(imageId[position]);
        ((ViewPager)container).addView(viewItem);
        return viewItem;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }
}

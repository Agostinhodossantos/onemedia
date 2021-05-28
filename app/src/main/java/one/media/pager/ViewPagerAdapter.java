package one.media.pager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

import one.media.R;
import one.media.model.ImageAds;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    public List<ImageAds> mListt;

    public ViewPagerAdapter(Context context, List<ImageAds> mListt ){

        this.mListt = mListt;
        this.context = context;


    }
    @Override
    public int getCount() {
        return mListt.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;

    }

    @NonNull

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
//        RoundedImageView riv = new RoundedImageView(context);
//        riv.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        riv.setCornerRadius((float) 10);
//        riv.setImageResource(R.drawable.banner_de_super);
        View view = LayoutInflater.from(context).inflate(R.layout.item_card,null ,false);
        ImageView imageview = view.findViewById(R.id.imageView);
        imageview.setImageResource(mListt.get(position).getImg());

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
        //destroyItem(container, position, object);
    }
}
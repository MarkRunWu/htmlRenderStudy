package com.example.avastimagetest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ImageView;

import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;

public class BitmapWorkerTask extends AsyncTask<Boolean, Void, Void> {
    private Context context;
    private ImageView imageView;
    private String imageUrl;
    public BitmapWorkerTask(Context context,String imageUrl, ImageView imageView) {
        this.context = context;        
        this.imageView = imageView;
        this.imageUrl = imageUrl;
        Drawable drawable = new AsyncDrawable(context.getResources(), this);
        this.imageView.setImageDrawable(drawable);
    }

    @Override
    protected Void doInBackground(Boolean... params) {
        if (BitmapHelper.getCache().get(imageUrl) != null) {
            return null;
        }

        // try to skip fling gesture
        SystemClock.sleep(100);

        if (isOutOfScreen()) {
            cancel(true);
            return null;
        }


        File file = DiskCacheHelper.getFileOf(context, imageUrl);
        Bitmap bmp = DiskCacheHelper.readBitmap(file);
        if( bmp != null ){
            BitmapHelper.getCache().put(imageUrl, bmp );
            return null;
        }

        // try to skip fling gesture
        SystemClock.sleep(100);

        if (isOutOfScreen()) {
            cancel(true);
            return null;
        }

        try {
            URL url = new URL(imageUrl);
            bmp = BitmapHelper.decodeScaledBitmapFromURL(url);
            if( bmp != null ){
                BitmapHelper.getCache().put(imageUrl, bmp );
                DiskCacheHelper.writhBitmap(file, BitmapHelper.getCache().get(imageUrl) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        if (isOutOfScreen()) {
            return;
        }
        imageView.setImageBitmap(BitmapHelper.getCache().get(imageUrl));
    }

    private boolean isOutOfScreen() {
        BitmapWorkerTask task = getBitmapWorkerTask(imageView);
        if (task == null || !task.equals(this)) {
            return true;
        }
        return false;
    }

    private static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView != null) {
            final Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
                return asyncDrawable.getBitmapWorkerTask();
            }
        }
        return null;
    }

    private static class AsyncDrawable extends BitmapDrawable {
        private final WeakReference<BitmapWorkerTask> reference;

        public AsyncDrawable(Resources res, BitmapWorkerTask bitmapWorkerTask) {
            super(res);
            reference = new WeakReference<BitmapWorkerTask>(bitmapWorkerTask);
        }

        public BitmapWorkerTask getBitmapWorkerTask() {
            return reference.get();
        }
    }
}

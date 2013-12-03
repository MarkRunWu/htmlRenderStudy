package com.example.avastimagetest;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;

public class BitmapHelper {
    static LruCache<String,Bitmap> mMemoryCache = null;
    
    public static LruCache<String,Bitmap> getCache(){
        if (mMemoryCache == null) {
            // Get max available VM memory, exceeding this amount will throw an
            // OutOfMemory exception. Stored in kilobytes as LruCache takes an
            // int in its constructor.
            final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

            // Use 1/8th of the available memory for this memory cache.
            final int cacheSize = maxMemory / 8;

            mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    // The cache size will be measured in kilobytes rather than
                    // number of items.
                    return bitmap.getByteCount() / 1024;
                }
            };
        }
        return mMemoryCache;
    }
    
    public static Bitmap getImage(Context context, String url){
        Bitmap bmp = getCache().get(url); 
        if( bmp != null ){
            return bmp;
        }
        File file = DiskCacheHelper.getFileOf(context, url);
        bmp = DiskCacheHelper.readBitmap(file);
        if( bmp == null ){
            return null;
        }
        getCache().put(url, bmp);
        return bmp;
    }
    
    public static Bitmap decodeScaledBitmapFromURL(URL imageUrl) {
        try {                        
            return BitmapFactory.decodeStream((InputStream) imageUrl.getContent(), null, options);
            

        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }

        return null;
    }

    private static BitmapFactory.Options options = null;

    private static BitmapFactory.Options getBitmapOptions() {
        if (options == null) {
            options = new BitmapFactory.Options();
            options.inPurgeable = true;
            options.inInputShareable = true;
        }

        return options;
    }
}

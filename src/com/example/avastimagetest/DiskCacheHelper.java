package com.example.avastimagetest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

public class DiskCacheHelper {

    public synchronized static File getFileOf(Context context, String imageName) {
        // Check if media is mounted or storage is built-in,
        // if so, try and use external cache dir
        // otherwise use internal cache dir

        String cachePath = context.getCacheDir().getPath();
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            File f = context.getExternalCacheDir();
            if (f != null) {
                cachePath = f.getPath();
            }
        }

        int pos = imageName.lastIndexOf("/");
        if (pos != -1) {
            imageName = imageName.substring(pos + 1);
        }

        return new File(cachePath, imageName);
    }

    public synchronized static Bitmap readBitmap(File file) {
        if (file.exists()) {
            try {
                return BitmapFactory.decodeFile(file.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public synchronized static void writhBitmap(File file, Bitmap bitmap) {
        if (file == null || bitmap == null) {
            return;
        }

        try {
            OutputStream outStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

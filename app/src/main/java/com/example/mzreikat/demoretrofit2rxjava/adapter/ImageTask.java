package com.example.mzreikat.demoretrofit2rxjava.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Not used class ---> using Picasso instead
 */
public class ImageTask extends AsyncTask<String, String, Bitmap>
{
    @SuppressLint("StaticFieldLeak")
    private ImageView imageView;

    public ImageTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        String imgUrl = urls[0];
        Bitmap logo = null;
        try {
            InputStream inputStream = new URL(imgUrl).openStream();

            logo = BitmapFactory.decodeStream(inputStream);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return logo;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}
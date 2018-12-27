package com.example.rakafirmansyahpramono.portalberitacnn;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

public class BeritaLoader extends AsyncTaskLoader<String> {

    private String mQueryString;

    BeritaLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBeritaInfo(mQueryString);
    }
}
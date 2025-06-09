
package com.secure.earlyinit;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class EarlyInitProvider extends ContentProvider {
    static {
        System.loadLibrary("earlyinit");
    }

    @Override
    public boolean onCreate() {
        Log.i("EarlyInitProvider", "JNI early check: " + nativeCheckSecureBoot());
        return true;
    }

    public static native boolean nativeCheckSecureBoot();

    @Override public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) { return null; }
    @Override public String getType(Uri uri) { return null; }
    @Override public Uri insert(Uri uri, ContentValues values) { return null; }
    @Override public int delete(Uri uri, String selection, String[] selectionArgs) { return 0; }
    @Override public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) { return 0; }
}

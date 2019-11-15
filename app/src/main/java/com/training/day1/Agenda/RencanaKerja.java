package com.training.day1.Agenda;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

//Rencana kerja di extends(mewarisi ContentProvider(Memberikan akses kepada user untuk membaca dan menulis data)\\
public class RencanaKerja extends ContentProvider {

//   memberi nama dan mengakses provider \\
    public static final String NAMA_PROVIDER = "com.training.day1.Agenda";
//    menggunakan library Uri mengurai content dan memberikan nilanya ke URI_ISI\\
    public static Uri URI_ISI = Uri.parse("content://"+NAMA_PROVIDER+"/Agenda");
//    mengakses nilai string dari  konstanta.java class yang bernama ID_AGENDA lalu di masukan nilainya ke _ID\\
    public static final String  _ID = Konstanta.ID_AGENDA;
//    mengakses nilai string dari Konstanta.java clss yang bernama NAM_AGENDA lalu dimasukan nilainya ke NAMA_AGENDA\\
    public static final String NAMA_AGENDA = Konstanta.NAMA_AGENDA;
//    mengakses nilai dari Kontanta.java class yang bernama SIFAT_AGENDA lalu dimasukan nilainya ke SIFAT_AGENDA\\
    public static final String SIFAT_AGENDA = Konstanta.SIFAT_AGENDA;

    private static  final int AGENDA = 1;
    private static final int ID_AGENDA =2;
//  mendeklarasikan class DBHelper
    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
//  membuat object UriMatcher yang berguna untuk mencocokan materi didalam URI
    private static final UriMatcher urimatcher = new UriMatcher(UriMatcher.NO_MATCH);

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}

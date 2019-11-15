package com.training.day1.Agenda;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// SEBELUM MEMBUAT DBSql di extend(mewarisi) ke SQLiteOpenHelper{}\\
public class DBHelper extends SQLiteOpenHelper {

//  memberikan perintah pada sqlite untuk membuat tablenya yang kita buat nilainya pada konstanta java.class\\
//    dan untuk String NAMA_TABLE itu tidak ada di konstanta java.class, jadi kita buat diclass ini sendiri\\
//**   Stiap isi variable dari pembuatan table diharuskan
// diberikan nilai, contoh "Text not null"
// jika diberikan nilai seperti String kosong contoh: (String = "";)
// ini tidak sama nilainya dengan memberikan nilai ("null") dan  jika tidak diberikan nilai ia akan melempar (exception null sql )**\\
    private final static  String BUAT_TABLE ="create table"+
        Konstanta.NAMA_TABLE +
        "("+ Konstanta.NAMA_AGENDA + "text not null"
        +Konstanta.SIFAT_AGENDA + "text not null" +
        Konstanta.ID_AGENDA +"integer primary key autoincrement";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Konstanta.NAMA_DB, null, Konstanta.VERSI_DB);
    }

//    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }
//
//    public DBHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
//        super(context, name, version, openParams);
//    }

//    kontruksi: Mencoba meng eksekusi Statment SQL yang tidak mempunyai nilai return, jika tidak ter eksekusi ia akan menjalankan catch \\
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(BUAT_TABLE);
        } catch (SQLiteException e) {

        }
    }

//    membuka upgrade DBSQL versi lama dan baru
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        di eksekusi ( taru versi jika ada di Kontanta.NAMA_TABLE
        db.execSQL("drop table if exists" + Konstanta.NAMA_TABLE);
//        dan buka db
        onCreate(db);

    }
}


package com.training.day1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class TambahActivity extends AppCompatActivity {
    EditText editTextRencana;
    CheckBox checkBoxSifat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        editTextRencana = (EditText) findViewById(R.id.editTextRencana);
        checkBoxSifat = (CheckBox) findViewById(R.id.checkBoxSifatRencana);

        // Penanganan tombol Simpan
        Button tombolSimpanPenambahan = (Button) findViewById(
                R.id.buttonSimpanPenambahan);
        tombolSimpanPenambahan.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        String namaRencana = editTextRencana.getText()
                                .toString().trim();
                        if (!namaRencana.equals("")) {
                            // Lakukan penyimpanan data
                            ContentValues data = new ContentValues();
                            data.put("nama", namaRencana);
                            if (checkBoxSifat.isChecked())
                                data.put("sifat", "Penting");
                            else
                                data.put("sifat", "Biasa");

                            Uri uri = Uri.parse("content://com.example.rencana/rencana");
                            getContentResolver().insert(uri, data);
                        }

                        // Tutup activity ini
                        Intent intent = new Intent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });

        // Penanganan tombol Batal
        Button tombolBatal = (Button) findViewById(
                R.id.buttonBatal);
        tombolBatal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Batalkan penambahan data
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

    }

}

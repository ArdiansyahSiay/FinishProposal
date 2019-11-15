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

public class HapusUbahActivity extends AppCompatActivity {
    EditText editTextRencana;
    CheckBox checkBoxSifat;
    int sId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_ubah);
        editTextRencana = (EditText) findViewById(R.id.editTextRencana2);

        checkBoxSifat = (CheckBox) findViewById(
                R.id.checkBoxSifatRencana2);

        // Peroleh data dari MainActivity
        Bundle data = getIntent().getExtras();

        sId = Integer.valueOf(data.getString("Id").trim());
        String sNama = data.getString("Nama");
        String sSifat = data.getString("Sifat").trim();

        // Tampilkan di EditText
        editTextRencana.setText(sNama);
        if (sSifat.equals("Penting"))
            checkBoxSifat.setChecked(true);
        else
            checkBoxSifat.setChecked(false);

        // Penanganan tombol simpan
        Button tombolSimpanPerubahan = (Button) findViewById(
                R.id.buttonSimpanPerubahan);
        tombolSimpanPerubahan.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // Lakukan pemutakhiran data
                        ContentValues data = new ContentValues();
                        String namaRencana = editTextRencana.getText().toString();
                        data.put("nama", namaRencana);
                        if (checkBoxSifat.isChecked())
                            data.put("sifat", "Penting");
                        else
                            data.put("sifat", "Biasa");

                        Uri uri = Uri.parse("content://com.example.rencana/rencana/");
                        getContentResolver().update(uri, data, "id=" + sId, null);

                        // Tutup activity ini
                        Intent intent = new Intent();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });

        // Penanganan tombol hapus
        Button tombolHapus = (Button) findViewById(
                R.id.buttonHapus);
        tombolHapus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Lakukan penghapusan data
                Uri uri = Uri.parse("content://com.example.rencana/rencana/");
                getContentResolver().delete(uri, "id=" + sId, null);

                // Tutup activity ini
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        // Penanganan tombol batal
        Button tombolBatal = (Button) findViewById(
                R.id.buttonBatal2);
        tombolBatal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Pembatalan
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);

                finish();
            }
        });

    }
}

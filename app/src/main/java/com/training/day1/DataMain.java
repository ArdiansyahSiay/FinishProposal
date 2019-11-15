package com.training.day1;

import java.util.ArrayList;

public class DataMain {

    public static String []NamaProduk ={
            "PT.Multi Inti Digital Transportasi",
            "PT.Multi Inti Digital Lestari",
            "PT.Sistem Digital Transaksi Indonesia",
            "PT.Sistem Digital Loyalti Indonesia",
            "PT.Multi Inti Digital Logistik",
    };
    public static int []ButtonDetail ={
            R.drawable.buku,
            R.drawable.buku,
            R.drawable.buku,
            R.drawable.buku,
            R.drawable.buku,
    };

//    public static int []Ngopi = {
//            R.drawable.kopi,
//            R.drawable.kopi,
//            R.drawable.kopi,
//            R.drawable.kopi,
//            R.drawable.kopi,
//    };

    public static int []ImgProduk = {
            R.drawable.imgmdt,
            R.drawable.imgmdblestari,
            R.drawable.imgsdti,
            R.drawable.imgsdli,
            R.drawable.imgmdl,
    };

    public static ArrayList<SetGetMain> DisplayMain(){
        ArrayList<SetGetMain> list = new ArrayList<>();
        for (int position = 0 ; position <NamaProduk.length; position++){
            SetGetMain setGetMain = new SetGetMain();
            setGetMain.setDeskripsi(ButtonDetail[position]);
            setGetMain.setNama(NamaProduk[position]);
            setGetMain.setImgProduk(ImgProduk[position]);
//            setGetMain.setKopi(Ngopi[position]);
            list.add(setGetMain);
        }
        return list;
    }
}


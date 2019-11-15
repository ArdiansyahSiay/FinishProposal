package com.training.day1.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import com.training.day1.AgendaMDT;
import com.training.day1.MainActivity;
import com.training.day1.R;
import com.training.day1.SetGetMain;

import java.util.ArrayList;

public class AdapterMain extends BaseAdapter {

    private ArrayList<SetGetMain> MainList;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterMain(Context context, ArrayList<SetGetMain> result) {
        MainList = result;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public class MyViewHolder {
        ImageView imgMain;
        TextView NamaProduk;
        ImageView deskrp;
        ImageView Kopi;
    }

    @Override
    public int getCount() {
        return MainList.size();
    }

    @Override
    public Object getItem(int position) {
        return MainList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {

        final View view;
        MyViewHolder mViewHolder=null;
        if (convertView==null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view= inflater.inflate(R.layout.item_main,null,false);
            mViewHolder = new MyViewHolder();
            mViewHolder.imgMain=view.findViewById(R.id.imgMDB);
            mViewHolder.NamaProduk=view.findViewById(R.id.tvNama);
            mViewHolder.deskrp=view.findViewById(R.id.deskip);
//            mViewHolder.Kopi=view.findViewById(R.id.kopi);
            view.setTag(mViewHolder);
        } else {
            view = convertView;
            mViewHolder = (MyViewHolder)view.getTag();

        }

        mViewHolder.NamaProduk.setText(MainList.get(position).getNama());
//        Picasso.with(context).load(MainList.get(position).getKopi()).resize(80, 80).into(mViewHolder.Kopi);
        Picasso.get().load(MainList.get(position).getDeskripsi()).resize(80, 80).into(mViewHolder.deskrp);
        Picasso.get().load(MainList.get(position).getImgProduk()).resize(165, 165).into(mViewHolder.imgMain);
        view.setId(position);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(context, AgendaMDT.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    break;
                    case 1:
                        Toast.makeText(context,"Belum Dapat Ditampilkan"+view.getId() ,Toast.LENGTH_SHORT).show();
//                        Intent intent1 = new Intent(context,CoffeBreakMDL.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(intent1);
//                    case 2:
//                        Intent intent2 = new Intent(context,CofferBreakSDTI.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(intent2);
//                    case 3:
//                        Intent intent3 = new Intent(context,CoffeBreakSDLI.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(intent3);
//                    case 4:
//                        Intent intent4 = new Intent(context,CoffeBreakMDLogistik.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(intent4);
//                        break;
//                        default:
                }
            }
        });

        return view;

    }

    }
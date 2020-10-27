package com.example.appopetroomdb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appopetroomdb.R;
import com.example.appopetroomdb.model.Carro;

import java.util.List;
import java.util.zip.Inflater;

public class CarroAdapter extends ArrayAdapter<Carro> {
    private int resId;

    public CarroAdapter(@NonNull Context context, int resource, @NonNull List<Carro> objects) {
        super(context, resource, objects);
        this.resId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View mView = convertView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            mView = inflater.inflate(resId,null);
        }

        Carro carro = getItem(position);
        TextView textMarca = mView.findViewById(R.id.textMarca);
        TextView textModelo = mView.findViewById(R.id.textModelo);
        TextView textAno = mView.findViewById(R.id.textAno);
        TextView textPlaca = mView.findViewById(R.id.textPlaca);

        textMarca.setText(carro.getMarca());
        textModelo.setText(carro.getModelo());
        textAno.setText(String.valueOf(carro.getAno()));
        textPlaca.setText(carro.getPlaca());

        return mView;
    }
}

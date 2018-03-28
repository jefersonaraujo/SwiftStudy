package com.example.appmoney;

import java.util.ArrayList;

import com.example.appmoney.Conta.TIPO;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class ContasAdapter extends BaseAdapter {

	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private LayoutInflater layoutInflater;
	private Context context;
	private TextView tvSaldo;
	
	public ContasAdapter(Context context, TextView tvSaldo) {
		this.context = context;
		this.tvSaldo = tvSaldo;
	}
	
	public void addConta(Conta conta){
		contas.add(conta);
		notifyDataSetChanged();
		updateSaldo();
	}

	public void remConta(Conta conta){
		contas.remove(conta);
		notifyDataSetChanged();
		updateSaldo();
	}

	private void updateSaldo() {
		double total = 0;
		for (Conta conta : contas) {
			if(conta.getTipo() == TIPO.DESPEZA)
				total -= conta.getValor();
			else
				total += conta.getValor();
		}
		tvSaldo.setText(String.valueOf(total));
	}

	@Override
	public int getCount() {
		return contas.size();
	}

	@Override
	public Conta getItem(int index) {
		return contas.get(index);
	}

	@Override
	public long getItemId(int index) {
		return 0;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		layoutInflater = (LayoutInflater) context.
				getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Holder holder;
		if(view == null){
			view = layoutInflater.inflate(R.layout.each_conta, null);
			holder = new Holder();
			holder.tvTipo = (TextView) view.findViewById(R.id.tvTipo);
			holder.tvValor = (TextView) view.findViewById(R.id.tvValor);
			holder.btDelete = (ImageButton) view.findViewById(R.id.btDelete);
			view.setTag(holder);
		}else
			holder = (Holder) view.getTag();
		final Conta conta = contas.get(i);
		if(conta.getTipo() == TIPO.RECEITA){
			holder.tvTipo.setText("R");
			holder.tvTipo.setTextColor(Color.BLUE);
		}else{
			holder.tvTipo.setText("D");
			holder.tvTipo.setTextColor(Color.RED);
		}
		holder.tvValor.setText("R$"+ String.valueOf(conta.getValor()));
		holder.btDelete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				remConta(conta);
			}
		});
		return view;
	}
	
	static class Holder {
		
		TextView tvTipo;
		TextView tvValor;
		ImageButton btDelete;
		
	}

}

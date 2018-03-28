package com.example.appmoney;

import com.example.appmoney.Conta.TIPO;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends Activity implements OnItemClickListener{

	private ListView lvContas;
	private TextView tvSaldo;
	private ContasAdapter contasAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		lvContas = (ListView) findViewById(R.id.lvContas);
		tvSaldo = (TextView) findViewById(R.id.tvSaldo);
		lvContas.setOnItemClickListener(this);
		contasAdapter = new ContasAdapter(this, tvSaldo);
		popularAdapter();
		lvContas.setAdapter(contasAdapter);
	}

	private void popularAdapter() {
		contasAdapter.addConta(new Conta(200, TIPO.RECEITA));
		contasAdapter.addConta(new Conta(150, TIPO.RECEITA));
		contasAdapter.addConta(new Conta(300, TIPO.DESPEZA));
		contasAdapter.addConta(new Conta(400, TIPO.DESPEZA));
		contasAdapter.addConta(new Conta(130, TIPO.RECEITA));
		contasAdapter.addConta(new Conta(250, TIPO.DESPEZA));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
			case R.id.mnAdd:
				Intent i = new Intent(this, AddActivity.class);
				startActivityForResult(i, AddActivity.ADD_CONTA_CODE);
			break;
			case R.id.mnConfig:
				Toast.makeText(this, "Config", Toast.LENGTH_SHORT).show();
				break;
			case R.id.mnSobre:
				Toast.makeText(this, "Sobre", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == AddActivity.ADD_CONTA_CODE){
			Bundle extras = data.getExtras();
			Conta conta = (Conta) extras.get(AddActivity.CONTA_EXTRA);
			contasAdapter.addConta(conta);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
}

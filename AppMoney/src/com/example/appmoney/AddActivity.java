package com.example.appmoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.appmoney.Conta.TIPO;

public class AddActivity extends Activity implements OnClickListener, OnCheckedChangeListener{

	public static final int ADD_CONTA_CODE = 3;
	public static final String CONTA_EXTRA = "conta";
	
	private EditText etValor;
	private RadioButton rbDespesa;
	private RadioButton rbReceita;
	private Button btAdd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		etValor = (EditText) findViewById(R.id.etValor);
		rbDespesa = (RadioButton) findViewById(R.id.rbDespesa);
		rbDespesa.setOnCheckedChangeListener(this);
		rbReceita = (RadioButton) findViewById(R.id.rbReceita);
		rbReceita.setOnCheckedChangeListener(this);
		btAdd = (Button) findViewById(R.id.btAdd);
		btAdd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v == btAdd){
			double valor = Double.parseDouble(etValor.getText().toString());
			TIPO tipo = TIPO.DESPEZA;
			if(rbReceita.isChecked())
				tipo = TIPO.RECEITA;
			Conta conta = new Conta(valor, tipo);
			Intent i = new Intent();
			i.putExtra(CONTA_EXTRA, conta);
			setResult(ADD_CONTA_CODE, i);
			finish();
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		rbReceita.setChecked(buttonView == rbReceita);
		rbDespesa.setChecked(buttonView == rbDespesa);
	}

}

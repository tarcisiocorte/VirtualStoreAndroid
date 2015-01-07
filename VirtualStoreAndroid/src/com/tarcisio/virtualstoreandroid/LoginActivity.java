package com.tarcisio.virtualstoreandroid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.tarcisio.bo.*;

public class LoginActivity extends Activity {

	private LoginBO loginBO;

	private EditText edtLogin;

	private EditText edtSenha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		edtLogin = (EditText) findViewById(R.id.edt_login);
		edtSenha = (EditText) findViewById(R.id.edt_senha);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	public void logar(View view) {
		new LoadingAsync().execute();
	}

	private class LoadingAsync extends AsyncTask<Void, Void, String> {

		private ProgressDialog progressDialog = new ProgressDialog(
				LoginActivity.this);

		@Override
		protected void onPreExecute() {
			progressDialog.setMessage("Loading...");
			progressDialog.show();
		}

		protected String doInBackground(Void... params) {
			String login = edtLogin.getText().toString();
			String senha = edtSenha.getText().toString();
			loginBO = new LoginBO(LoginActivity.this);			
			
			return loginBO.validateLogin(login, senha);
		}

		@Override
		protected void onPostExecute(String msg) {
			progressDialog.dismiss();
			if (msg == null) {
				Intent i = new Intent(LoginActivity.this,
						DashboardActivity.class);
				
				startActivity(i);
				finish();
			} else {
				// MensagemUtil.addMsg(LoginActivity.this, msg);
			}
		}

	}
}

package com.tarcisio.bo;

import android.R;
import android.content.Context;

public class LoginBO {

	private Context contexto;

	public LoginBO(Context contexto) {
		this.contexto = contexto;
	}

	public String validateLogin(String login, String senha) {
		
		
		if (login == null || login.equals("")) {
			return "Login é obrigatório";
		} else if (senha == null || senha.equals("")) {
			return "Senha é obrigatório";
		}
		return null;
	}
}

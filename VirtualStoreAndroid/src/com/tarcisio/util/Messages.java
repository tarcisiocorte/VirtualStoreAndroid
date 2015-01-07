package com.tarcisio.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;

/**
 * Method for rapid creation of messages
 * 
 * @param activity
 * @param msg
 */
public class Messages {
	public static void AddMessage(Activity activity, String message) {
		Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
	}

	/**
	 * Method to create message with "Ok" button
	 * 
	 * @param activity
	 * @param titulo
	 * @param msg
	 * @param icone
	 */
	public static void addMessageOk(Activity activity, String title,
			String msg, int icone) {
		AlertDialog.Builder builderDialog = new AlertDialog.Builder(activity);
		builderDialog.setTitle(title);
		builderDialog.setMessage(msg);
		builderDialog.setNeutralButton("Ok", null);
		builderDialog.setIcon(icone);
		builderDialog.show();
	}

	/**
	 * 
	 * Method to create message with message dialog with buttons yes or no
	 * 
	 * @param activity
	 * @param title
	 * @param msg
	 * @param icone
	 * @param listener
	 */
	public static void addMessageConfirm(Activity activity, String title,
			String msg, int icone, OnClickListener listener) {
		AlertDialog.Builder builderDialog = new AlertDialog.Builder(activity);
		builderDialog.setTitle(title);
		builderDialog.setMessage(msg);
		builderDialog.setPositiveButton("Sim", listener);
		builderDialog.setNegativeButton("Não", null);
		builderDialog.setIcon(icone);
		builderDialog.show();
	}

}

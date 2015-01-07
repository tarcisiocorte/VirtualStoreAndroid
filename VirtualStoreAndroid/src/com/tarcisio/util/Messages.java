package com.tarcisio.util;

import android.app.Activity;
import android.widget.Toast;

/**
 * Method for rapid creation of messages
 *  
 * @param activity
 * @param msg
 */
public class Messages {
	public static void AddMessage(Activity activity, String message) {
		Toast.makeText(activity, message, Toast.LENGTH_LONG);
	}
}

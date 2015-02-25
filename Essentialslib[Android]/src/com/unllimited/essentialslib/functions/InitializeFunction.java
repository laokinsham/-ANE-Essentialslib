/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.functions;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.Log;
import android.view.WindowManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;
import com.unllimited.essentialslib.EssentialslibExtension;
import com.unllimited.essentialslib.monitors.SettingsContentObserver;
import com.unllimited.essentialslib.receivers.AndroidlibReceiver;

public class InitializeFunction implements FREFunction
{
	public static final String TAG = "initialize";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject		result	= null;
		
		EssentialslibExtension.extensionContext	= context;
		EssentialslibExtension.activity			= context.getActivity();
		EssentialslibExtension.appContext			= EssentialslibExtension.activity.getApplicationContext();
		
		EssentialslibExtension.btAdapter			= BluetoothAdapter.getDefaultAdapter();
		
		EssentialslibExtension.mSettingsWatcher	= new SettingsContentObserver(new Handler());
		EssentialslibExtension.appContext.getContentResolver().registerContentObserver(
				System.CONTENT_URI, true, EssentialslibExtension.mSettingsWatcher);
		
		EssentialslibExtension.aManager	= (AudioManager)EssentialslibExtension.appContext.getSystemService(Context.AUDIO_SERVICE);
		
		EssentialslibExtension.activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		EssentialslibExtension.activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		
		EssentialslibExtension.intentFilter	= new IntentFilter();
		EssentialslibExtension.intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
		EssentialslibExtension.intentFilter.addAction(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
		EssentialslibExtension.intentFilter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
		EssentialslibExtension.intentFilter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED);
		EssentialslibExtension.intentFilter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
		EssentialslibExtension.intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
		EssentialslibExtension.intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
		EssentialslibExtension.intentFilter.addAction(Intent.ACTION_BATTERY_OKAY);
		
		EssentialslibExtension.broadcastReceiver	= new AndroidlibReceiver(EssentialslibExtension.appContext);
		
		EssentialslibExtension.registerBroadcast(EssentialslibExtension.broadcastReceiver, EssentialslibExtension.intentFilter);
		
		Log.i(TAG, "in init");
		EssentialslibExtension.notifyVolumeChange();
		
		try
		{
			result = FREObject.newObject(true);
		}
		catch (FREWrongThreadException e)
		{
		}
		catch (IllegalStateException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}

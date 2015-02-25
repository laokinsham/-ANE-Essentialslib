/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib;

import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
import com.unllimited.essentialslib.consts.BluetoothEvent;
import com.unllimited.essentialslib.consts.Consts;
import com.unllimited.essentialslib.monitors.SettingsContentObserver;
import com.unllimited.essentialslib.receivers.AndroidlibReceiver;
import com.unllimited.essentialslib.threads.ConnectThread;
import com.unllimited.essentialslib.threads.ConnectedThread;

public class EssentialslibExtension implements FREExtension
{
	public	static final String TAG	= "AndroidlibExtension";
	
	public	static FREContext				extensionContext;
	public	static Intent					batteryStatus;
	public	static Context					appContext;
	public	static Activity					activity;
	
	public	static BluetoothAdapter			btAdapter;
	public	static Set<BluetoothDevice>		btDevicesPaired;
	public	static BluetoothDevice			btSelected;
	public	static BluetoothSocket			btSocket;
	public	static int						btState;
	
	public	static ConnectThread 			btConnectThread;
	public	static ConnectedThread			btConnectedThread;
	
	public	static UUID						UUID_INSECURE	= UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
	public	static UUID						UUID_SECURE		= UUID.fromString("FA87C0D0-AFAC-11DE-8A39-0800200C9A66");
	public	static UUID						MY_UUID			= null;
	
	public	static AudioManager				aManager;
	
	
	public	static SettingsContentObserver	mSettingsWatcher;
    public	static AndroidlibReceiver		broadcastReceiver;
    
    public	static IntentFilter				intentFilter;
	
	public	static float					NO_VALUE			= (float)-1.0;
	public	static Float					lastSystemVolume	= NO_VALUE;
	
	public static void notifyVolumeChange()
	{
		Float			maxVolume		= Float.valueOf(aManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
		Float			systemVolume	= Float.valueOf(aManager.getStreamVolume(AudioManager.STREAM_MUSIC));
		
		if (systemVolume != lastSystemVolume)
		{
			lastSystemVolume	= systemVolume;
			
			Float flashVolume	= systemVolume / maxVolume;
			
			String volume		= String.valueOf(flashVolume);
			String eventName	= "volumeChanged";
			
			eventDispatcher(eventName, volume);
		}
	}
	
	public static int setVolume(double curVol)
	{
		int	value	= (int)NO_VALUE;
		int	maxVol	= aManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		curVol		*= maxVol;
		value		= (int)curVol;
		
		aManager.setStreamVolume(AudioManager.STREAM_MUSIC, value, 0);
		
		return value;
	}
	
	public static void showNotification(String message)
	{
		Intent intent = new Intent();
		PendingIntent pendingIntent = PendingIntent.getActivity(activity, 0, intent, 0);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
		
		builder.setSmallIcon(R.drawable.alert_alert);
		builder.setContentIntent(pendingIntent);
		builder.setAutoCancel(true);
		builder.setLargeIcon(BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_launcher));
		builder.setContentTitle("Aviso");
		builder.setContentText(message);
		builder.setSubText("Toque para ver mais detalhes");
		
		NotificationManager notificationManager = (NotificationManager)activity.getSystemService(Activity.NOTIFICATION_SERVICE);
		notificationManager.notify(1, builder.build());
	}
	
	public static void eventDispatcher(String str, String data) 
	{
		if (extensionContext != null)
			extensionContext.dispatchStatusEventAsync(str, data);
	}
	
	public static void showSettings(String value)
	{
		if (value == null || value == "")
			value	= android.provider.Settings.ACTION_SETTINGS;
		
		Intent settingIntent	= new Intent();
		settingIntent.setAction(value);
		EssentialslibExtension.activity.startActivity(settingIntent);
	}
	
	//BT Functions
	public static synchronized void setState(int state)
	{
		btState = state;
	}
	
	public static synchronized int getState()
	{
		return btState;
	}
	
	public static void BTgetPairedDevices()
	{
		if (btAdapter != null)
			btDevicesPaired = btAdapter.getBondedDevices();
	}
	
	public static synchronized void connect(BluetoothDevice device, boolean secure)
	{
		if (btState == Consts.STATE_CONNECTING)
		{
			if (btConnectThread != null)
			{
				btConnectThread.cancel();
				btConnectThread = null;
			}
		}
		
		// Cancel any thread currently running a connection
		if (btConnectedThread != null)
		{
			btConnectedThread.cancel();
			btConnectedThread = null;
		}
		
		toast("Connect-init", Toast.LENGTH_SHORT);
		btConnectThread = new ConnectThread(btSelected, secure);
		btConnectThread.start();
		
		eventDispatcher(BluetoothEvent.BLUETOOTH_DEVICE_CONNECTING, "");
		setState(Consts.STATE_CONNECTING);
	}
	
	public static synchronized void connected(BluetoothSocket socket, BluetoothDevice device)
	{
		//		if (D) 
		//			Log.d(TAG, "connected, Socket Type:" + socketType);
		
		// Cancel the thread that completed the connection
		vibrate(200);
		
		if (btConnectThread != null)
		{
			//btConnectThread.cancel();
			btConnectThread = null;
		}
		
		if (btConnectedThread != null)
		{
			btConnectedThread.cancel();
			btConnectedThread = null;
		}
		
		// Start the thread to manage the connection and perform transmissions
		btConnectedThread = new ConnectedThread(socket);
		btConnectedThread.start();
		
		String dataOut  = "INITIALIZATED\n";
		btConnectedThread.write(dataOut.getBytes());
		
		eventDispatcher(BluetoothEvent.BLUETOOTH_DEVICE_CONNECTED, "device connected: " + btSelected.getAddress());
		setState(Consts.STATE_CONNECTED);
	}
	
	public static synchronized void writeData(byte[] bytes)
	{
		if (btConnectedThread != null)
		{
			btConnectedThread.write(bytes);
			eventDispatcher(BluetoothEvent.BLUETOOTH_SEND_SUCCESS, "data sended to: " + btSelected.getAddress());
		}
	}
	
	public static synchronized void disconnect(BluetoothDevice device)
	{
		if (btState == Consts.STATE_CONNECTED)
		{
			if (btConnectedThread != null)
			{
				btConnectedThread.cancel();
				btConnectedThread = null;
			}
			
			eventDispatcher(BluetoothEvent.BLUETOOTH_DEVICE_DISCONNECTED, "device disconnected: " + btSelected.getAddress());
			
			btSelected	= null;
			setState(Consts.STATE_NONE);
		}
	}
	
	public static synchronized void closeAllConnections()
	{
		if (btConnectThread != null)
		{
			btConnectThread.cancel();
			btConnectThread = null;
		}
		
		if (btConnectedThread != null)
		{
			btConnectedThread.cancel();
			btConnectedThread = null;
		}
		
		btSelected	= null;
		
		eventDispatcher(BluetoothEvent.BLUETOOTH_DEVICE_DISCONNECTED, "");
		setState(Consts.STATE_NONE);
	}
	
	public static synchronized void toast(String message, int duration)
	{
		Toast.makeText(appContext, message, duration).show();
	}
	
	public static synchronized void vibrate(int duration)
	{
		Vibrator	vibrator	= (Vibrator)activity.getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(duration);
	}
	
	public static void registerBroadcast(BroadcastReceiver receiver, IntentFilter filter)
	{
		activity.registerReceiver(receiver, filter);
	}
	
	public static void unregisterBroadcast(BroadcastReceiver receiver)
	{
		activity.unregisterReceiver(receiver);
		receiver = null;
	}

    @Override
	public FREContext createContext(String arg0)
	{
		return new EssentialslibContext();
	}
	
	@Override
	public void dispose()
	{
		Log.d(TAG, "Extension disposed.");
		appContext.getContentResolver().unregisterContentObserver(mSettingsWatcher);
		unregisterBroadcast(EssentialslibExtension.broadcastReceiver);
		EssentialslibExtension.broadcastReceiver	= null;
		closeAllConnections();
		
		extensionContext	= null;
		activity			= null;
		batteryStatus		= null;
		appContext			= null;
		lastSystemVolume	= NO_VALUE;
		
		UUID_INSECURE		= null;
		UUID_SECURE			= null;
		
		EssentialslibExtension.activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	
	@Override
	public void initialize()
	{
		Log.d(TAG, "Extension initialized.");
	}
}

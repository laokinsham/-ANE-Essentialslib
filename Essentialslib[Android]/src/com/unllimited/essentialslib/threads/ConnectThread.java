/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.threads;

import java.io.IOException;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import com.unllimited.essentialslib.EssentialslibExtension;

public class ConnectThread extends Thread
{
	private final BluetoothSocket mSocket;
	//private final BluetoothDevice mDevice;
	
	public ConnectThread(BluetoothDevice device, boolean secure)
	{
		// Use a temporary object that is later assigned to mmSocket, because mmSocket is final
		//-------------------
		//remember check setPin function
		//-------------------
		
		BluetoothSocket	tmp	= null;
		
		// Get a BluetoothSocket to connect with the given BluetoothDevice
		try
		{
			// MY_UUID is the app's UUID string, also used by the server code
        	if( EssentialslibExtension.MY_UUID != null )
        	{
        		if (secure)
        			tmp = device.createRfcommSocketToServiceRecord(EssentialslibExtension.MY_UUID);
        		else
        			tmp = device.createInsecureRfcommSocketToServiceRecord(EssentialslibExtension.MY_UUID);
        	}
        	else
        	{
        		if (secure)
        			tmp = device.createRfcommSocketToServiceRecord(EssentialslibExtension.UUID_SECURE);
        		else
        			tmp = device.createInsecureRfcommSocketToServiceRecord(EssentialslibExtension.UUID_INSECURE);
        	}
		}
		catch (IOException e)
		{
		}
		
		mSocket = tmp;
	}
	
	public void run()
	{
		// Cancel discovery because it will slow down the connection
		EssentialslibExtension.btAdapter.cancelDiscovery();
		
		try
		{
			// Connect the device through the socket. This will block
			// until it succeeds or throws an exception
			mSocket.connect();
			
		}
		catch (IOException connectException)
		{
			// Unable to connect; close the socket and get out
			try
			{
				mSocket.close();
			}
			catch (IOException closeException)
			{
			}
			
			return;
		}
		
		EssentialslibExtension.connected(mSocket, EssentialslibExtension.btSelected);
	}
	
	/** Will cancel an in-progress connection, and close the socket */
	public void cancel()
	{
		try
		{
			mSocket.close();
		}
		catch (IOException e)
		{
		}
	}
}
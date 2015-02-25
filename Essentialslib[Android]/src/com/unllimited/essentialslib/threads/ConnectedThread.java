/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.threads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.bluetooth.BluetoothSocket;

import com.unllimited.essentialslib.EssentialslibExtension;
import com.unllimited.essentialslib.consts.BluetoothEvent;

public class ConnectedThread extends Thread
{
	private final BluetoothSocket	mmSocket;
	private final InputStream		mmInStream;
	private final OutputStream		mmOutStream;
	
	public ConnectedThread(BluetoothSocket socket)
	{
		mmSocket	= socket;
		
		InputStream		tmpIn	= null;
		OutputStream	tmpOut	= null;
		
		// Get the input and output streams, using temp objects because
		// member streams are final
		try
		{
			tmpIn	= socket.getInputStream();
			tmpOut	= socket.getOutputStream();
		}
		catch (IOException e)
		{
		}
		
		mmInStream	= tmpIn;
		mmOutStream	= tmpOut;
	}
	
	public void run()
	{
		byte[]		buffer	= new byte[1024]; // buffer store for the stream
		// int begin = 0;
		int			bytes = 0;
		String		message = "";
		
		// Keep listening to the InputStream until an exception occurs
		while (true)
		{
			try
			{
				//buffer	= new byte[1024];
				
				// Read from the InputStream
				bytes	= mmInStream.read(buffer);
				
				byte[]	readBuf	= (byte[]) buffer;
				String	strIn	= new String(readBuf, 0, bytes);
				
				message	= message.concat(strIn);
				
				//int	endOfLineIndex	= message.indexOf("\r\n");
				int	separator	= message.indexOf(";");
				
				while (separator == 0)
				{
					message		= message.substring(1, message.length() -1);
					separator	= message.indexOf(";");
				}
				
				if (separator > 0)
				{
					message	= message.substring(0, separator);
					
					EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_RECEIVE_DATA, message);
					EssentialslibExtension.vibrate(120);
					
					message	= "";
				}
			}
			catch (IOException e)
			{
				break;
			}
		}
	}
	
	/* Call this from the main activity to send data to the remote device */
	public void write(byte[] bytes)
	{
		try
		{
			mmOutStream.write(bytes);
			// mmOutStream.flush();
			EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_SEND_SUCCESS, "");
		}
		catch (IOException e)
		{
			EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_SEND_ERROR, e.toString());
		}
	}
	
	/* Call this from the main activity to shutdown the connection */
	public void cancel()
	{
		try
		{
			mmSocket.close();
		}
		catch (IOException e)
		{
		}
	}
}
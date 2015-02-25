/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.functions;

import java.util.UUID;

import android.bluetooth.BluetoothDevice;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unllimited.essentialslib.EssentialslibExtension;

public class BTConnectFunction implements FREFunction
{
	public static final String TAG	= "BTConnect";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject	result			= null;
		Boolean		value			= false;
		
		String		deviceAddr		= "";
	    boolean		secureConnect	= false;
	    String		customUUID		= null;
		
        if (EssentialslibExtension.btAdapter.isDiscovering())
        	EssentialslibExtension.btAdapter.cancelDiscovery();
		
		try
		{
			if( customUUID != "" && customUUID != "false" )
			{
				EssentialslibExtension.MY_UUID = UUID.fromString( customUUID );
			}
			else
			{
				EssentialslibExtension.MY_UUID = null;
			}
		}
		catch (Exception e)
		{
		}
		
        try
		{
			deviceAddr		= args[0].getAsString();
			secureConnect	= args[1].getAsBool();
			customUUID		= args[2].getAsString();
			
//			try
//			{
//				EssentialslibExtension.btSelected	= EssentialslibExtension.btAdapter.getRemoteDevice(deviceAddr);
//			}
//			catch (Exception e)
//			{
//				e.printStackTrace();
//				EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_DEVICE_CONNECT_ERROR, "");
//			}

			for (BluetoothDevice bDevice : EssentialslibExtension.btDevicesPaired)
			{
				if (bDevice.getAddress().equals(deviceAddr))
				{
					EssentialslibExtension.btSelected	= bDevice;
					value	= true;
					
					EssentialslibExtension.connect(EssentialslibExtension.btSelected, secureConnect);
				}
			}
		}
		catch (IllegalStateException e)
		{
			e.printStackTrace();
		}
		catch (FRETypeMismatchException e)
		{
			e.printStackTrace();
		}
		catch (FREInvalidObjectException e)
		{
			e.printStackTrace();
		}
		catch (FREWrongThreadException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			if (value && EssentialslibExtension.btSelected != null)
				result = FREObject.newObject(EssentialslibExtension.btSelected.getAddress());
			else
				result = FREObject.newObject("00:00:00:00:00:00");
		}
		catch (FREWrongThreadException e)
		{
			e.printStackTrace();
		}
		catch (IllegalStateException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}

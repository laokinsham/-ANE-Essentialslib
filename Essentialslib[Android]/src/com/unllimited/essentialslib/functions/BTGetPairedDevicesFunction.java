/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.functions;

import android.bluetooth.BluetoothDevice;

import com.adobe.fre.FREASErrorException;
import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRENoSuchNameException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREReadOnlyException;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unllimited.essentialslib.EssentialslibExtension;

public class BTGetPairedDevicesFunction implements FREFunction
{
	public static final String TAG = "BTGetPairedDevices";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREArray result = null;
		
		try
		{
			result = FREArray.newArray(0);
		}
		catch (FREASErrorException e)
		{
			e.printStackTrace();
		}
		catch (FREWrongThreadException e)
		{
			e.printStackTrace();
		}
		
		int index = 0;
		
		EssentialslibExtension.BTgetPairedDevices();
		
		for (BluetoothDevice bt	: EssentialslibExtension.btDevicesPaired)
		{
			FREObject curDevice;
			
			try
			{
				curDevice	= FREObject.newObject("com.unllimited.essentialslib.BluetoothDevice", null);
				curDevice.setProperty("address",		FREObject.newObject(bt.getAddress()));
				curDevice.setProperty("boundState",		FREObject.newObject(bt.getBondState()));
				curDevice.setProperty("name",			FREObject.newObject(bt.getName()));
				result.setObjectAt(index, curDevice);
				index++;
			}
			catch (FREWrongThreadException e)
			{
				e.printStackTrace();
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
			catch (FREASErrorException e)
			{
				e.printStackTrace();
			}
			catch (FRENoSuchNameException e)
			{
				e.printStackTrace();
			} catch (FREReadOnlyException e)
			{
				e.printStackTrace();
			}
		}
		
		return result;
	}
}

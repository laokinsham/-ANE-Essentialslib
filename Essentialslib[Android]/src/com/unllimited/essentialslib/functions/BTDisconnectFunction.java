/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unllimited.essentialslib.EssentialslibExtension;

public class BTDisconnectFunction implements FREFunction
{
	public static final String TAG	= "BTConnect";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject	result			= null;
		
		String		deviceAddr		= "";
		
        if (EssentialslibExtension.btAdapter.isDiscovering())
        	EssentialslibExtension.btAdapter.cancelDiscovery();
		
        try
		{
			deviceAddr		= args[0].getAsString();
			EssentialslibExtension.disconnect(EssentialslibExtension.btAdapter.getRemoteDevice(deviceAddr));
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
			if (EssentialslibExtension.btSelected == null)
				result = FREObject.newObject("00:00:00:00:00:00");
			else
				result = FREObject.newObject(EssentialslibExtension.btSelected.getAddress());
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

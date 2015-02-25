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

public class NotificationFunction implements FREFunction
{
	
	public static final String TAG = "notify";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject result = null;
		
		String message	= "";
		
		try
		{
			message	= args[0].getAsString();
		} catch (IllegalStateException e)
		{
			e.printStackTrace();
		} catch (FRETypeMismatchException e)
		{
			e.printStackTrace();
		} catch (FREInvalidObjectException e)
		{
			e.printStackTrace();
		} catch (FREWrongThreadException e)
		{
			e.printStackTrace();
		}
		
		EssentialslibExtension.showNotification(message);
		
		try
		{
			result = FREObject.newObject(message);
		}
		catch (FREWrongThreadException e) {} catch (IllegalStateException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
}

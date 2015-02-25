/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;

public class IsSupportedFunction implements FREFunction
{
	public static final String TAG = "isSupported";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject result = null;
		
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

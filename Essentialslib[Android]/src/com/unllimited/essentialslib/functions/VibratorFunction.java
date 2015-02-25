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

public class VibratorFunction implements FREFunction
{
	public static final String TAG = "vibrate";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject	result		= null;
		int			duration	= 500;
		
		try
		{
			duration	= args[0].getAsInt();
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
		
		EssentialslibExtension.vibrate(duration);
		
		return result;
	}
}

package com.unllimited.essentialslib.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unllimited.essentialslib.EssentialslibExtension;

public class ToastFunction implements FREFunction
{
	public static final String TAG = "toast";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject result = null;
		
		String message = "";
		
		try
		{
			message = args[0].getAsString();
			EssentialslibExtension.toast(message, 1);
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
			result = FREObject.newObject(message);
		}
		catch (FREWrongThreadException e) {} catch (IllegalStateException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
}

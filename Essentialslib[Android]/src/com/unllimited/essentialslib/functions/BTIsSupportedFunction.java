package com.unllimited.essentialslib.functions;

import com.adobe.fre.FREASErrorException;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRENoSuchNameException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREReadOnlyException;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unllimited.essentialslib.EssentialslibExtension;

public class BTIsSupportedFunction implements FREFunction
{
	public static final String TAG = "BTIsSupported";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject result = null;
		
		try
		{
			if (EssentialslibExtension.btAdapter != null)
			{
				result = FREObject.newObject("Object", null);
				result.setProperty("supported",			FREObject.newObject(true));
				result.setProperty("address",			FREObject.newObject(EssentialslibExtension.btAdapter.getAddress()));
				result.setProperty("name",				FREObject.newObject(EssentialslibExtension.btAdapter.getName()));
				result.setProperty("state",				FREObject.newObject(EssentialslibExtension.btAdapter.getState()));
				result.setProperty("isDiscoverable",	FREObject.newObject(EssentialslibExtension.btAdapter.isDiscovering()));
				result.setProperty("isEnabled",			FREObject.newObject(EssentialslibExtension.btAdapter.isEnabled()));
			}
			else
			{
				result = FREObject.newObject("Object", null);
				result.setProperty("supported",			FREObject.newObject(false));
				result.setProperty("address",			FREObject.newObject(""));
				result.setProperty("name",				FREObject.newObject(""));
				result.setProperty("state",				FREObject.newObject(""));
				result.setProperty("isDiscoverable",	FREObject.newObject(""));
				result.setProperty("isEnabled",			FREObject.newObject(""));
			}
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
		
		return result;
	}
}

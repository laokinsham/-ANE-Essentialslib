/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;
import com.unllimited.essentialslib.EssentialslibExtension;

public class BTDisableFunction implements FREFunction
{
	public static final String TAG = "BTDisable";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject result = null;
		
		if (EssentialslibExtension.btAdapter.isEnabled())
			EssentialslibExtension.btAdapter.disable();
		
		try
		{
			result = FREObject.newObject(!EssentialslibExtension.btAdapter.isEnabled());
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

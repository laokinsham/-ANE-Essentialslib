/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.functions;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREWrongThreadException;
import com.unllimited.essentialslib.EssentialslibExtension;

public class SetVolumeFunction implements FREFunction
{
	public static final String TAG = "batteryHealth";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject result = null;
		
		double	curVol	= 1;
		
		try
		{
			curVol = args[0].getAsDouble();
		}
		catch (Exception e)
		{
			
		}
		
		try
		{
			result = FREObject.newObject(EssentialslibExtension.setVolume(curVol));
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

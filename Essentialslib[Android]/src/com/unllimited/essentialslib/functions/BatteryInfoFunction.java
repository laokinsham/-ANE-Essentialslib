/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.functions;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

import com.adobe.fre.FREASErrorException;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRENoSuchNameException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FREReadOnlyException;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unllimited.essentialslib.EssentialslibExtension;;

public class BatteryInfoFunction implements FREFunction
{
	public static final String TAG = "BTIsSupported";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject result = null;
		
		IntentFilter	intentFilter	= new IntentFilter();
		
		intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
		intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
		intentFilter.addAction(Intent.ACTION_BATTERY_OKAY);
		
		EssentialslibExtension.batteryStatus		= EssentialslibExtension.activity.registerReceiver(null, intentFilter);
		
		int		batteryHealth		= EssentialslibExtension.batteryStatus.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);
		int		batteryPlugged		= EssentialslibExtension.batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
		int		batteryStatus		= EssentialslibExtension.batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
		int		batteryTemperature	= EssentialslibExtension.batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
		int		batteryVoltage		= EssentialslibExtension.batteryStatus.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
		int		batteryLevel		= EssentialslibExtension.batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
		int		batteryScale		= EssentialslibExtension.batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
		
		int		batteryPercent		= (int)(batteryLevel / (float)batteryScale * 100);
		
		try
		{
			if (EssentialslibExtension.btAdapter != null)
			{
				result = FREObject.newObject("com.unllimited.essentialslib.BatteryObject", null);
				result.setProperty("health",		FREObject.newObject(batteryHealth));
				result.setProperty("plugged",		FREObject.newObject(batteryPlugged));
				result.setProperty("status",		FREObject.newObject(batteryStatus));
				result.setProperty("temperature",	FREObject.newObject(batteryTemperature));
				result.setProperty("voltage",		FREObject.newObject(batteryVoltage));
				result.setProperty("level",			FREObject.newObject(batteryPercent));
			}
			else
			{
				result = FREObject.newObject("com.unllimited.essentialslib.BatteryObject", null);
				result.setProperty("health",		FREObject.newObject(0));
				result.setProperty("plugged",		FREObject.newObject(0));
				result.setProperty("status",		FREObject.newObject(0));
				result.setProperty("temperature",	FREObject.newObject(0));
				result.setProperty("voltage",		FREObject.newObject(0));
				result.setProperty("level",			FREObject.newObject(0));
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

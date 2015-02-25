/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.unllimited.essentialslib.functions.BTConnectFunction;
import com.unllimited.essentialslib.functions.BTDisableFunction;
import com.unllimited.essentialslib.functions.BTDisconnectFunction;
import com.unllimited.essentialslib.functions.BTEnableFunction;
import com.unllimited.essentialslib.functions.BTGetPairedDevicesFunction;
import com.unllimited.essentialslib.functions.BTIsSupportedFunction;
import com.unllimited.essentialslib.functions.BTScanForNewDevicesFunction;
import com.unllimited.essentialslib.functions.BTWriteFunction;
import com.unllimited.essentialslib.functions.BatteryInfoFunction;
import com.unllimited.essentialslib.functions.InitializeFunction;
import com.unllimited.essentialslib.functions.IsSupportedFunction;
import com.unllimited.essentialslib.functions.NotificationFunction;
import com.unllimited.essentialslib.functions.SetVolumeFunction;
import com.unllimited.essentialslib.functions.ShowSettingsFunction;
import com.unllimited.essentialslib.functions.ToastFunction;
import com.unllimited.essentialslib.functions.VibratorFunction;

public class EssentialslibContext extends FREContext
{
	@Override
	public void dispose()
	{
		
	}
	
	@Override
	public Map<String, FREFunction> getFunctions()
	{
		Map<String, FREFunction>	map	= new HashMap<String, FREFunction>();
		
		//IsSupported Function
		map.put("isSupported",			new IsSupportedFunction());
		
		//Initializer
		map.put("initialize",			new InitializeFunction());
		
		//Battery Functions
		map.put("batteryInfo",			new BatteryInfoFunction());
		
		//BT Functions
		map.put("BTIsSupported",		new BTIsSupportedFunction());
		map.put("BTDisable",			new BTDisableFunction());
		map.put("BTEnable",				new BTEnableFunction());
		map.put("BTGetPairedDevices",	new BTGetPairedDevicesFunction());
		map.put("BTScanForNewDevices",	new BTScanForNewDevicesFunction());
		map.put("BTConnect",			new BTConnectFunction());
		map.put("BTDisconnect",			new BTDisconnectFunction());
		map.put("BTWrite",				new BTWriteFunction());
		
		//Misc Functions
		map.put("setVolume",			new SetVolumeFunction());
		map.put("showNotification",		new NotificationFunction());
		map.put("showSettings",			new ShowSettingsFunction());
		map.put("showToast",			new ToastFunction());
		map.put("vibrate",				new VibratorFunction());
		
		return map;
	}
}

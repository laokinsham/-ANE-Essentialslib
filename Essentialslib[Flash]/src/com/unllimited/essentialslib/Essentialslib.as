////////////////////////////////////////////////////////////////////////////////
//
//  laokinsham
//  http://www.unllimited.com
//  This class is part of the whitelib class library
//  All Rights Reserved.
//
//  NOTICE: Is permited you to use, modify, and distribute this file
//  since that the developer name and this code block be preserved inside.
//
////////////////////////////////////////////////////////////////////////////////

package com.unllimited.essentialslib
{
	import com.unllimited.essentialslib.consts.android.SettingsConstants;
	import com.unllimited.essentialslib.events.EssentialslibEvent;
	
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	[Event(name="BLUETOOTH_ANE_NOT_SUPPORTED",				type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_ANE_INITIALIZED",				type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_TURNING_ON",						type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_ON",								type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_TURNING_OFF",					type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_OFF",							type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_ENABLED",						type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DISABLED",						type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DISCOVERING_STARTED",			type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DISCOVERING_FINISHED",			type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DEVICE_FOUND",					type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_VISIBLE",						type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_HIDDEN_CONNECTABLE",				type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_HIDDEN",							type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DEVICE_CONNECTING",				type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DEVICE_CONNECTED",				type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DEVICE_CONNECT_ERROR",			type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DEVICE_DISCONNECT_REQUESTED",	type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DEVICE_DISCONNECTED",			type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DEVICE_CONNECTION_FAILED",		type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DEVICE_BONDING",					type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_DEVICE_BONDED",					type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_SEND_ERROR",						type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_SEND_BYTEARRAY_READ_ERROR",		type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_SEND_SUCCESS",					type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_SERVERMODE",						type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_ACCEPT_CONNECTION",				type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	[Event(name="BLUETOOTH_RECEIVE_DATA",					type="com.unllimited.essentialslib.events.EssentialslibEvent")]
	
	public class Essentialslib extends EventDispatcher
	{
		private static var arraySplitter:String = "|&|";
		
		private var	extensionContext	: ExtensionContext;
		private var _initialized		: Boolean;
		private var	_connected			: Boolean	= false;
		
		public function Essentialslib(target:IEventDispatcher=null)
		{
			initialize();
			super(target);
		}
		
		public function initialize():Boolean
		{
			if (!_initialized)
			{
				trace("[Essentialslib] Initalizing Extension...");
				extensionContext = ExtensionContext.createExtensionContext("com.unllimited.essentialslib", null);
				
				if (extensionContext)
				{
					extensionContext.addEventListener(StatusEvent.STATUS, contextEventHandler);
					_initialized = extensionContext.call("initialize");
				}
			}
			else
			{
				trace("[Essentialslib] Initalization Problem...");
				return false;
			}
			
			return _initialized;
		}
		
		public function dispose():Boolean
		{
			if (!_initialized || !extensionContext)
			{
				trace("[Essentialslib] Error.  ANE Already in a disposed or failed state...");
				return false;
			}
			
			/*if (false && _connected)
				BTDisconnect("");*/
			
			trace("[Essentialslib] Unloading ANE...");
			
			if (extensionContext)
				_initialized = false;
			
			extensionContext.dispose();
			
			return !_initialized
		}
		
		public function isSupported():Boolean
		{
			if (initialized)
				return extensionContext.call("isSupported");
			else
				return false;
		}
		
		public function setVolume(value:Number=1):Number
		{
			if (initialized)
				return extensionContext.call("setVolume", value) as Number;
			else
				return NaN;
		}
		
		public function vibrate(duration:Number=500):void
		{
			if (initialized)
				extensionContext.call("vibrate", duration);
		}
		
		public function showNotification(message:String):String
		{
			if (initialized)
				return extensionContext.call("showNotification", message) as String;
			else
				return null;
		}
		
		public function showToast(message:String):String
		{
			if (initialized)
				return extensionContext.call("showToast", message) as String;
			else
				return null;
		}
		
		public function showSettings(value:String	= "android.settings.SETTINGS"):String
		{
			if (initialized)
				return extensionContext.call("showSettings", value) as String;
			else
				return null;
		}
		
		//Bluetooth Functions
		public function BTIsSupported():Object
		{
			if (initialized)
				return extensionContext.call("BTIsSupported");
			else
				return null;
		}
		
		public function BTEnable():Boolean
		{
			if (initialized)
				return extensionContext.call("BTEnable");
			else
				return false;
		}
		
		public function BTDisable():Boolean
		{
			if (initialized)
			{
				_connected	= false;
				return extensionContext.call("BTDisable");
			}
			else
				return false;
		}
		
		public function BTGetPairedDevices():Array
		{
			if (initialized)
				return extensionContext.call("BTGetPairedDevices") as Array;
			else
				return null;
		}
		
		public function BTConnect(deviceAddr	: String, 
								  secure		: Boolean	= false, 
								  customUUID	: String	= "00001101-0000-1000-8000-00805F9B34FB"):String
		{
			var result	: String	= null;
			
			if (!deviceAddr)
				return null;
			
			result	= extensionContext.call("BTConnect", deviceAddr, secure, customUUID) as String;
			
			if (result)
			{
				_connected	= true;
				dispatchEvent(new Event("connectedChange"));
				trace("[Essentialslib] Connected at: " + deviceAddr);
			}
			
			return result;
		}
		
		public function BTDisconnect(deviceAddr	: String):Boolean
		{
			var result	: Boolean;
			
			if (!deviceAddr || !connected)
				return false;
			
			result		= extensionContext.call("BTDisconnect", deviceAddr);
			
			if (result)
			{
				_connected	= false;
				dispatchEvent(new Event("connectedChange"));
			}
			
			trace("[Essentialslib] Closing success = " + result.toString());
			
			return result;
		}
		
		public function BTWrite(message	: String, charset : String = "ISO-8859-1"):Boolean
		{
			var result	: Boolean;
			
			if (!message || !connected)
				return false;
			
			if (!charset || charset == "")
				charset = "ISO-8859-1";
			
			extensionContext.call("BTWrite", message, charset);
			
			trace("[Essentialslib] + [" + charset + "] Message sent: " + message);
			
			return result;
		}
		
		//Battery Functions
		public function batteryInfo():BatteryObject
		{
			if (initialized)
				return extensionContext.call("batteryInfo") as BatteryObject;
			else
				return null;
		}
		
		//Extension Functions
		public function get initialized():Boolean
		{
			return _initialized;
		}
		
		[Bindable(event="connectedChange")]
		public function get connected():Boolean
		{
			return _connected;
		}
		
		private function contextEventHandler(event:StatusEvent):void
		{
			switch(event.code)
			{
				case EssentialslibEvent.BLUETOOTH_ANE_NOT_SUPPORTED:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_ANE_NOT_SUPPORTED));
					break;
				case EssentialslibEvent.BLUETOOTH_ANE_INITIALIZED:
					/*var data:Array = parseLevelData(event.level);
					localDeviceName = data[0];
					localDeviceAddress = data[1];*/
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_ANE_INITIALIZED));
					break;
				case EssentialslibEvent.BLUETOOTH_TURNING_ON:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_TURNING_ON));
					break;
				case EssentialslibEvent.BLUETOOTH_TURNING_OFF:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_TURNING_OFF));
					break;
				case EssentialslibEvent.BLUETOOTH_ON:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_ON));
					break;
				case EssentialslibEvent.BLUETOOTH_OFF:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_OFF));
					break;
				case EssentialslibEvent.BLUETOOTH_VISIBLE:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_VISIBLE));
					break;
				case EssentialslibEvent.BLUETOOTH_HIDDEN:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_HIDDEN));
					break;
				case EssentialslibEvent.BLUETOOTH_HIDDEN_CONNECTABLE:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_HIDDEN_CONNECTABLE));
					break;
				case EssentialslibEvent.BLUETOOTH_DISCOVERING_STARTED:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_DISCOVERING_STARTED));
					break;
				case EssentialslibEvent.BLUETOOTH_DISCOVERING_FINISHED:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_DISCOVERING_FINISHED));
					break;
				case EssentialslibEvent.BLUETOOTH_DEVICE_FOUND:
					// Returns new device
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_DEVICE_FOUND));
					break;
				case EssentialslibEvent.BLUETOOTH_DEVICE_CONNECT_ERROR:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_DEVICE_CONNECT_ERROR));
					break;
				case EssentialslibEvent.BLUETOOTH_DEVICE_CONNECTED:					
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_DEVICE_CONNECTED));
					break;
				case EssentialslibEvent.BLUETOOTH_DEVICE_CONNECTING:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_DEVICE_CONNECTING));
					break;
				case EssentialslibEvent.BLUETOOTH_DEVICE_DISCONNECTED:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_DEVICE_DISCONNECTED));
					break;
				case EssentialslibEvent.BLUETOOTH_SERVERMODE:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_SERVERMODE));
					break;
				case EssentialslibEvent.BLUETOOTH_DEVICE_BONDED:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_DEVICE_BONDED));
					break;
				case EssentialslibEvent.BLUETOOTH_DEVICE_BONDING:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_DEVICE_BONDING));
					break;
				case EssentialslibEvent.BLUETOOTH_RECEIVE_DATA:
					this.dispatchEvent(new EssentialslibEvent(EssentialslibEvent.BLUETOOTH_RECEIVE_DATA, event.level));
					break;
			}
		}
		
		private function parseLevelData(str:String):Array
		{
			return str.split(arraySplitter);
		}
	}
}
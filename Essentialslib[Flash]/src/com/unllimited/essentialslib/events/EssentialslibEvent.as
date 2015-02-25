package com.unllimited.essentialslib.events
{
	import flash.events.Event;
	
	public class EssentialslibEvent extends Event
	{
		public static var BLUETOOTH_ANE_NOT_SUPPORTED: String = "BLUETOOTH_ANE_NOT_SUPPORTED";
		public static var BLUETOOTH_ANE_INITIALIZED: String = "BLUETOOTH_ANE_INITIALIZED";
		
		public static var BLUETOOTH_TURNING_ON: String = "BLUETOOTH_TURNING_ON";
		public static var BLUETOOTH_ON: String = "BLUETOOTH_ON";
		public static var BLUETOOTH_TURNING_OFF: String = "BLUETOOTH_TURNING_OFF";
		public static var BLUETOOTH_OFF: String = "BLUETOOTH_OFF";
		
		public static var BLUETOOTH_ENABLED: String = "BLUETOOTH_ENABLED";
		public static var BLUETOOTH_DISABLED: String = "BLUETOOTH_DISABLED";
		
		public static var BLUETOOTH_DISCOVERING_STARTED: String = "BLUETOOTH_DISCOVERY_STARTED";
		public static var BLUETOOTH_DISCOVERING_FINISHED: String = "BLUETOOTH_DISCOVERY_FINISHED";
		public static var BLUETOOTH_DEVICE_FOUND: String = "BLUETOOTH_DEVICE_FOUND";
		
		public static var BLUETOOTH_VISIBLE: String = "BLUETOOTH_VISIBLE";
		public static var BLUETOOTH_HIDDEN_CONNECTABLE: String = "BLUETOOTH_HIDDEN_CONNECTABLE";
		public static var BLUETOOTH_HIDDEN: String = "BLUETOOTH_HIDDEN";
		
		public static var BLUETOOTH_DEVICE_CONNECTING: String = "BLUETOOTH_DEVICE_CONNECTING";
		public static var BLUETOOTH_DEVICE_CONNECTED: String = "BLUETOOTH_DEVICE_CONNECTED";
		public static var BLUETOOTH_DEVICE_CONNECT_ERROR: String = "BLUETOOTH_DEVICE_CONNECT_ERROR";
		public static var BLUETOOTH_DEVICE_DISCONNECT_REQUESTED: String = "BLUETOOTH_DEVICE_DISCONNECT_REQUESTED";
		public static var BLUETOOTH_DEVICE_DISCONNECTED: String = "BLUETOOTH_DEVICE_DISCONNECTED";
		public static var BLUETOOTH_DEVICE_CONNECTION_FAILED: String = "BLUETOOTH_DEVICE_CONNECTION_FAILED";
		
		public static var BLUETOOTH_DEVICE_BONDING: String = "BLUETOOTH_DEVICE_BONDING";
		public static var BLUETOOTH_DEVICE_BONDED: String = "BLUETOOTH_DEVICE_BONDED";
		
		// Dispatched when streamout throws exception when calling write - iow. unable to send data
		public static var BLUETOOTH_SEND_ERROR: String = "BLUETOOTH_SEND_ERROR";
		// Dispatched when bytearray from as3 could not be read. It is dispatched before write method
		public static var BLUETOOTH_SEND_BYTEARRAY_READ_ERROR: String = "BLUETOOTH_SEND_BYTEARRAY_READ_ERROR";
		// Dispatched when streamout write method doesnt throw exceptions
		public static var BLUETOOTH_SEND_SUCCESS: String = "BLUETOOTH_SEND_SUCCESS";
		
		public static var BLUETOOTH_SERVERMODE: String = "BLUETOOTH_SERVERMODE";
		public static var BLUETOOTH_ACCEPT_CONNECTION: String = "BLUETOOTH_ACCEPT_CONNECTION";
		
		// THIS IS JUST USED WITH AIR LIB SO AIR LIB CAN GET THE DATA BEFORE NOTICING USER ANYTHING
		public static var BLUETOOTH_RECEIVE_DATA: String = "BLUETOOTH_RECEIVE_DATA";

		public var data:Object;
		
		public function EssentialslibEvent(type:String, data:Object=null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			
			this.data	= data;
		}
	}
}
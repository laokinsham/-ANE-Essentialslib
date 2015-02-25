/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.consts;

public class BluetoothEvent
{
	public static final String BLUETOOTH_ANE_NOT_SUPPORTED = "BLUETOOTH_ANE_NOT_SUPPORTED";
	public static final String BLUETOOTH_ANE_INITIALIZED = "BLUETOOTH_ANE_INITIALIZED";
	
	public static final String BLUETOOTH_TURNING_ON = "BLUETOOTH_TURNING_ON";
	public static final String BLUETOOTH_ON = "BLUETOOTH_ON";
	public static final String BLUETOOTH_TURNING_OFF = "BLUETOOTH_TURNING_OFF";
	public static final String BLUETOOTH_OFF = "BLUETOOTH_OFF";
	
	//public static final String BLUETOOTH_ENABLED = "BLUETOOTH_ENABLED";
	//public static final String BLUETOOTH_DISABLED = "BLUETOOTH_DISABLED";
	
	public static final String BLUETOOTH_DISCOVERING_STARTED = "BLUETOOTH_DISCOVERY_STARTED";
	public static final String BLUETOOTH_DISCOVERING_FINISHED = "BLUETOOTH_DISCOVERY_FINISHED";
	public static final String BLUETOOTH_DEVICE_FOUND = "BLUETOOTH_DEVICE_FOUND";
	
	public static final String BLUETOOTH_VISIBLE = "BLUETOOTH_VISIBLE";
	public static final String BLUETOOTH_HIDDEN_CONNECTABLE = "BLUETOOTH_HIDDEN_CONNECTABLE";
	public static final String BLUETOOTH_HIDDEN = "BLUETOOTH_HIDDEN";
	
	public static final String BLUETOOTH_DEVICE_CONNECTING = "BLUETOOTH_DEVICE_CONNECTING";
	public static final String BLUETOOTH_DEVICE_CONNECTED = "BLUETOOTH_DEVICE_CONNECTED";
	public static final String BLUETOOTH_DEVICE_CONNECT_ERROR = "BLUETOOTH_DEVICE_CONNECT_ERROR";
	public static final String BLUETOOTH_DEVICE_DISCONNECT_REQUESTED = "BLUETOOTH_DEVICE_DISCONNECT_REQUESTED";
	public static final String BLUETOOTH_DEVICE_DISCONNECTED = "BLUETOOTH_DEVICE_DISCONNECTED";
	public static final String BLUETOOTH_DEVICE_CONNECTION_FAILED = "BLUETOOTH_DEVICE_CONNECTION_FAILED";
	
	public static final String BLUETOOTH_DEVICE_BONDING = "BLUETOOTH_DEVICE_BONDING";
	public static final String BLUETOOTH_DEVICE_BONDED = "BLUETOOTH_DEVICE_BONDED";
	
	// Dispatched when streamout throws exception when calling write - iow. unable to send data
	public static final String BLUETOOTH_SEND_ERROR = "BLUETOOTH_SEND_ERROR";
	// Dispatched when bytearray from as3 could not be read. It is dispatched before write method
	public static final String BLUETOOTH_SEND_BYTEARRAY_READ_ERROR = "BLUETOOTH_SEND_BYTEARRAY_READ_ERROR";
	// Dispatched when streamout write method doesnt throw exceptions
	public static final String BLUETOOTH_SEND_SUCCESS = "BLUETOOTH_SEND_SUCCESS";
	
	public static final String BLUETOOTH_SERVERMODE = "BLUETOOTH_SERVERMODE";
	public static final String BLUETOOTH_ACCEPT_CONNECTION = "BLUETOOTH_ACCEPT_CONNECTION";
	
	// THIS IS JUST USED WITH AIR LIB SO AIR LIB CAN GET THE DATA BEFORE NOTICING USER ANYTHING
	public static final String BLUETOOTH_RECEIVE_DATA = "BLUETOOTH_RECEIVE_DATA";
}

package com.unllimited.essentialslib.receivers;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.unllimited.essentialslib.EssentialslibExtension;
import com.unllimited.essentialslib.consts.BluetoothEvent;

public class AndroidlibReceiver extends BroadcastReceiver
{
	public Context extensionContext;
	
	public AndroidlibReceiver(Context context)
	{
		extensionContext = context;
	}
	
	@Override
	public void onReceive(Context context, Intent intent)
	{
		String action = intent.getAction();
		
		if (BluetoothAdapter.ACTION_STATE_CHANGED.equals(action))
		{
			final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
			
			switch (state)
			{
				case BluetoothAdapter.STATE_TURNING_OFF:
					EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_TURNING_OFF, "");
					break;
				case BluetoothAdapter.STATE_OFF:
					EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_OFF, "");
					break;
				case BluetoothAdapter.STATE_TURNING_ON:
					EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_TURNING_ON, "");
					break;
				case BluetoothAdapter.STATE_ON:
					EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_ON, "");
					break;
			}
		}
		else if (BluetoothAdapter.ACTION_SCAN_MODE_CHANGED.equals(action))
		{
			final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE, BluetoothAdapter.ERROR);
			
			switch (state)
			{
				case BluetoothAdapter.SCAN_MODE_NONE:
					EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_HIDDEN, "");
					break;
				case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
					EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_HIDDEN_CONNECTABLE, "");
					break;
				case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
					EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_VISIBLE, "");
					break;
			}
		}
		else if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action))
		{
			final int state = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, -1);
			
			switch (state)
			{
				case BluetoothDevice.BOND_BONDED:
					BluetoothDevice bt = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
					EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_DEVICE_BONDED,
							bt.getAddress() + " - " + bt.getBondState());
					break;
				case BluetoothDevice.BOND_BONDING:
					EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_DEVICE_BONDING, "");
					break;
			}
		}
		else if (BluetoothDevice.ACTION_ACL_DISCONNECT_REQUESTED.equals(action))
		{
			EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_DEVICE_DISCONNECT_REQUESTED, "");
		}
		else if (BluetoothDevice.ACTION_ACL_DISCONNECTED.equals(action))
		{
			EssentialslibExtension.eventDispatcher(BluetoothEvent.BLUETOOTH_DEVICE_DISCONNECTED, "");
		}
		else if (Intent.ACTION_BATTERY_CHANGED.equals(action))
		{
			EssentialslibExtension.eventDispatcher("batteryChanged", "");
		}
	}
}

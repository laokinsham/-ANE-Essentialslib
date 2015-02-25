package com.unllimited.essentialslib
{
	public class BluetoothDevice
	{
		public	var name			: String	= "";
		public	var address			: String	= "";
		public	var boundState		: int		= 0;
		
		public function BluetoothDevice(name:String="", address:String="", boundState:int=0)
		{
			this.name			= name;
			this.address		= address;
			this.boundState		= boundState;
		}
	}
}
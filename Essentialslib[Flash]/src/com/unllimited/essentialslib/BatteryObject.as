package com.unllimited.essentialslib
{
	public class BatteryObject
	{
		public	var health			: int		= 0;
		public	var plugged			: int		= 0;
		public	var status			: int		= 0;
		public	var temperature		: int		= 0;
		public	var voltage			: int		= 0;
		public	var level			: Number	= 0;
		
		public function BatteryObject(health:int=0, plugged:int=0, status:int=0, temperature:int=0, 
									  voltage:int=0, level:Number=0)
		{
			this.health			= health;
			this.plugged		= plugged;
			this.status			= status;
			this.temperature	= temperature;
			this.voltage		= voltage;
			this.level			= level;
		}
	}
}
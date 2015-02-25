// ActionScript file
package com.unllimited.essentialslib.consts.android
{
	/**
	 * Consts for open settings
	 * @author laokinsham
	 */
	public class BatteryConsts
	{
		// values for "status" field in the ACTION_BATTERY_CHANGED Intent
		public static var BATTERY_STATUS_UNKNOWN:int = 1;
		public static var BATTERY_STATUS_CHARGING:int = 2;
		public static var BATTERY_STATUS_DISCHARGING:int = 3;
		public static var BATTERY_STATUS_NOT_CHARGING:int = 4;
		public static var BATTERY_STATUS_FULL:int = 5;
		
		// values for "health" field in the ACTION_BATTERY_CHANGED Intent
		public static var BATTERY_HEALTH_UNKNOWN:int = 1;
		public static var BATTERY_HEALTH_GOOD:int = 2;
		public static var BATTERY_HEALTH_OVERHEAT:int = 3;
		public static var BATTERY_HEALTH_DEAD:int = 4;
		public static var BATTERY_HEALTH_OVER_VOLTAGE:int = 5;
		public static var BATTERY_HEALTH_UNSPECIFIED_FAILURE:int = 6;
		public static var BATTERY_HEALTH_COLD:int = 7;
		
		// values of the "plugged" field in the ACTION_BATTERY_CHANGED intent.
		// These must be powers of 2.
		/** Power source is an AC charger. */
		public static var BATTERY_PLUGGED_AC:int = 1;
		/** Power source is a USB port. */
		public static var BATTERY_PLUGGED_USB:int = 2;
		/** Power source is wireless. */
		public static var BATTERY_PLUGGED_WIRELESS:int = 4;
		
		/*
		* Battery property identifiers.  These must match the values in
		* frameworks/native/include/batteryservice/BatteryService.h
		*/
		/** Battery capacity in microampere-hours, as an integer. */
		public static var BATTERY_PROPERTY_CHARGE_COUNTER:int = 1;
		
		/**
		 * Instantaneous battery current in microamperes, as an integer.  Positive
		 * values indicate net current entering the battery from a charge source,
		 * negative values indicate net current discharging from the battery.
		 */
		public static var BATTERY_PROPERTY_CURRENT_NOW:int = 2;
		
		/**
		 * Average battery current in microamperes, as an integer.  Positive
		 * values indicate net current entering the battery from a charge source,
		 * negative values indicate net current discharging from the battery.
		 * The time period over which the average is computed may depend on the
		 * fuel gauge hardware and its configuration.
		 */
		public static var BATTERY_PROPERTY_CURRENT_AVERAGE:int = 3;
		
		/**
		 * Remaining battery capacity as an integer percentage of total capacity
		 * (with no fractional part).
		 */
		public static var BATTERY_PROPERTY_CAPACITY:int = 4;
		
		/**
		 * Battery remaining energy in nanowatt-hours, as a long integer.
		 */
		public static var BATTERY_PROPERTY_ENERGY_COUNTER:int = 5;
	}	
}
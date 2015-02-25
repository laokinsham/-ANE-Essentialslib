package com.unllimited.essentialslib.consts.android
{
	/**
	 * Consts for open settings
	 * @author laokinsham
	 */
	public class SettingsConstants
	{
		// Intent actions for Settings
		
		/**
		 * Activity Action: Show system settings.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_SETTINGS	: String = "android.settings.SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of APNs.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_APN_SETTINGS	: String = "android.settings.APN_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of current location
		 * sources.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_LOCATION_SOURCE_SETTINGS	: String = "android.settings.LOCATION_SOURCE_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of wireless controls
		 * such as Wi-Fi, Bluetooth and Mobile networks.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_WIRELESS_SETTINGS	: String = "android.settings.WIRELESS_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow entering/exiting airplane mode.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_AIRPLANE_MODE_SETTINGS	: String = "android.settings.AIRPLANE_MODE_SETTINGS";
		
		/**
		 * @hide
		 * Activity Action: Modify Airplane mode settings using the users voice.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you safeguard against this.
		 * <p>
		 * This intent MUST be started using
		 * {@link android.service.voice.VoiceInteractionSession#startVoiceActivity
		 * startVoiceActivity}.
		 * <p>
		 * To tell which state airplane mode should be set to, add the
		 * {@link #EXTRA_AIRPLANE_MODE_ENABLED} extra to this Intent with the state specified.
		 * If there is no extra in this Intent, no changes will be made.
		 * <p>
		 * The activity should verify that
		 * {@link android.app.Activity#isVoiceInteraction isVoiceInteraction} returns true before
		 * modifying the setting.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_VOICE_CONTROL_AIRPLANE_MODE	: String = "android.settings.VOICE_CONTROL_AIRPLANE_MODE";
		
		/**
		 * Activity Action: Show settings for accessibility modules.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_ACCESSIBILITY_SETTINGS	: String = "android.settings.ACCESSIBILITY_SETTINGS";
		
		/**
		 * Activity Action: Show settings to control access to usage information.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_USAGE_ACCESS_SETTINGS	: String = "android.settings.USAGE_ACCESS_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of security and
		 * location privacy.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_SECURITY_SETTINGS	: String = "android.settings.SECURITY_SETTINGS";
		
		/**
		 * Activity Action: Show trusted credentials settings, opening to the user tab,
		 * to allow management of installed credentials.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 * @hide
		 */
		public static var ACTION_TRUSTED_CREDENTIALS_USER	: String = "com.android.settings.TRUSTED_CREDENTIALS_USER";
		
		/**
		 * Activity Action: Show dialog explaining that an installed CA cert may enable
		 * monitoring of encrypted network traffic.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 * @hide
		 */
		public static var ACTION_MONITORING_CERT_INFO	: String = "com.android.settings.MONITORING_CERT_INFO";
		
		/**
		 * Activity Action: Show settings to allow configuration of privacy options.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_PRIVACY_SETTINGS	: String = "android.settings.PRIVACY_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of Wi-Fi.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 
		 */
		public static var ACTION_WIFI_SETTINGS	: String = "android.settings.WIFI_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of a static IP
		 * address for Wi-Fi.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you safeguard
		 * against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_WIFI_IP_SETTINGS	: String = "android.settings.WIFI_IP_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of Bluetooth.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_BLUETOOTH_SETTINGS	: String = "android.settings.BLUETOOTH_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of Wifi Displays.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 * @hide
		 */
		public static var ACTION_WIFI_DISPLAY_SETTINGS	: String = "android.settings.WIFI_DISPLAY_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of
		 * cast endpoints.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_CAST_SETTINGS	: String = "android.settings.CAST_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of date and time.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_DATE_SETTINGS	: String = "android.settings.DATE_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of sound and volume.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_SOUND_SETTINGS	: String = "android.settings.SOUND_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of display.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_DISPLAY_SETTINGS	: String = "android.settings.DISPLAY_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of locale.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_LOCALE_SETTINGS	: String = "android.settings.LOCALE_SETTINGS";
		
		/**
		 * Activity Action: Show settings to configure input methods, in particular
		 * allowing the user to enable input methods.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_VOICE_INPUT_SETTINGS	: String = "android.settings.VOICE_INPUT_SETTINGS";
		
		/**
		 * Activity Action: Show settings to configure input methods, in particular
		 * allowing the user to enable input methods.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_INPUT_METHOD_SETTINGS	: String = "android.settings.INPUT_METHOD_SETTINGS";
		
		/**
		 * Activity Action: Show settings to enable/disable input method subtypes.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * To tell which input method's subtypes are displayed in the settings, add
		 * {@link #EXTRA_INPUT_METHOD_ID} extra to this Intent with the input method id.
		 * If there is no extra in this Intent, subtypes from all installed input methods
		 * will be displayed in the settings.
		 *
		 * @see android.view.inputmethod.InputMethodInfo#getId
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_INPUT_METHOD_SUBTYPE_SETTINGS	: String = "android.settings.INPUT_METHOD_SUBTYPE_SETTINGS";
		
		/**
		 * Activity Action: Show a dialog to select input method.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 * @hide
		 */
		public static var ACTION_SHOW_INPUT_METHOD_PICKER	: String = "android.settings.SHOW_INPUT_METHOD_PICKER";
		
		/**
		 * Activity Action: Show settings to manage the user input dictionary.
		 * <p>
		 * Starting with {@link android.os.Build.VERSION_CODES#KITKAT},
		 * it is guaranteed there will always be an appropriate implementation for this Intent action.
		 * In prior releases of the platform this was optional, so ensure you safeguard against it.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_USER_DICTIONARY_SETTINGS	: String = "android.settings.USER_DICTIONARY_SETTINGS";
		
		/**
		 * Activity Action: Adds a word to the user dictionary.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: An extra with key <code>word</code> that contains the word
		 * that should be added to the dictionary.
		 * <p>
		 * Output: Nothing.
		 *
		 * @hide
		 */
		public static var ACTION_USER_DICTIONARY_INSERT	: String = "com.android.settings.USER_DICTIONARY_INSERT";
		
		/**
		 * Activity Action: Show settings to allow configuration of application-related settings.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_APPLICATION_SETTINGS	: String = "android.settings.APPLICATION_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of application
		 * development-related settings.  As of
		 * {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1} this action is
		 * a required part of the platform.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_APPLICATION_DEVELOPMENT_SETTINGS	: String = "android.settings.APPLICATION_DEVELOPMENT_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of quick launch shortcuts.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_QUICK_LAUNCH_SETTINGS	: String = "android.settings.QUICK_LAUNCH_SETTINGS";
		
		/**
		 * Activity Action: Show settings to manage installed applications.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_MANAGE_APPLICATIONS_SETTINGS	: String = "android.settings.MANAGE_APPLICATIONS_SETTINGS";
		
		/**
		 * Activity Action: Show settings to manage all applications.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS	: String = "android.settings.MANAGE_ALL_APPLICATIONS_SETTINGS";
		
		/**
		 * Activity Action: Show screen of details about a particular application.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: The Intent's data URI specifies the application package name
		 * to be shown, with the "package" scheme.  That is "package:com.my.app".
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_APPLICATION_DETAILS_SETTINGS	: String = "android.settings.APPLICATION_DETAILS_SETTINGS";
		
		/**
		 * @hide
		 * Activity Action: Show the "app ops" settings screen.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_APP_OPS_SETTINGS	: String = "android.settings.APP_OPS_SETTINGS";
		
		/**
		 * Activity Action: Show settings for system update functionality.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 *
		 * @hide
		 */
		public static var ACTION_SYSTEM_UPDATE_SETTINGS	: String = "android.settings.SYSTEM_UPDATE_SETTINGS";
		
		/**
		 * Activity Action: Show settings to allow configuration of sync settings.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * The account types available to add via the add account button may be restricted by adding an
		 * {@link #EXTRA_AUTHORITIES} extra to this Intent with one or more syncable content provider's
		 * authorities. Only account types which can sync with that content provider will be offered to
		 * the user.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_SYNC_SETTINGS	: String = "android.settings.SYNC_SETTINGS";
		
		/**
		 * Activity Action: Show add account screen for creating a new account.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * The account types available to add may be restricted by adding an {@link #EXTRA_AUTHORITIES}
		 * extra to the Intent with one or more syncable content provider's authorities.  Only account
		 * types which can sync with that content provider will be offered to the user.
		 * <p>
		 * Account types can also be filtered by adding an {@link #EXTRA_ACCOUNT_TYPES} extra to the
		 * Intent with one or more account types.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_ADD_ACCOUNT	: String = "android.settings.ADD_ACCOUNT_SETTINGS";
		
		/**
		 * Activity Action: Show settings for selecting the network operator.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_NETWORK_OPERATOR_SETTINGS	: String = "android.settings.NETWORK_OPERATOR_SETTINGS";
		
		/**
		 * Activity Action: Show settings for selection of 2G/3G.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_DATA_ROAMING_SETTINGS	: String = "android.settings.DATA_ROAMING_SETTINGS";
		
		/**
		 * Activity Action: Show settings for internal storage.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_INTERNAL_STORAGE_SETTINGS	: String = "android.settings.INTERNAL_STORAGE_SETTINGS";
		/**
		 * Activity Action: Show settings for memory card storage.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_MEMORY_CARD_SETTINGS	: String = "android.settings.MEMORY_CARD_SETTINGS";
		
		/**
		 * Activity Action: Show settings for global search.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing
		 */
		public static var ACTION_SEARCH_SETTINGS	: String = "android.search.action.SEARCH_SETTINGS";
		
		/**
		 * Activity Action: Show general device information settings (serial
		 * number, software version, phone number, etc.).
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing
		 */
		public static var ACTION_DEVICE_INFO_SETTINGS	: String = "android.settings.DEVICE_INFO_SETTINGS";
		
		/**
		 * Activity Action: Show NFC settings.
		 * <p>
		 * This shows UI that allows NFC to be turned on or off.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing
		 * @see android.nfc.NfcAdapter#isEnabled()
		 */
		public static var ACTION_NFC_SETTINGS	: String = "android.settings.NFC_SETTINGS";
		
		/**
		 * Activity Action: Show NFC Sharing settings.
		 * <p>
		 * This shows UI that allows NDEF Push (Android Beam) to be turned on or
		 * off.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing
		 * @see android.nfc.NfcAdapter#isNdefPushEnabled()
		 */
		public static var ACTION_NFCSHARING_SETTINGS	: String = "android.settings.NFCSHARING_SETTINGS";
		
		/**
		 * Activity Action: Show NFC Tap & Pay settings
		 * <p>
		 * This shows UI that allows the user to configure Tap&Pay
		 * settings.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing
		 */
		public static var ACTION_NFC_PAYMENT_SETTINGS	: String = "android.settings.NFC_PAYMENT_SETTINGS";
		
		/**
		 * Activity Action: Show Daydream settings.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 * @see android.service.dreams.DreamService
		 */
		public static var ACTION_DREAM_SETTINGS	: String = "android.settings.DREAM_SETTINGS";
		
		/**
		 * Activity Action: Show Notification listener settings.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 * @see android.service.notification.NotificationListenerService
		 * @hide
		 */
		public static var ACTION_NOTIFICATION_LISTENER_SETTINGS	: String = "android.settings.NOTIFICATION_LISTENER_SETTINGS";
		
		/**
		 * @hide
		 */
		public static var ACTION_CONDITION_PROVIDER_SETTINGS	: String = "android.settings.ACTION_CONDITION_PROVIDER_SETTINGS";
		
		/**
		 * Activity Action: Show settings for video captioning.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you safeguard
		 * against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_CAPTIONING_SETTINGS	: String = "android.settings.CAPTIONING_SETTINGS";
		
		/**
		 * Activity Action: Show the top level print settings.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you
		 * safeguard against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var ACTION_PRINT_SETTINGS	: String = "android.settings.ACTION_PRINT_SETTINGS";
		
		/**
		 * Activity Action: Show Zen Mode configuration settings.
		 *
		 * @hide
		 */
		public static var ACTION_ZEN_MODE_SETTINGS	: String = "android.settings.ZEN_MODE_SETTINGS";
		
		/**
		 * Activity Action: Show the regulatory information screen for the device.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you safeguard
		 * against this.
		 * <p>
		 * Input: Nothing.
		 * <p>
		 * Output: Nothing.
		 */
		public static var
		ACTION_SHOW_REGULATORY_INFO	: String = "android.settings.SHOW_REGULATORY_INFO";
		
		/**
		 * Activity Action: Show Device Name Settings.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you safeguard
		 * against this.
		 *
		 * @hide
		 */
		public static var DEVICE_NAME_SETTINGS	: String = "android.settings.DEVICE_NAME";
		
		/**
		 * Activity Action: Show pairing settings.
		 * <p>
		 * In some cases, a matching Activity may not exist, so ensure you safeguard
		 * against this.
		 *
		 * @hide
		 */
		public static var ACTION_PAIRING_SETTINGS	: String = "android.settings.PAIRING_SETTINGS";
		
		/**
		 * Activity Action: Show battery saver settings.
		 *
		 * @hide
		 */
		public static var ACTION_BATTERY_SAVER_SETTINGS	: String = "android.settings.BATTERY_SAVER_SETTINGS";
		
		/**
		 * Activity Action: Show Home selection settings. If there are multiple activities
		 * that can satisfy the {@link Intent#CATEGORY_HOME} intent, this screen allows you
		 * to pick your preferred activity.
		 */
		public static var ACTION_HOME_SETTINGS	: String = "android.settings.HOME_SETTINGS";
		
		/**
		 * Activity Action: Show notification settings.
		 *
		 * @hide
		 */
		public static var ACTION_NOTIFICATION_SETTINGS	: String = "android.settings.NOTIFICATION_SETTINGS";
		
		/**
		 * Activity Action: Show notification settings for a single app.
		 *
		 * @hide
		 */
		public static var ACTION_APP_NOTIFICATION_SETTINGS	: String = "android.settings.APP_NOTIFICATION_SETTINGS";
		
		/**
		 * Activity Action: Show notification redaction settings.
		 *
		 * @hide
		 */
		public static var ACTION_APP_NOTIFICATION_REDACTION	: String = "android.settings.ACTION_APP_NOTIFICATION_REDACTION";
		
	}
}
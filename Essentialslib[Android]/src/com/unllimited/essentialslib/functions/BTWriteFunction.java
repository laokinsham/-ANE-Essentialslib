/**
 * Created by lao on 24/01/2015.
 */
package com.unllimited.essentialslib.functions;

import java.nio.charset.Charset;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.unllimited.essentialslib.EssentialslibExtension;

public class BTWriteFunction implements FREFunction
{
	public static final String TAG = "BTWrite";
	
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		FREObject result = null;
		
		String message	= "";
		String charset	= "";
		
		try
		{
			message = args[0].getAsString();
			charset = args[1].getAsString();
			
			if (charset == null || charset == "")
				charset = Charset.defaultCharset().name();
			
			EssentialslibExtension.writeData(message.getBytes(Charset.forName(charset)));
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
		catch (FREWrongThreadException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			result = FREObject.newObject("[" + charset + "] " + message);
		}
		catch (FREWrongThreadException e)
		{
		}
		catch (IllegalStateException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
}

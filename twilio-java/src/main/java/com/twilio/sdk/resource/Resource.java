package com.twilio.sdk.resource;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.twilio.sdk.TwilioClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class Resource.
 */
public abstract class Resource<C extends TwilioClient> {

	/** The client. */
	private C client;

	/** The request account sid. */
	private String requestAccountSid;

	/** The filters. */
	protected Map<String, String> filters;
	
	/** Date formatting */
	protected static final DateTimeFormatter ISO_8601_DATE_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZoneUTC();

	/**
	 * Instantiates a new resource.
	 *
	 * @param client the client
	 */
	public Resource(C client) {
		this.client = client;
	}

	/**
	 * Gets the client.
	 *
	 * @return the client
	 */
	protected C getClient() {
		return this.client;
	}

	/**
	 * Load.
	 *
	 * @param params the params
	 * @throws TwilioRestException the twilio rest exception
	 */
	protected void load(Map<String, String> params) throws TwilioRestException {
		String path = getResourceLocation();
		TwilioRestResponse response = getClient().safeRequest(path, "GET", params);

		parseResponse(response);
		loaded = true;
	}

	/**
	 * Parses the response.
	 *
	 * @param response the response
	 */
	protected abstract void parseResponse(TwilioRestResponse response);

	// flags whether or not the HTTP request to popluate
	// this data has occured. We can construct resources
	// that are lazily loaded
	/** The loaded. */
	private boolean loaded;

	/**
	 * Checks if is loaded.
	 *
	 * @return true, if is loaded
	 */
	protected boolean isLoaded() {
		return loaded;
	}

	/**
	 * Sets the loaded.
	 *
	 * @param loaded the new loaded
	 */
	protected void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	// Taken from the request uri, or the request account
	/**
	 * Gets the request account sid.
	 *
	 * @return the request account sid
	 */
	protected String getRequestAccountSid() {
		return this.requestAccountSid;
	}

	/**
	 * Sets the request account sid.
	 *
	 * @param sid the new request account sid
	 */
	public void setRequestAccountSid(String sid) {
		this.requestAccountSid = sid;
	}
	
	/**
	 * Parsing a date string formated in ISO8601 format to a Calendar
	 * @param inDate string in ISO8601 format
	 * @return the represented Calendar
	 */
	protected Calendar parseCalendar(final String inDate) {
		if (inDate == null) {
			return null;
		}
		
		try {
			GregorianCalendar c = new GregorianCalendar();
			Date d = DateTime.parse(inDate, ISO_8601_DATE_FORMAT).toDate();
			c.setTime(d);
			return c;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	/**
	 * Formats a Calendar into an an ISO8601 date string
	 * @param calendar the calendar to convert
	 * @return the represented string
	 */
	protected String formatCalendar(final Calendar calendar) {
		if(calendar == null) {
			return null;
		}
		long millis = calendar.getTimeInMillis();
		return ISO_8601_DATE_FORMAT.print(millis);
	}
	
	/**
	 * Gets the resource location.
	 *
	 * @return the resource location
	 */
	protected abstract String getResourceLocation();

}

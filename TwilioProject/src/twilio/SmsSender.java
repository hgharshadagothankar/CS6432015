package twilio;

//Download the twilio-java library from http://twilio.com/docs/libraries
import java.util.Map;
import java.util.HashMap;

import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SmsSender {

 /* Find your sid and token at twilio.com/user/account */
 public static final String ACCOUNT_SID = "ACa89cb789e13251f549b2a5a62a021a26";
 public static final String AUTH_TOKEN = "eb9d1d303603bd4a799d76011e7374d4";

 public static void main(String[] args) throws TwilioRestException {

     TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

     Account account = client.getAccount();

     MessageFactory messageFactory = account.getMessageFactory();
     List<NameValuePair> params = new ArrayList<NameValuePair>();
     //917 216 4313
     params.add(new BasicNameValuePair("To", "+15515879364")); // Replace with a valid phone number for your account.
     params.add(new BasicNameValuePair("From", "+12012318720")); // Replace with a valid phone number for your account.
     params.add(new BasicNameValuePair("Body", "Harshada Gothankar"));
     Message sms = messageFactory.create(params);
 }
}


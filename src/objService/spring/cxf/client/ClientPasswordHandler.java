package objService.spring.cxf.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ClientPasswordHandler implements CallbackHandler {

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		// TODO Auto-generated method stub
		 WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		 
	        // set the password for our message.
	        pc.setPassword("password");

	}

}

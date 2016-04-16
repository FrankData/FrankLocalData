package objService.pure.cxf.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import objService.pure.cxf.server.HelloWorld;

public class CXFClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientProxyFactoryBean proxy = new ClientProxyFactoryBean();
		
		
		
		
		
		
		proxy.setAddress("http://localhost:8089/helloworld");
		proxy.setServiceClass(HelloWorld.class);
		

		Map<String,Object> outProps = new HashMap<String,Object>();
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		proxy.getOutInterceptors().add(wssOut);
		HelloWorld client= (HelloWorld) proxy.create();
		
		
		
		

		outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		// Specify our username
		outProps.put(WSHandlerConstants.USER, "joe");
		// Password type : plain text
		outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		// for hashed password use:
		//properties.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
		// Callback used to retrieve password for given user.
		outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, 
		    ClientPasswordHandler.class.getName());
		
	
	
		
		
		System.out.println(client.sayHi("tester"));

	}

}

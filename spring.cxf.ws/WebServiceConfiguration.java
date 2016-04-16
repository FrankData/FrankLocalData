

//import handler.ServerPasswordHandler;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import de.codecentric.namespace.weatherservice.WeatherService;
//import de.jonashackt.tutorial.endpoint.WeatherServiceEndpoint;

@Configuration
public class WebServiceConfiguration {
	
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }    
    
//    @Bean
//    public WeatherService weatherService() {
//    	return new WeatherServiceEndpoint();
//    }
    
//    @Bean
//    public Endpoint endpoint() {
//        EndpointImpl endpoint = new EndpointImpl(springBus(), weatherService());
//        endpoint.publish("/WeatherSoapService_1.0");
//        endpoint.setWsdlLocation("Weather1.0.wsdl");
////		Map<String,Object> inProps = new HashMap<String,Object>();
////		inProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
////		// Password type : plain text
////		inProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PASSWORD_TEXT);
////		// for hashed password use:
////		//properties.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
////		// Callback used to retrieve password for given user.
////		inProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, 
////		    ServerPasswordHandler.class.getName());
////		 
////		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
////        endpoint.getInInterceptors().
//        return endpoint;
//    }
}

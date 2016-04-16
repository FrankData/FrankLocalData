package objService.spring.cxf.client;

import java.io.PrintWriter;

import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;

import output.GenerateReport;

public class OutSOAPMonitorIntercepter extends LoggingOutInterceptor {
	 public OutSOAPMonitorIntercepter() {
	        super();
	    }

	    @Override
	    protected String formatLoggingMessage(LoggingMessage loggingMessage) {
	        String soapXmlPayload = loggingMessage.getPayload() != null ? loggingMessage.getPayload().toString() : null;

	        // do what you want with the payload... in my case, I stuck it in a JMS Queue
	  
//	        System.out.println(super.formatLoggingMessage(loggingMessage));
	        GenerateReport.report(super.formatLoggingMessage(loggingMessage),"outOFClient");
	        return super.formatLoggingMessage(loggingMessage);
	    }
}
package helloWorld.pure.java.client;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

import helloWorld.pure.java.server.HelloWorld;

public class CXFClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientProxyFactoryBean proxy = new ClientProxyFactoryBean();
		proxy.setAddress("http://localhost:8089/helloworld");
		proxy.setServiceClass(HelloWorld.class);
		HelloWorld client= (HelloWorld) proxy.create();
		System.out.println(client.sayHi("tester"));

	}

}

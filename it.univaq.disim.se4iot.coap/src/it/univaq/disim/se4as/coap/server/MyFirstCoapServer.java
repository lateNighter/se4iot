package it.univaq.disim.se4as.coap.server;

import it.univaq.disim.se4as.coap.server.resources.LedResource;

import java.net.InetSocketAddress;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoAPEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;

import it.univaq.disim.se4as.coap.server.resources.HelloWorldResource;
import it.univaq.disim.se4as.coap.server.resources.ObservableResource;
import it.univaq.disim.se4as.coap.server.resources.TemperatureResource;

public class MyFirstCoapServer extends CoapServer{
	
	public static void main(String args[]) {
		NetworkConfig config = NetworkConfig.getStandard();
		//CoAPEndpoint endpoint = new CoAPEndpoint(new InetSocketAddress(InetAddress.getLoopbackAddress(), config.getInt(NetworkConfig.Keys.COAP_PORT)));
		CoAPEndpoint endpoint = new CoAPEndpoint(new InetSocketAddress("0.0.0.0" , config.getInt(NetworkConfig.Keys.COAP_PORT)));

		MyFirstCoapServer server = new MyFirstCoapServer();
		server.addEndpoint(endpoint);
		 
		
	    HelloWorldResource hello = new HelloWorldResource("hello-world");
		server.add(hello);
		TemperatureResource temperature = new TemperatureResource("temperature");
		server.add(temperature);
		
        CoapResource ledpath = new CoapResource("Leds");
        ledpath.add(new LedResource("red"));	//"leds/red"
		ledpath.add(new LedResource("green"));	//"leds/green"
		ledpath.add(new LedResource("blue"));	//"leds/blue"
	    server.add(ledpath);

		ObservableResource obsRes = new ObservableResource("observable-resource");
		obsRes.setObservable(true);
		obsRes.getAttributes().setObservable();
		server.add(obsRes);


		server.start();
		
	}
	

}

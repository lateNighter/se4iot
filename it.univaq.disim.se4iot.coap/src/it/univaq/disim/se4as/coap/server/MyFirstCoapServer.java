package it.univaq.disim.se4as.coap.server;

import it.univaq.disim.se4as.coap.server.resources.LedResource;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;

import it.univaq.disim.se4as.coap.server.resources.HelloWorldResource;
import it.univaq.disim.se4as.coap.server.resources.ObservableResource;
import it.univaq.disim.se4as.coap.server.resources.TemperatureResource;

public class MyFirstCoapServer extends CoapServer{
	
	public static void main(String args[]) {
		MyFirstCoapServer server = new MyFirstCoapServer();
		
		HelloWorldResource hello = new HelloWorldResource("hello-world");
		TemperatureResource temperature = new TemperatureResource("temperature");
		server.add(hello);
		server.add(temperature);
		
		ObservableResource obsRes = new ObservableResource("observable-resource");
		obsRes.setObservable(true);
		obsRes.getAttributes().setObservable();
		server.add(obsRes);
		
        CoapResource ledpath = new CoapResource("Leds");
        ledpath.add(new LedResource("red"));	//"leds/red"
		ledpath.add(new LedResource("green"));	//"leds/green"
		ledpath.add(new LedResource("blue"));	//"leds/blue"
	    server.add(ledpath);

		server.start();
		
	}
	

}

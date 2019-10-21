package it.univaq.disim.se4as.coap.clients;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.Request;

public class SimpleCoapClient extends CoapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	CoapClient client = new CoapClient("coap://127.0.0.1:5683/Leds/blue");
		CoapClient client = new CoapClient("coap://127.0.0.1:5683/.well-known/core");

		Request request = new Request(Code.GET);
		
		CoapResponse coapResp = client.advanced(request);
		
		System.out.println(Utils.prettyPrint(coapResp));
		
	}

}

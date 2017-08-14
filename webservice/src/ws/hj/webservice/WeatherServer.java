package ws.hj.webservice;

import javax.xml.ws.Endpoint;

public class WeatherServer {

	public static void main(String[] args) {
		String address="http://localhost:8081/weather";
		WeatherInterfaceImpl implementor = new WeatherInterfaceImpl();
		Endpoint.publish(address, implementor);
	}

}

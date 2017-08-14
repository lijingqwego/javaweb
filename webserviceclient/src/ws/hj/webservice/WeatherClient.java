package ws.hj.webservice;

public class WeatherClient {

	public static void main(String[] args) throws Exception {
		WeatherInterfaceImpl weather=new WeatherInterfaceImplProxy();
		String city = weather.getWeatherByCity("beijing");
		System.out.println(city);
	}

}

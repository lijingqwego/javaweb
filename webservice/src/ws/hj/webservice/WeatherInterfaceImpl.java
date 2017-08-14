package ws.hj.webservice;

import javax.jws.WebService;

@WebService
public class WeatherInterfaceImpl implements WeatherInterface {

	@Override
	public String getWeatherByCity(String city) {
		System.out.println("接收客户端发送的城市名称："+city);
		
		String result="今天好冷...";
		System.out.println("返回天气信息："+result);
		return result;
	}

}

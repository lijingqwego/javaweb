package ws.hj.webservice;

import javax.jws.WebService;

@WebService
public class WeatherInterfaceImpl implements WeatherInterface {

	@Override
	public String getWeatherByCity(String city) {
		System.out.println("���տͻ��˷��͵ĳ������ƣ�"+city);
		
		String result="�������...";
		System.out.println("����������Ϣ��"+result);
		return result;
	}

}

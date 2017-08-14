package ws.hj.webservice;

public class WeatherInterfaceImplProxy implements ws.hj.webservice.WeatherInterfaceImpl {
  private String _endpoint = null;
  private ws.hj.webservice.WeatherInterfaceImpl weatherInterfaceImpl = null;
  
  public WeatherInterfaceImplProxy() {
    _initWeatherInterfaceImplProxy();
  }
  
  public WeatherInterfaceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initWeatherInterfaceImplProxy();
  }
  
  private void _initWeatherInterfaceImplProxy() {
    try {
      weatherInterfaceImpl = (new ws.hj.webservice.WeatherInterfaceImplServiceLocator()).getWeatherInterfaceImplPort();
      if (weatherInterfaceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)weatherInterfaceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)weatherInterfaceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (weatherInterfaceImpl != null)
      ((javax.xml.rpc.Stub)weatherInterfaceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.hj.webservice.WeatherInterfaceImpl getWeatherInterfaceImpl() {
    if (weatherInterfaceImpl == null)
      _initWeatherInterfaceImplProxy();
    return weatherInterfaceImpl;
  }
  
  public java.lang.String getWeatherByCity(java.lang.String arg0) throws java.rmi.RemoteException{
    if (weatherInterfaceImpl == null)
      _initWeatherInterfaceImplProxy();
    return weatherInterfaceImpl.getWeatherByCity(arg0);
  }
  
  
}
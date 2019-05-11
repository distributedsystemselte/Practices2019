import java.io.*;

public class ConnectionToRMI implements Serializable
{
	private String url;
	private int port;
	private String serviceName;
	
	public ConnectionToRMI(String url, int port, String serviceName)
	{
		super();
		this.url = url;
		this.port = port;
		this.serviceName = serviceName;
	}
	
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	public String getUrl()
	{
		return this.url;
	}
	
	public void setPort(int port)
	{
		this.port = port;
	}
	
	public int getPort()
	{
		return this.port;
	}
	
	public void setServiceName(String serviceName)
	{
		this.serviceName = serviceName;
	}
	
	public String getServiceName()
	{
		return this.serviceName;
	}
}
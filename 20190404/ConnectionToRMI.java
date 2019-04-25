import java.io.*; 
import java.util.*; 
import java.net.*; 
public class ConnectionToRMI implements Serializable{
    private String url;
    private int port;
    private String serviceName;
    public ConnectionToRMI(String url,int port,String serviceName){
        this.url = url;
        this.port = port;
        this.serviceName = serviceName;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
package provider.service;
import org.apache.commons.collections4.map.LinkedMap;
import java.util.Map;

public interface ProviderService {
    String SayHello(String word);
    Object getNewData(Map params);
    Object getLinkData(LinkedMap params);

}

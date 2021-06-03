import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//轮询优化
public class WeightRoundRobin {
    public static String getServer() {
        int totalWeights = 0;
        for(Integer weight : ServerIps.WEIGHT_LIST.values()) {
            totalWeights += weight;
        }

        Integer requestId = RequestId.getAndIncrement();
        Integer pos = requestId % totalWeights;

        for(String ip: ServerIps.WEIGHT_LIST.keySet()) {
            Integer weight = ServerIps.WEIGHT_LIST.get(ip);
            if(pos < weight) {
                return ip;
            }
            pos = pos - weight;
        }

        return "";
    }

}

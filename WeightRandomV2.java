import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//带权重随机
public class WeightRandomV2 {
    public static String getServer() {
        //总权重
        int totalWeights = 0;
        for(Integer weight : ServerIps.WEIGHT_LIST.values()) {
            totalWeights += weight;
        }
        Random random = new Random();
        int pos = random.nextInt(totalWeights);
        Set<Integer> weightSet = new HashSet<Integer>();
        for(Integer weight: ServerIps.WEIGHT_LIST.values()) {
            weightSet.add(weight);
        }
        if(weightSet.size() > 1) {
            for(String ip: ServerIps.WEIGHT_LIST.keySet()) {
                Integer weight = ServerIps.WEIGHT_LIST.get(ip);
                if(pos < weight) {
                    return ip;
                }
                pos = pos - weight;
            }
        } else {
            return ServerIps.LIST.get(pos);
        }

        return "";
    }
}

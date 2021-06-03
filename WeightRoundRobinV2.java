import java.util.HashMap;
import java.util.Map;

public class WeightRoundRobinV2 {
    public static Map<String,Weight> weights = new HashMap<>();
    public static String getServer() {
        int totalWeights = 0;
        for(Integer weight : ServerIps.WEIGHT_LIST.values()) {
            totalWeights += weight;
        }

        //currentWeight 默认值 0
        if(weights.isEmpty()) {
            ServerIps.WEIGHT_LIST.forEach((ip,weight)->
            {
                weights.put(ip,new Weight(ip,weight,0));
            });
        }
        for(Weight weight:weights.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }

        //找最大值
        Weight maxCurrentWeight = null;
        for(Weight weight:weights.values()) {
            if(maxCurrentWeight == null || weight.getCurrentWeight() > maxCurrentWeight.getCurrentWeight()) {
                maxCurrentWeight = weight;
            }
        }
        maxCurrentWeight.setCurrentWeight( maxCurrentWeight.getCurrentWeight() - totalWeights);
        return maxCurrentWeight.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(getServer());
        }
    }
}

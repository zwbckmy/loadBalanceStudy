import java.util.Random;

//随机
public class RandomSelect {
    public static String getServer() {
        Random random = new Random();
        int rand = random.nextInt(ServerIps.LIST.size());
        return ServerIps.LIST.get(rand);
    }
}

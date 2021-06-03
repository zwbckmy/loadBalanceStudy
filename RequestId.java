//模拟请求id
public class RequestId {
    public static Integer num = 0;
    public static Integer getAndIncrement() {
        return num++;
    }
}

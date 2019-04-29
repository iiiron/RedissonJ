import net.noboard.redissonJ.redissonvisitcontroller.RedissonJClient;

public class Test {
    public static void main(String[] a) {
        RedissonJClient redissonJClient = new RedissonJClient(null, "Test");
        redissonJClient.getBucket(":p:o:User:1");
    }
}

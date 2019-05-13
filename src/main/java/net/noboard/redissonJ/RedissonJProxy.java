package net.noboard.redissonJ;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.regex.Pattern;

public class RedissonJProxy implements InvocationHandler {

    private static Logger logger = LogManager.getLogger(RedissonJProxy.class);

    private Object object;

    private boolean canWrite;

    private boolean canRead;

    private String key;

    public Object bind(Object object, String key, String projectName) {
        this.key = key;
        this.object = object;
        logger.info(key);
        if (key != null) {
            String[] strings = key.split(":");
            canRead = false;
            canWrite = false;
            if (strings[0].equals("forAll")) {
                canWrite = true;
                canRead = true;
            } else {
                if (strings[0].equals(projectName)) {
                    canRead = true;
                    canWrite = true;
                } else {
                    if (strings[1].equals("o")) {
                        canRead = true;
                    }
                    if (strings[2].equals("o")) {
                        canWrite = true;
                    }
                }
            }
        }
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (key == null) {
            logger.warn("你正在进行一个无key约束的操作。" + method.getDeclaringClass() + "." + method.getName());
        } else {
            if (Pattern.matches("(set)|(add)|(remove)|(delete)", method.getName().toLowerCase()) && !canWrite) {
                logger.error("方法 " + method.getDeclaringClass() + "." + method.getName() + " ，使用 key（" + key + "）写入了不可写数据");
            }
            if (Pattern.matches("(get)|(sub)|(read)|(size)", method.getName().toLowerCase()) && !canRead) {
                logger.error("方法 " + method.getDeclaringClass() + "." + method.getName() + " ，使用 key（" + key + "）读取了不可读数据");
            }
        }
        return method.invoke(this.object, args);
    }
}

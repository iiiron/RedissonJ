package net.noboard.redissonJ;

import org.redisson.api.RedissonClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RedissonJClientProxy implements InvocationHandler {

    private RedissonClient object;

    private String projectName;

    public RedissonClient bind(RedissonClient object, String projectName) {
        this.object = object;
        this.projectName = projectName;
        return (RedissonClient) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String key = null;
        if (args[0] instanceof String) {
            args[0] = makeKey((String) args[0]);
            key = (String) args[0];
        }
        return new RedissonJProxy().bind(method.invoke(this.object, args),key,projectName);
    }

    private String makeKey(String key) {
        /**
         * 最前字符不是“:”，此时判定key不包含权限控制信息，使用默认配置
         * 默认配置[projectName:o:o:key]
         */
        if (Pattern.matches("^[^:\b\\s]+?:.+$", key)) {
            return this.projectName + ":o:o:" + key;
        } else if (Pattern.matches("^:::.+$", key)) {
            List<String> list = Arrays.asList(key.split(":"));
            return "forAll:" + join(list.subList(3, list.size()));
        } else if (Pattern.matches("^:[op]:[op]:.+$", key)) {
            return this.projectName + key;
        } else if (Pattern.matches("^:[^:]+?:[op]:[op]:.+$", key)) {
            return key;
        } else {
            throw new RedissonJException("Key格式不符合RedissonJ规格：" + key);
        }
    }

    private String join(List<String> arg) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arg) {
            stringBuilder.append(s).append(":");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}

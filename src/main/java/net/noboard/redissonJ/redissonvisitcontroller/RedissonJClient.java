package net.noboard.redissonJ.redissonvisitcontroller;

import com.sun.deploy.util.StringUtils;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.redisson.api.*;
import org.redisson.client.codec.Codec;
import org.redisson.config.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class RedissonJClient implements RedissonClient {

    private RedissonClient redissonClient;

    private String projectName;

    public RedissonJClient(RedissonClient redissonClient, String projectName) {
        this.redissonClient = redissonClient;
        this.projectName = projectName;
    }

    private String makeKey(String key) {
        // 最前字符不是“:”，此时判定key不包含权限控制信息，使用默认配置
        if (Pattern.matches("^[^:\b\\s]+?:.+$", key)) {
            return this.projectName + ":o:o:" + key;
        } else if (Pattern.matches("^:::.+$", key)) {
            List<String> list = Arrays.asList(key.split(":"));
            return "forAll:" + StringUtils.join(list.subList(3, list.size()), ":");
        } else if (Pattern.matches("^:[op]:[op]:.+$", key)) {
            return this.projectName + key;
        } else {
            throw new RedissonJException("Key格式不符合RedissonJ规格：" + key);
        }
    }

    public <K, V> RStream<K, V> getStream(String s) {
        return redissonClient.getStream(makeKey(s));
    }

    public <K, V> RStream<K, V> getStream(String s, Codec codec) {
        return redissonClient.getStream(makeKey(s), codec);
    }

    public RRateLimiter getRateLimiter(String s) {
        return redissonClient.getRateLimiter(makeKey(s));
    }

    public RBinaryStream getBinaryStream(String s) {
        return redissonClient.getBinaryStream(makeKey(s));
    }

    public <V> RGeo<V> getGeo(String s) {
        return redissonClient.getGeo(makeKey(s));
    }

    public <V> RGeo<V> getGeo(String s, Codec codec) {
        return redissonClient.getGeo(makeKey(s), codec);
    }

    public <V> RSetCache<V> getSetCache(String s) {
        return redissonClient.getSetCache(makeKey(s));
    }

    public <V> RSetCache<V> getSetCache(String s, Codec codec) {
        return redissonClient.getSetCache(makeKey(s), codec);
    }

    public <K, V> RMapCache<K, V> getMapCache(String s, Codec codec) {
        return redissonClient.getMapCache(makeKey(s), codec);
    }

    public <K, V> RMapCache<K, V> getMapCache(String s, Codec codec, MapOptions<K, V> mapOptions) {
        return redissonClient.getMapCache(makeKey(s), codec, mapOptions);
    }

    public <K, V> RMapCache<K, V> getMapCache(String s) {
        return redissonClient.getMapCache(makeKey(s));
    }

    public <K, V> RMapCache<K, V> getMapCache(String s, MapOptions<K, V> mapOptions) {
        return redissonClient.getMapCache(makeKey(s), mapOptions);
    }

    public <V> RBucket<V> getBucket(String s) {
        return redissonClient.getBucket(makeKey(s));
    }

    public <V> RBucket<V> getBucket(String s, Codec codec) {
        return redissonClient.getBucket(makeKey(s), codec);
    }

    public RBuckets getBuckets() {
        return redissonClient.getBuckets();
    }

    public RBuckets getBuckets(Codec codec) {
        return redissonClient.getBuckets(codec);
    }

    public <V> RHyperLogLog<V> getHyperLogLog(String s) {
        return redissonClient.getHyperLogLog(makeKey(s));
    }

    public <V> RHyperLogLog<V> getHyperLogLog(String s, Codec codec) {
        return redissonClient.getHyperLogLog(makeKey(s), codec);
    }

    public <V> RList<V> getList(String s) {
        return redissonClient.getList(makeKey(s));
    }

    public <V> RList<V> getList(String s, Codec codec) {
        return redissonClient.getList(makeKey(s), codec);
    }

    public <K, V> RListMultimap<K, V> getListMultimap(String s) {
        return redissonClient.getListMultimap(makeKey(s));
    }

    public <K, V> RListMultimap<K, V> getListMultimap(String s, Codec codec) {
        return redissonClient.getListMultimap(makeKey(s), codec);
    }

    public <K, V> RListMultimapCache<K, V> getListMultimapCache(String s) {
        return redissonClient.getListMultimapCache(makeKey(s));
    }

    public <K, V> RListMultimapCache<K, V> getListMultimapCache(String s, Codec codec) {
        return redissonClient.getListMultimapCache(makeKey(s), codec);
    }

    public <K, V> RLocalCachedMap<K, V> getLocalCachedMap(String s, LocalCachedMapOptions<K, V> localCachedMapOptions) {
        return redissonClient.getLocalCachedMap(makeKey(s), localCachedMapOptions);
    }

    public <K, V> RLocalCachedMap<K, V> getLocalCachedMap(String s, Codec codec, LocalCachedMapOptions<K, V> localCachedMapOptions) {
        return redissonClient.getLocalCachedMap(makeKey(s), codec, localCachedMapOptions);
    }

    public <K, V> RMap<K, V> getMap(String s) {
        return redissonClient.getMap(makeKey(s));
    }

    public <K, V> RMap<K, V> getMap(String s, MapOptions<K, V> mapOptions) {
        return redissonClient.getMap(makeKey(s), mapOptions);
    }

    public <K, V> RMap<K, V> getMap(String s, Codec codec) {
        return redissonClient.getMap(makeKey(s), codec);
    }

    public <K, V> RMap<K, V> getMap(String s, Codec codec, MapOptions<K, V> mapOptions) {
        return redissonClient.getMap(makeKey(s), codec, mapOptions);
    }

    public <K, V> RSetMultimap<K, V> getSetMultimap(String s) {
        return redissonClient.getSetMultimap(makeKey(s));
    }

    public <K, V> RSetMultimap<K, V> getSetMultimap(String s, Codec codec) {
        return redissonClient.getSetMultimap(makeKey(s), codec);
    }

    public <K, V> RSetMultimapCache<K, V> getSetMultimapCache(String s) {
        return redissonClient.getSetMultimapCache(makeKey(s));
    }

    public <K, V> RSetMultimapCache<K, V> getSetMultimapCache(String s, Codec codec) {
        return redissonClient.getSetMultimapCache(makeKey(s), codec);
    }

    public RSemaphore getSemaphore(String s) {
        return redissonClient.getSemaphore(makeKey(s));
    }

    public RPermitExpirableSemaphore getPermitExpirableSemaphore(String s) {
        return redissonClient.getPermitExpirableSemaphore(makeKey(s));
    }

    public RLock getLock(String s) {
        return redissonClient.getLock(makeKey(s));
    }

    public RLock getMultiLock(RLock... rLocks) {
        return redissonClient.getMultiLock(rLocks);
    }

    public RLock getRedLock(RLock... rLocks) {
        return redissonClient.getRedLock(rLocks);
    }

    public RLock getFairLock(String s) {
        return redissonClient.getFairLock(makeKey(s));
    }

    public RReadWriteLock getReadWriteLock(String s) {
        return redissonClient.getReadWriteLock(makeKey(s));
    }

    public <V> RSet<V> getSet(String s) {
        return redissonClient.getSet(makeKey(s));
    }

    public <V> RSet<V> getSet(String s, Codec codec) {
        return redissonClient.getSet(makeKey(s), codec);
    }

    public <V> RSortedSet<V> getSortedSet(String s) {
        return redissonClient.getSortedSet(makeKey(s));
    }

    public <V> RSortedSet<V> getSortedSet(String s, Codec codec) {
        return redissonClient.getSortedSet(makeKey(s), codec);
    }

    public <V> RScoredSortedSet<V> getScoredSortedSet(String s) {
        return redissonClient.getScoredSortedSet(makeKey(s));
    }

    public <V> RScoredSortedSet<V> getScoredSortedSet(String s, Codec codec) {
        return redissonClient.getScoredSortedSet(makeKey(s), codec);
    }

    public RLexSortedSet getLexSortedSet(String s) {
        return redissonClient.getLexSortedSet(makeKey(s));
    }

    public RTopic getTopic(String s) {
        return redissonClient.getTopic(makeKey(s));
    }

    public RTopic getTopic(String s, Codec codec) {
        return redissonClient.getTopic(makeKey(s), codec);
    }

    public RPatternTopic getPatternTopic(String s) {
        return redissonClient.getPatternTopic(makeKey(s));
    }

    public RPatternTopic getPatternTopic(String s, Codec codec) {
        return redissonClient.getPatternTopic(makeKey(s), codec);
    }

    public <V> RQueue<V> getQueue(String s) {
        return redissonClient.getQueue(makeKey(s));
    }

    public <V> RDelayedQueue<V> getDelayedQueue(RQueue<V> rQueue) {
        return redissonClient.getDelayedQueue(rQueue);
    }

    public <V> RQueue<V> getQueue(String s, Codec codec) {
        return redissonClient.getQueue(makeKey(s), codec);
    }

    public <V> RPriorityQueue<V> getPriorityQueue(String s) {
        return redissonClient.getPriorityQueue(makeKey(s));
    }

    public <V> RPriorityQueue<V> getPriorityQueue(String s, Codec codec) {
        return redissonClient.getPriorityQueue(makeKey(s), codec);
    }

    public <V> RPriorityBlockingQueue<V> getPriorityBlockingQueue(String s) {
        return redissonClient.getPriorityBlockingQueue(makeKey(s));
    }

    public <V> RPriorityBlockingQueue<V> getPriorityBlockingQueue(String s, Codec codec) {
        return redissonClient.getPriorityBlockingQueue(makeKey(s), codec);
    }

    public <V> RPriorityBlockingDeque<V> getPriorityBlockingDeque(String s) {
        return redissonClient.getPriorityBlockingDeque(makeKey(s));
    }

    public <V> RPriorityBlockingDeque<V> getPriorityBlockingDeque(String s, Codec codec) {
        return redissonClient.getPriorityBlockingDeque(makeKey(s), codec);
    }

    public <V> RPriorityDeque<V> getPriorityDeque(String s) {
        return redissonClient.getPriorityDeque(makeKey(s));
    }

    public <V> RPriorityDeque<V> getPriorityDeque(String s, Codec codec) {
        return redissonClient.getPriorityDeque(makeKey(s), codec);
    }

    public <V> RBlockingQueue<V> getBlockingQueue(String s) {
        return redissonClient.getBlockingQueue(makeKey(s));
    }

    public <V> RBlockingQueue<V> getBlockingQueue(String s, Codec codec) {
        return redissonClient.getBlockingQueue(makeKey(s), codec);
    }

    public <V> RBoundedBlockingQueue<V> getBoundedBlockingQueue(String s) {
        return redissonClient.getBoundedBlockingQueue(makeKey(s));
    }

    public <V> RBoundedBlockingQueue<V> getBoundedBlockingQueue(String s, Codec codec) {
        return redissonClient.getBoundedBlockingQueue(makeKey(s), codec);
    }

    public <V> RDeque<V> getDeque(String s) {
        return redissonClient.getDeque(makeKey(s));
    }

    public <V> RDeque<V> getDeque(String s, Codec codec) {
        return redissonClient.getDeque(makeKey(s), codec);
    }

    public <V> RBlockingDeque<V> getBlockingDeque(String s) {
        return redissonClient.getBlockingDeque(makeKey(s));
    }

    public <V> RBlockingDeque<V> getBlockingDeque(String s, Codec codec) {
        return redissonClient.getBlockingDeque(makeKey(s), codec);
    }

    public RAtomicLong getAtomicLong(String s) {
        return redissonClient.getAtomicLong(makeKey(s));
    }

    public RAtomicDouble getAtomicDouble(String s) {
        return redissonClient.getAtomicDouble(makeKey(s));
    }

    public RLongAdder getLongAdder(String s) {
        return redissonClient.getLongAdder(makeKey(s));
    }

    public RDoubleAdder getDoubleAdder(String s) {
        return redissonClient.getDoubleAdder(makeKey(s));
    }

    public RCountDownLatch getCountDownLatch(String s) {
        return redissonClient.getCountDownLatch(makeKey(s));
    }

    public RBitSet getBitSet(String s) {
        return redissonClient.getBitSet(makeKey(s));
    }

    public <V> RBloomFilter<V> getBloomFilter(String s) {
        return redissonClient.getBloomFilter(makeKey(s));
    }

    public <V> RBloomFilter<V> getBloomFilter(String s, Codec codec) {
        return redissonClient.getBloomFilter(makeKey(s), codec);
    }

    public RScript getScript() {
        return redissonClient.getScript();
    }

    public RScript getScript(Codec codec) {
        return redissonClient.getScript(codec);
    }

    public RScheduledExecutorService getExecutorService(String s) {
        return redissonClient.getExecutorService(makeKey(s));
    }

    public RScheduledExecutorService getExecutorService(String s, ExecutorOptions executorOptions) {
        return redissonClient.getExecutorService(makeKey(s), executorOptions);
    }

    public RScheduledExecutorService getExecutorService(Codec codec, String s) {
        return redissonClient.getExecutorService(makeKey(s), codec);
    }

    public RScheduledExecutorService getExecutorService(String s, Codec codec) {
        return redissonClient.getExecutorService(makeKey(s), codec);
    }

    public RScheduledExecutorService getExecutorService(String s, Codec codec, ExecutorOptions executorOptions) {
        return redissonClient.getExecutorService(makeKey(s), codec, executorOptions);
    }

    public RRemoteService getRemoteService() {
        return redissonClient.getRemoteService();
    }

    public RRemoteService getRemoteService(Codec codec) {
        return redissonClient.getRemoteService(codec);
    }

    public RRemoteService getRemoteService(String s) {
        return redissonClient.getRemoteService(makeKey(s));
    }

    public RRemoteService getRemoteService(String s, Codec codec) {
        return redissonClient.getRemoteService(makeKey(s), codec);
    }

    public RTransaction createTransaction(TransactionOptions transactionOptions) {
        return redissonClient.createTransaction(transactionOptions);
    }

    public RBatch createBatch(BatchOptions batchOptions) {
        return redissonClient.createBatch(batchOptions);
    }

    public RBatch createBatch() {
        return redissonClient.createBatch();
    }

    public RKeys getKeys() {
        return redissonClient.getKeys();
    }

    public RLiveObjectService getLiveObjectService() {
        return redissonClient.getLiveObjectService();
    }

    public void shutdown() {
        redissonClient.shutdown();
    }

    public void shutdown(long l, long l1, TimeUnit timeUnit) {
        redissonClient.shutdown(l, l1, timeUnit);
    }

    public Config getConfig() {
        return redissonClient.getConfig();
    }

    public NodesGroup<Node> getNodesGroup() {
        return redissonClient.getNodesGroup();
    }

    public ClusterNodesGroup getClusterNodesGroup() {
        return redissonClient.getClusterNodesGroup();
    }

    public boolean isShutdown() {
        return redissonClient.isShutdown();
    }

    public boolean isShuttingDown() {
        return redissonClient.isShuttingDown();
    }
}

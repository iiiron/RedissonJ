import net.noboard.redissonJ.RedissonJClientProxy;
import org.redisson.api.*;
import org.redisson.client.codec.Codec;
import org.redisson.config.Config;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] a) {

        RedissonClient redissonClient = new RedissonJClientProxy().bind(new RedissonClient() {
            public <K, V> RStream<K, V> getStream(String s) {
                return null;
            }

            public <K, V> RStream<K, V> getStream(String s, Codec codec) {
                return null;
            }

            public RRateLimiter getRateLimiter(String s) {
                return null;
            }

            public RBinaryStream getBinaryStream(String s) {
                return null;
            }

            public <V> RGeo<V> getGeo(String s) {
                return null;
            }

            public <V> RGeo<V> getGeo(String s, Codec codec) {
                return null;
            }

            public <V> RSetCache<V> getSetCache(String s) {
                return null;
            }

            public <V> RSetCache<V> getSetCache(String s, Codec codec) {
                return null;
            }

            public <K, V> RMapCache<K, V> getMapCache(String s, Codec codec) {
                return null;
            }

            public <K, V> RMapCache<K, V> getMapCache(String s, Codec codec, MapOptions<K, V> mapOptions) {
                return null;
            }

            public <K, V> RMapCache<K, V> getMapCache(String s) {
                return null;
            }

            public <K, V> RMapCache<K, V> getMapCache(String s, MapOptions<K, V> mapOptions) {
                return null;
            }

            public <V> RBucket<V> getBucket(String s) {
                return new RBucket<V>() {
                    public long size() {
                        return 0;
                    }

                    public V get() {
                        return null;
                    }

                    public V getAndDelete() {
                        return null;
                    }

                    public boolean trySet(V v) {
                        return false;
                    }

                    public boolean trySet(V v, long l, TimeUnit timeUnit) {
                        return false;
                    }

                    public boolean compareAndSet(V v, V v1) {
                        return false;
                    }

                    public V getAndSet(V v) {
                        return null;
                    }

                    public V getAndSet(V v, long l, TimeUnit timeUnit) {
                        return null;
                    }

                    public void set(V v) {

                    }

                    public void set(V v, long l, TimeUnit timeUnit) {

                    }

                    public RFuture<Long> sizeAsync() {
                        return null;
                    }

                    public RFuture<V> getAsync() {
                        return null;
                    }

                    public RFuture<V> getAndDeleteAsync() {
                        return null;
                    }

                    public RFuture<Boolean> trySetAsync(V v) {
                        return null;
                    }

                    public RFuture<Boolean> trySetAsync(V v, long l, TimeUnit timeUnit) {
                        return null;
                    }

                    public RFuture<Boolean> compareAndSetAsync(V v, V v1) {
                        return null;
                    }

                    public RFuture<V> getAndSetAsync(V v) {
                        return null;
                    }

                    public RFuture<V> getAndSetAsync(V v, long l, TimeUnit timeUnit) {
                        return null;
                    }

                    public RFuture<Void> setAsync(V v) {
                        return null;
                    }

                    public RFuture<Void> setAsync(V v, long l, TimeUnit timeUnit) {
                        return null;
                    }

                    public boolean expire(long l, TimeUnit timeUnit) {
                        return false;
                    }

                    public boolean expireAt(long l) {
                        return false;
                    }

                    public boolean expireAt(Date date) {
                        return false;
                    }

                    public boolean clearExpire() {
                        return false;
                    }

                    public long remainTimeToLive() {
                        return 0;
                    }

                    public RFuture<Boolean> expireAsync(long l, TimeUnit timeUnit) {
                        return null;
                    }

                    public RFuture<Boolean> expireAtAsync(Date date) {
                        return null;
                    }

                    public RFuture<Boolean> expireAtAsync(long l) {
                        return null;
                    }

                    public RFuture<Boolean> clearExpireAsync() {
                        return null;
                    }

                    public RFuture<Long> remainTimeToLiveAsync() {
                        return null;
                    }

                    public long sizeInMemory() {
                        return 0;
                    }

                    public void restore(byte[] bytes) {

                    }

                    public void restore(byte[] bytes, long l, TimeUnit timeUnit) {

                    }

                    public void restoreAndReplace(byte[] bytes) {

                    }

                    public void restoreAndReplace(byte[] bytes, long l, TimeUnit timeUnit) {

                    }

                    public byte[] dump() {
                        return new byte[0];
                    }

                    public boolean touch() {
                        return false;
                    }

                    public void migrate(String s, int i, int i1, long l) {

                    }

                    public void copy(String s, int i, int i1, long l) {

                    }

                    public boolean move(int i) {
                        return false;
                    }

                    public String getName() {
                        return null;
                    }

                    public boolean delete() {
                        return false;
                    }

                    public boolean unlink() {
                        return false;
                    }

                    public void rename(String s) {

                    }

                    public boolean renamenx(String s) {
                        return false;
                    }

                    public boolean isExists() {
                        return false;
                    }

                    public Codec getCodec() {
                        return null;
                    }

                    public int addListener(ObjectListener objectListener) {
                        return 0;
                    }

                    public void removeListener(int i) {

                    }

                    public RFuture<Long> sizeInMemoryAsync() {
                        return null;
                    }

                    public RFuture<Void> restoreAsync(byte[] bytes) {
                        return null;
                    }

                    public RFuture<Void> restoreAsync(byte[] bytes, long l, TimeUnit timeUnit) {
                        return null;
                    }

                    public RFuture<Void> restoreAndReplaceAsync(byte[] bytes) {
                        return null;
                    }

                    public RFuture<Void> restoreAndReplaceAsync(byte[] bytes, long l, TimeUnit timeUnit) {
                        return null;
                    }

                    public RFuture<byte[]> dumpAsync() {
                        return null;
                    }

                    public RFuture<Boolean> touchAsync() {
                        return null;
                    }

                    public RFuture<Void> migrateAsync(String s, int i, int i1, long l) {
                        return null;
                    }

                    public RFuture<Void> copyAsync(String s, int i, int i1, long l) {
                        return null;
                    }

                    public RFuture<Boolean> moveAsync(int i) {
                        return null;
                    }

                    public RFuture<Boolean> deleteAsync() {
                        return null;
                    }

                    public RFuture<Boolean> unlinkAsync() {
                        return null;
                    }

                    public RFuture<Void> renameAsync(String s) {
                        return null;
                    }

                    public RFuture<Boolean> renamenxAsync(String s) {
                        return null;
                    }

                    public RFuture<Boolean> isExistsAsync() {
                        return null;
                    }

                    public RFuture<Integer> addListenerAsync(ObjectListener objectListener) {
                        return null;
                    }

                    public RFuture<Void> removeListenerAsync(int i) {
                        return null;
                    }
                };
            }

            public <V> RBucket<V> getBucket(String s, Codec codec) {
                return null;
            }

            public RBuckets getBuckets() {
                return new RBuckets() {
                    public <V> Map<String, V> get(String... strings) {
                        return null;
                    }

                    public boolean trySet(Map<String, ?> map) {
                        return false;
                    }

                    public void set(Map<String, ?> map) {

                    }

                    public long delete(String... strings) {
                        return 0;
                    }

                    public <V> RFuture<Map<String, V>> getAsync(String... strings) {
                        return null;
                    }

                    public RFuture<Boolean> trySetAsync(Map<String, ?> map) {
                        return null;
                    }

                    public RFuture<Void> setAsync(Map<String, ?> map) {
                        return null;
                    }

                    public RFuture<Long> deleteAsync(String... strings) {
                        return null;
                    }
                };
            }

            public RBuckets getBuckets(Codec codec) {
                return null;
            }

            public <V> RHyperLogLog<V> getHyperLogLog(String s) {
                return null;
            }

            public <V> RHyperLogLog<V> getHyperLogLog(String s, Codec codec) {
                return null;
            }

            public <V> RList<V> getList(String s) {
                return null;
            }

            public <V> RList<V> getList(String s, Codec codec) {
                return null;
            }

            public <K, V> RListMultimap<K, V> getListMultimap(String s) {
                return null;
            }

            public <K, V> RListMultimap<K, V> getListMultimap(String s, Codec codec) {
                return null;
            }

            public <K, V> RListMultimapCache<K, V> getListMultimapCache(String s) {
                return null;
            }

            public <K, V> RListMultimapCache<K, V> getListMultimapCache(String s, Codec codec) {
                return null;
            }

            public <K, V> RLocalCachedMap<K, V> getLocalCachedMap(String s, LocalCachedMapOptions<K, V> localCachedMapOptions) {
                return null;
            }

            public <K, V> RLocalCachedMap<K, V> getLocalCachedMap(String s, Codec codec, LocalCachedMapOptions<K, V> localCachedMapOptions) {
                return null;
            }

            public <K, V> RMap<K, V> getMap(String s) {
                return null;
            }

            public <K, V> RMap<K, V> getMap(String s, MapOptions<K, V> mapOptions) {
                return null;
            }

            public <K, V> RMap<K, V> getMap(String s, Codec codec) {
                return null;
            }

            public <K, V> RMap<K, V> getMap(String s, Codec codec, MapOptions<K, V> mapOptions) {
                return null;
            }

            public <K, V> RSetMultimap<K, V> getSetMultimap(String s) {
                return null;
            }

            public <K, V> RSetMultimap<K, V> getSetMultimap(String s, Codec codec) {
                return null;
            }

            public <K, V> RSetMultimapCache<K, V> getSetMultimapCache(String s) {
                return null;
            }

            public <K, V> RSetMultimapCache<K, V> getSetMultimapCache(String s, Codec codec) {
                return null;
            }

            public RSemaphore getSemaphore(String s) {
                return null;
            }

            public RPermitExpirableSemaphore getPermitExpirableSemaphore(String s) {
                return null;
            }

            public RLock getLock(String s) {
                return null;
            }

            public RLock getMultiLock(RLock... rLocks) {
                return null;
            }

            public RLock getRedLock(RLock... rLocks) {
                return null;
            }

            public RLock getFairLock(String s) {
                return null;
            }

            public RReadWriteLock getReadWriteLock(String s) {
                return null;
            }

            public <V> RSet<V> getSet(String s) {
                return null;
            }

            public <V> RSet<V> getSet(String s, Codec codec) {
                return null;
            }

            public <V> RSortedSet<V> getSortedSet(String s) {
                return null;
            }

            public <V> RSortedSet<V> getSortedSet(String s, Codec codec) {
                return null;
            }

            public <V> RScoredSortedSet<V> getScoredSortedSet(String s) {
                return null;
            }

            public <V> RScoredSortedSet<V> getScoredSortedSet(String s, Codec codec) {
                return null;
            }

            public RLexSortedSet getLexSortedSet(String s) {
                return null;
            }

            public RTopic getTopic(String s) {
                return null;
            }

            public RTopic getTopic(String s, Codec codec) {
                return null;
            }

            public RPatternTopic getPatternTopic(String s) {
                return null;
            }

            public RPatternTopic getPatternTopic(String s, Codec codec) {
                return null;
            }

            public <V> RQueue<V> getQueue(String s) {
                return null;
            }

            public <V> RDelayedQueue<V> getDelayedQueue(RQueue<V> rQueue) {
                return null;
            }

            public <V> RQueue<V> getQueue(String s, Codec codec) {
                return null;
            }

            public <V> RPriorityQueue<V> getPriorityQueue(String s) {
                return null;
            }

            public <V> RPriorityQueue<V> getPriorityQueue(String s, Codec codec) {
                return null;
            }

            public <V> RPriorityBlockingQueue<V> getPriorityBlockingQueue(String s) {
                return null;
            }

            public <V> RPriorityBlockingQueue<V> getPriorityBlockingQueue(String s, Codec codec) {
                return null;
            }

            public <V> RPriorityBlockingDeque<V> getPriorityBlockingDeque(String s) {
                return null;
            }

            public <V> RPriorityBlockingDeque<V> getPriorityBlockingDeque(String s, Codec codec) {
                return null;
            }

            public <V> RPriorityDeque<V> getPriorityDeque(String s) {
                return null;
            }

            public <V> RPriorityDeque<V> getPriorityDeque(String s, Codec codec) {
                return null;
            }

            public <V> RBlockingQueue<V> getBlockingQueue(String s) {
                return null;
            }

            public <V> RBlockingQueue<V> getBlockingQueue(String s, Codec codec) {
                return null;
            }

            public <V> RBoundedBlockingQueue<V> getBoundedBlockingQueue(String s) {
                return null;
            }

            public <V> RBoundedBlockingQueue<V> getBoundedBlockingQueue(String s, Codec codec) {
                return null;
            }

            public <V> RDeque<V> getDeque(String s) {
                return null;
            }

            public <V> RDeque<V> getDeque(String s, Codec codec) {
                return null;
            }

            public <V> RBlockingDeque<V> getBlockingDeque(String s) {
                return null;
            }

            public <V> RBlockingDeque<V> getBlockingDeque(String s, Codec codec) {
                return null;
            }

            public RAtomicLong getAtomicLong(String s) {
                return null;
            }

            public RAtomicDouble getAtomicDouble(String s) {
                return null;
            }

            public RLongAdder getLongAdder(String s) {
                return null;
            }

            public RDoubleAdder getDoubleAdder(String s) {
                return null;
            }

            public RCountDownLatch getCountDownLatch(String s) {
                return null;
            }

            public RBitSet getBitSet(String s) {
                return null;
            }

            public <V> RBloomFilter<V> getBloomFilter(String s) {
                return null;
            }

            public <V> RBloomFilter<V> getBloomFilter(String s, Codec codec) {
                return null;
            }

            public RScript getScript() {
                return null;
            }

            public RScript getScript(Codec codec) {
                return null;
            }

            public RScheduledExecutorService getExecutorService(String s) {
                return null;
            }

            public RScheduledExecutorService getExecutorService(String s, ExecutorOptions executorOptions) {
                return null;
            }

            public RScheduledExecutorService getExecutorService(Codec codec, String s) {
                return null;
            }

            public RScheduledExecutorService getExecutorService(String s, Codec codec) {
                return null;
            }

            public RScheduledExecutorService getExecutorService(String s, Codec codec, ExecutorOptions executorOptions) {
                return null;
            }

            public RRemoteService getRemoteService() {
                return null;
            }

            public RRemoteService getRemoteService(Codec codec) {
                return null;
            }

            public RRemoteService getRemoteService(String s) {
                return null;
            }

            public RRemoteService getRemoteService(String s, Codec codec) {
                return null;
            }

            public RTransaction createTransaction(TransactionOptions transactionOptions) {
                return null;
            }

            public RBatch createBatch(BatchOptions batchOptions) {
                return null;
            }

            public RBatch createBatch() {
                return null;
            }

            public RKeys getKeys() {
                return null;
            }

            public RLiveObjectService getLiveObjectService() {
                return null;
            }

            public void shutdown() {

            }

            public void shutdown(long l, long l1, TimeUnit timeUnit) {

            }

            public Config getConfig() {
                return null;
            }

            public NodesGroup<Node> getNodesGroup() {
                return null;
            }

            public ClusterNodesGroup getClusterNodesGroup() {
                return null;
            }

            public boolean isShutdown() {
                return false;
            }

            public boolean isShuttingDown() {
                return false;
            }
        },"TEST");
        redissonClient.getBucket(":AAA:p:p:User:123:141").get();
        redissonClient.getBucket("stadu1231").get();
        redissonClient.getBucket(":::stadu1231").get();
        redissonClient.getBucket(":o:p:hello").get();
        redissonClient.getBucket(":p:p:hello").get();
        redissonClient.getBuckets().get("as");
    }
}

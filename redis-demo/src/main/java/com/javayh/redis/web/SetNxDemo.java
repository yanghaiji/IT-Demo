//package com.javayh.redis.web;
//
//import com.javayh.redis.config.RedisKey;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * <p>
// * redis 实现分布式锁的演进
// * </p>
// *
// * @author Dylan
// * @version 1.0.0
// * @since 2021-07-07
// */
//@RestController
//@RequestMapping(value = "/demo/")
//public class SetNxDemo {
//
//    @Autowired
//    @Qualifier(value = "redisTemplate")
//    private RedisTemplate redisTemplate;
//
//    @GetMapping(value = "test")
//    public void test() {
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
//        try {
//            order();
//        }finally {
//            reentrantLock.unlock();
//        }
//    }
//
//    @GetMapping(value = "test2")
//    public void test2() {
//        // 这里如果多线程 一个线程 占有了锁，但是 由于 某种因素，在try里的执行到出错，但是这样就造成了死锁
//        Boolean javayh = redisTemplate.opsForValue().setIfAbsent(RedisKey.key("redis-order-lock"), "javayh");
//        try {
//            if (javayh) {
//                order();
//            }//实现自旋
//            else {
//                test2();
//            }
//        } finally {
//            redisTemplate.delete(RedisKey.key("redis-order-lock"));
//        }
//    }
//
//    @GetMapping(value = "test3")
//    public void test3() {
//        String key = RedisKey.key("redis-order-lock");
//        // 上面的代码 没有办法释放锁，那好，我们给他指定失效时间，但是这里有没有坑呢
//        Boolean javayh = redisTemplate.opsForValue().setIfAbsent(key, "javayh");
//        try {
//            // 这里也有问题，如果我们还是由于某种原因导致下边的设置过期时间及其一下的代码没有执行，这又会死锁
//            // 那我们将加锁和设置失效时间的代码放在一起就可以
//            redisTemplate.expire(key, 30, TimeUnit.SECONDS);
//            if (javayh) {
//                order();
//            }//实现自旋
//            else {
//                test3();
//            }
//        } finally {
//            redisTemplate.delete(key);
//        }
//    }
//
//    @GetMapping(value = "test4")
//    public void test4() {
//        // 上面的代码 没有办法释放锁，那我们将加锁和设置失效时间的代码放在一起就可以
//        // 这样好像看似没什么问题了，但是确实是这样吗？
//        // 我们在来分析一下：
//        // 加入 这是有三个线程，其中一个线程获取了锁，执行了起来，但是性能很慢，超过了我们的过期时间，
//        // 这时锁已经被释放，其他线程就可以进行获取锁，但是当第一个线程执行完业务逻辑，想要删除这把锁、，
//        // 这时就会吧其他线程锁住的资源进行释放了，这也是坑
//        // 根据上面的分析，我们可以将key重新设置一下，修改后的代码
//        String val = RedisKey.key("redis-order-lock") + UUID.randomUUID().toString();
//        Boolean javayh = redisTemplate.opsForValue().setIfAbsent( "javayh", val,30, TimeUnit.SECONDS);
//        try {
//            if (javayh) {
//                order();
//            }//实现自旋
//            else {
//                test4();
//            }
//        } finally {
//            //看似没有问题，但是根据官方的建议不要直接使用del，那么我们也按照官方的方式进行
//            Object o = redisTemplate.opsForValue().get("javayh");
//            if (o.equals(val)) {
//                redisTemplate.delete("javayh");
//            }
//        }
//    }
//
//    @GetMapping(value = "test5")
//    public void test5() {
//        // 这里看似ok。我们先不看
//        String val = RedisKey.key("redis-order-lock") + UUID.randomUUID().toString();
//        Boolean javayh = redisTemplate.opsForValue().setIfAbsent( "javayh", val,30000, TimeUnit.SECONDS);
//        try {
//            if (javayh) {
//                order();
//            }//实现自旋
//            else {
//                test2();
//            }
//        } finally {
//            // 官方建议使用脚本操作
//            String script = "if redis.call( 'get' ,KEYS[1]) == ARGV[1] " +
//                    "then " +
//                    "    return redis.call('del',KEYS[1]) " +
//                    "else " +
//                    "    return 0 " +
//                    "end";
//            redisTemplate.execute(new DefaultRedisScript<>(script, Long.class), Arrays.asList("javayh"), val);
//        }
//    }
//
//    private void order() {
//        // 这里进行业务处理，进行下订单，减库存
//    }
//}

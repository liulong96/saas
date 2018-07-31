package com.power.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Long on 2018/7/31.
 */
public class jedisDemo1 {

    public  void demo1(){
        //设置IP 地址和端口
        Jedis jedis=new Jedis("192.168.42.128",6379);
        //保存数据
        jedis.set("name","liulong");
        //获取数据
        String value=jedis.get("name");
        System.out.println(value);
        //释放资源
        jedis.close();
    }

    //连接池
    public void demo2(){
        //获得连接池配置对象
        JedisPoolConfig config=new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(30);
        //设置最大空间连接数
        config.setMaxIdle(10);

        //获得连接池
        JedisPool jedisPool=new JedisPool(config,"192.168.42.128",6379);
        //获得核心对象
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            //存
            jedis.set("name","张三");
            //取
           String value= jedis.get("name");
           System.out.println(value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null!=jedis){
                jedis.close();
            }
            if (null!=jedisPool){
                jedisPool.close();
            }
        }
    }

    public static void main(String[] args) {
        jedisDemo1 jedisDemo=new jedisDemo1();
        jedisDemo.demo2();
    }
}

package com.power.jedis;

import redis.clients.jedis.Jedis;

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
}

package com.luckyrui.test.mongodb;


import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
 
// 数据库工具类
public class MongoDBManager
{
    private static Mongo mongo = null;
     
    private static String DBString = "MongoDBTest";// 数据库名

    private static String hostName = "localhost";// 主机名

    private static int port = 27017;// 端口号

    private static int poolSize = 30;// 连接池大小
     
    private MongoDBManager()
    {

    }
     
    // 获取数据库连接
    public static DB getDB()
    {
        if (mongo == null)
        {
            init();
        }

        return mongo.getDB(DBString);
    }
     
     
    // 初始化数据库
    private static void init()
    {
        try
        {
            // 实例化Mongo
            mongo = new Mongo(hostName, port);
            MongoOptions opt = mongo.getMongoOptions();
            // 设置连接池大小
            opt.connectionsPerHost = poolSize;
        }
        catch (UnknownHostException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
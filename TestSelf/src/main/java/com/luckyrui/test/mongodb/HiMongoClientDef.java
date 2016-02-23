package com.luckyrui.test.mongodb;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.luckyrui.test.unit.HiProperty;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoOptions;
import com.mongodb.WriteResult;

@SuppressWarnings("deprecation")
public class HiMongoClientDef
{

    static private final HiProperty prop = new HiProperty("mongo.properties");

    static public final int PAGE_SIZE_DEF = Integer.valueOf(prop
            .getProperty("PAGE_SIZE") != null ? prop.getProperty("PAGE_SIZE")
            : "30");

    public  HiMongoClientDef(HiProperty prop){
    	if(prop==null)
    		init(null);
    	else
    		init(prop);
    }
    
    public HiMongoClientDef()
    {
    	init(null);
    }
    
    /**
     * 初始化
     * @param param
     */
	private void init(HiProperty param){
    	if(param == null)
    		param = prop;
    	try
        {
            MongoClient mc = new MongoClient(
                    (String) param.getProperty("mongo.host"),
                    Integer.parseInt(param.getProperty("mongo.port")));
            MongoOptions options = mc.getMongoOptions();
            options.connectionsPerHost = Integer.parseInt(param
                    .getProperty("mongo.poolSize"));
            options.connectTimeout = Integer.parseInt(param
                    .getProperty("mongo.conn.timeout"));
            setMongoClient(mc);
            setDbName(param.getProperty("mongo.dbName"));

        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
    }

    private MongoClient mongoClient;

    public void setMongoClient(MongoClient mongoClient)
    {
        this.mongoClient = mongoClient;
    }

    /**
     * 库名称
     */
    private String dbName;

    /**
     * 设置 库名称
     * 
     * @param dbName
     * @author Xue Chen Time ：2015年6月29日 下午2:57:09
     */
    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }

    /**
     * 获得DB连接对象
     * 
     * @param table
     * @return
     * @author Xue Chen Time ：2015年6月29日 下午2:57:34
     */
    public DBCollection getCollection(String table)
    {
        DB db = mongoClient.getDB(dbName);
        return db.getCollection(table);
    }
    
    public Set<String> getCollectionsName()
    {
        DB db = mongoClient.getDB(dbName);
        return db.getCollectionNames();
    }

    /**
     * 插入一条数据
     * 
     * @param table
     * @param data
     * @author Xue Chen Time ：2015年6月29日 下午2:58:12
     */
    public void insert(String table, Map<String, Object> data)
    {
        BasicDBObject doc = new BasicDBObject(data);
        DBCollection dbc = this.getCollection(table);
        dbc.insert(doc);
    }

    private void insert(String table, String jsonData)
    {
        BasicDBObject doc = (BasicDBObject) JSON.parseObject(jsonData,
                BasicDBObject.class);
        DBCollection dbc = this.getCollection(table);
        dbc.insert(doc);

    }

    /**
     * 
     * @param table
     * @param doc
     * @author Xue Chen Time ：2015年6月29日 下午2:46:27
     */
    public <T> void insert(String table, T data)
    {
        String json = null;
        if (data instanceof String)
        {
            json = ((String) data).trim();
            if (false == (json.startsWith("{") && json.endsWith("}")))
            {

                String t = json.length() > 20 ? json.substring(0, 20) : json;

                throw new RuntimeException("Invalidate json format data: " + t);
            }

        }
        else
        {
            json = JSON.toJSONString(data);
        }
        insert(table, json);
    }

    /**
     * 
     * @param table
     * @param doc
     * @author Xue Chen Time ：2015年6月29日 下午2:46:27
     */
    public void insert(String table, BasicDBObject doc)
    {
        DBCollection dbc = this.getCollection(table);
        dbc.insert(doc);
    }

    /**
     * 
     * @param table
     * @param data
     * @param cls
     * @return
     * @author Xue Chen Time ：2015年6月29日 下午2:46:22
     */
    public <T> T findOne(String table, Map<String, Object> data, Class<T> cls)
    {
        DBCollection dbc = this.getCollection(table);
        BasicDBObject doc = new BasicDBObject(data);
        DBObject rs = dbc.findOne(doc);
        if (rs != null)
        {
            String json = rs.toString();

            return JSON.parseObject(json, cls);
        }

        return null;

    }

    /**
     * 
     * @param table
     * @param condition
     * @return
     * @throws Exception
     * @author Xue Chen Time ：2015年6月29日 下午2:46:18
     */
    public List<Map<String, Object>> find(String table,
            Map<String, Object> condition) throws Exception
    {
        DBCollection dbc = this.getCollection(table);
        BasicDBObject doc = new BasicDBObject(condition);
        DBCursor cur = dbc.find(doc);
        List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
        try
        {
            while (cur.hasNext())
            {
                rs.add(cur.next().toMap());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            cur.close();
        }
        return rs;
    }

    /**
     * 
     * @param table
     * @param condition
     * @param cls
     * @return
     * @throws Exception
     * @author Xue Chen Time ：2015年6月29日 下午2:46:14
     */
    public <T> List<T> find(String table, Map<String, Object> condition,
            Class<T> cls) throws Exception
    {
        DBCollection dbc = this.getCollection(table);
        BasicDBObject doc = new BasicDBObject(condition);
        DBCursor cur = dbc.find(doc);
        try
        {
            List<T> rs = new ArrayList<T>();
            while (cur.hasNext())
            {
                String json = cur.next().toString();
                T t = JSON.parseObject(json, cls);
                rs.add(t);
            }
            return rs;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            cur.close();
        }
        return null;
    }
    
    /**
     * 获得游标里的数据
     * 
     * @param cur
     * @param cls
     * @return
     * @author cr
     */
    public <T> List<T> getList(DBCursor cur, Class<T> cls)
    {
        List<T> rs = new ArrayList<T>();
        try
        {
            while (cur.hasNext())
            {
                String json = cur.next().toString();
                T t = JSON.parseObject(json, cls);
                rs.add(t);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            cur.close();
        }
        return rs;
    }

    /**
     * 
     * @param table
     * @param condition
     * @return
     * @author Xue Chen Time ：2015年6月29日 下午2:46:08
     */
    public int delete(String table, Map<String, Object> condition)
    {
        DBCollection dbc = this.getCollection(table);
        BasicDBObject doc = new BasicDBObject(condition);

        WriteResult rs = dbc.remove(doc);
        return rs.getN();
    }

    /**
     * 获得游标里的数据
     * 
     * @param cur
     * @param cls
     * @return
     * @author Xue Chen Time ：2015年7月13日 下午6:46:28
     */
    public <T> List<T> getList(DBCursor cur, int page, Class<T> cls)
    {
        return getList(cur, page, PAGE_SIZE_DEF, cls);
    }

    /**
     * 获得游标里的数据
     * 
     * @param cur
     * @param cls
     * @return
     * @author Xue Chen Time ：2015年7月13日 下午6:46:28
     */
    public <T> List<T> getList(DBCursor cur, int page, int pageSize,
            Class<T> cls)
    {
        if (page == 0)
            throw new RuntimeException("起始页为1");
        if (page > 0)
        {
            cur.skip((page - 1) * pageSize).limit(pageSize);
        }
        List<T> rs = new ArrayList<T>();
        try
        {
            while (cur.hasNext())
            {
                String json = cur.next().toString();
                T t = JSON.parseObject(json, cls);
                rs.add(t);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            cur.close();
        }
        return rs;
    }


}

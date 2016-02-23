package com.luckyrui.test.mongodb;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMongo
{
    public static void main(String[] args)
    {
        HiMongoClientDef mongo = new HiMongoClientDef();
        try
        {
            List<Map<String, Object>> rtn = mongo.find("RptDailyGiveDetail",
                    new HashMap<String, Object>());
            System.out.println(rtn);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

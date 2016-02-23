package com.luckyrui.test.transfer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.luckyrui.test.mongodb.HiMongoClientDef;
import com.luckyrui.test.unit.HiProperty;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MongodbTransferHandler {

	private <T> void setDataToTarget(List<T> data) {
		HiMongoClientDef targetMongo = new HiMongoClientDef(new HiProperty("/target.properties"));
		for (T t : data) {
			System.out.println("insert into "+t.getClass().getName());
			targetMongo.insert(t.getClass().getSimpleName(), t);
		}
	}

	@SuppressWarnings("rawtypes")
	private Map<String, List> getDataFromSource()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Map<String, List> rtn = new HashMap<String, List>();
		HiMongoClientDef targetMongo = new HiMongoClientDef(new HiProperty("/source.properties"));
		Set<String> names = targetMongo.getCollectionsName();
		for (String tableName : names) {
			System.out.println(tableName);
			DBCollection collection = targetMongo.getCollection(tableName);
			DBCursor cur = collection.find();
			Class<?> c = null;
			try {
				c = Class.forName("com.luckyrui.test.model." + tableName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				continue;
			}
			List data = targetMongo.getList(cur, c.newInstance().getClass());
			rtn.put(tableName, data);
		}
		return rtn;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void transfer() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Map<String, List> datas = getDataFromSource();
		for (String key : datas.keySet()) {
			setDataToTarget(datas.get(key));
		}
	}
}

package com.hapi.jdkdynamic;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by helo on 2018/12/12.
 */
public class HPSqlSession {

    private static Map<String,String> mapCache = new ConcurrentHashMap<>();
    static {
        System.out.println("ɨ��mapper����������");
        mapCache.put("com.hapi.jdkdynamic.TestMapper.selectNameById","select * from user where id = 1");
        mapCache.put("com.hapi.jdkdynamic.TestMapper.selectNameByNo","select * from user where no = zs");
        mapCache.put("com.hapi.jdkdynamic.OrderMapper.insertOrder","insert t_user (id,name) value (1,ls)");
        System.out.println("ɨ�����");
    }

    public HPSqlSession() {
    }

    public <T> T getMapper(Class<T> clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new MyInvokeHandler(clazz,this));
    }

    public Object excutor( String key){
        String sql = mapCache.get(key);
        System.out.println("Ҫִ�е�sql:" + sql);
        return 1;
    }
}

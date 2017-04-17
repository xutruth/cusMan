package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {
	public static <E> E request2Bean(HttpServletRequest request, Class<E> beanClass) {

        try {
        	//获得实例对象
            E bean = beanClass.newInstance();

            // 得到request里面所有数据
            Map<String, String[]> map = request.getParameterMap();
           for(Map.Entry<String,String[]> entry:map.entrySet()){
        	   System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
           }

            // 注册一个转换器
            ConvertUtils.register(new Converter() {

                @Override
                public <T> T convert(Class<T> type, Object value) {
                    if (value==null) {
                        return null;
                    }
                    String str = (String)value;
                    System.out.println(str+"----------------------");
                    if (str.trim().equals("")) {
                        return null;
                    }

                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        return (T) df.parse(str);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, Date.class);

            BeanUtils.populate(bean, map); // map{name=aa,password=abc,birthday=1990-10-09}     bean(name=aa,password=abc,birthday=Date)         
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // 产生全球唯一的id
    public static String generateID() {
        return UUID.randomUUID().toString(); // UUID算法根据你系统的网卡的xx地址、CPU、机器的型号等等生成一个128位长的字符串，可以确保是全球唯一的。
    }
}

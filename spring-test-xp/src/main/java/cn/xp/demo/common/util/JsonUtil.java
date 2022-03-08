package cn.xp.demo.common.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 提供json操作相关方法
 * @author Administrator
 *
 */
public class JsonUtil {

    /**
     * @Description：通过fastjson生成json格式字符串
     * @date：2014-1-8
     * @param t
     * @return
     */
    public static <T extends Object> String toJsonString(T t) {
        StringBuilder builder = new StringBuilder("");
        builder.append(JSON.toJSONStringWithDateFormat(t, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty,SerializerFeature.DisableCircularReferenceDetect));
        return builder.append("").toString();
    }


    /**
     * @Description：通过fastjson生成json格式字符串
     * @date：2014-1-8
     * @param t
     * @return
     */
    public static <T extends Object> String toJsonStringNoFormat(T t) {
        StringBuilder builder = new StringBuilder("");
        builder.append(JSON.toJSONString(t));
        return builder.append("").toString();
    }


    /**
     * @Description：将json格式的字符串转换成制定的对象
     * @date：2014-1-8
     * @param jsonstr
     * @param ref
     * @return
     * @throws Exception
     */
    public static <T extends Object> T parseToObject(String jsonstr, TypeReference<T> ref) throws Exception {
        try {
            if (jsonstr == null || "".equals(jsonstr.trim())) {
                return null;
            }
            jsonstr = jsonstr.trim();
            return JSONObject.parseObject(jsonstr, ref);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * @Description：将JSON字符串转换为普通Java对象（非数组、无泛型）。
     * @date：2014-10-15
     * @param jsonstr
     * @param clazz
     * @return
     */
    public static <T> T parseToObject(String jsonstr, Class<T> clazz) {
        T result = null;
        try {
            result = JSON.parseObject(jsonstr, clazz);
        } catch (JSONException e) {
            throw e;
        }
        return result;
    }

    /**
     * 将Java对象转换成JSON字符串。
     *
     * <pre>
     *     - 注意事项: 对象中值为null的字段将被过滤掉。
     * </pre>
     * @param object
     *        待转换为JSON字符串的Java对象。
     * @return 转换后的JSON字符串。
     * @author yuanhongbo
     */
    public static String toJSONString(Object object) {
        PropertyFilter filter = new PropertyFilter() {
            public boolean apply(Object source, String name, Object value) {
                if (null == value) {
                    return false;
                }
                return true;
            }
        };

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.getPropertyFilters().add(filter);

        serializer.write(object);

        return out.toString();
    }

}

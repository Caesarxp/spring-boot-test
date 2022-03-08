package cn.xp.demo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: json返回响应处理类（处理将null转化为空）
 * @Author: xp
 * @CreateDate: 2021/1/12 10:56
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
public class MyJsonMapper {

    public static ObjectMapper getObjectMapper(){
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.featuresToDisable(
                SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                String fieldName = gen.getOutputContext().getCurrentName();
                try {
                    //反射获取字段类型
                    Field field = gen.getCurrentValue().getClass().getDeclaredField(fieldName);
                    if (Objects.equals(field.getType(), String.class)) {
                        //字符串型空值""
                        gen.writeString("");
                        return;
                    } else if (Objects.equals(field.getType(), List.class)) {
                        //列表型空值返回[]
                        gen.writeStartArray();
                        gen.writeEndArray();
                        return;
                    } else if (Objects.equals(field.getType(), Map.class)) {
                        //map型空值返回{}
                        gen.writeStartObject();
                        gen.writeEndObject();
                        return;
                    }
                } catch (NoSuchFieldException e) {
                }
                //默认返回""
                gen.writeString("");
            }
        });

        return objectMapper;
    }

}

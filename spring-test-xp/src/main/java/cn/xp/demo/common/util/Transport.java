package cn.xp.demo.common.util;

import com.google.gson.Gson;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Map;

/**
 * 模板转换
 */
public class Transport {
    public static String transform(String template,Map<String, Object> templateMap){
        try {
            //定义StringTemplateLoader
            StringTemplateLoader loader = new StringTemplateLoader();
            loader.putTemplate("content", template);

            //定义Configuration
            Configuration configuration = new Configuration();
            configuration.setTemplateLoader(loader);

            //定义Template
            Template tpl = configuration.getTemplate("content");

            StringWriter writer = new StringWriter();
            tpl.process(templateMap, writer);
            return writer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
         String content = "{{name.DATA}},今年{{age.DATA}}岁，身高{{msg.DATA}}";
         content = content.replace(".DATA","");
         content = content.replace("{{","${data.");
         content = content.replace("}}","}");
        System.out.println(content);
//        String content = "${data.name},今年${data.age}岁，身高${data.msg}";
//        map.put("param", "周思承");

//        JSONUtil.parse()
        String mapJson = "{\n" +
                "    \"data\":{\n" +
                "        \"msg\":\"我不知道\",\n" +
                "        \"age\":\"28\",\n" +
                "        \"name\":\"熊鹏\"\n" +
                "    }\n" +
                "}";
        Gson gson = new Gson();
        Map<String, Object> map  = gson.fromJson(mapJson,Map.class);
        System.out.println(map);
        String transform = Transport.transform(content,map);
        System.out.println(transform);
    }
}

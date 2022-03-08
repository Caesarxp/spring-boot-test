package cn.xp.demo;

import cn.xp.demo.service.ITpShorturlInfoService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TpShorturlInfoServiceTest {
    @Autowired
    private ITpShorturlInfoService shorturlInfoService;
    @Test
    public void queryShortUrl(){
        String code = "001dyi";
        long startTime = System.currentTimeMillis();
        String url  = shorturlInfoService.getUrl(code);
        log.info("获取链接[{}}",url);
        long oneTime = System.currentTimeMillis();
        String twourl  = shorturlInfoService.getUrl(code);
        log.info("获取链接[{}}",twourl);
        long twoTime = System.currentTimeMillis();
        log.info("第一次获取时间：{}",oneTime-startTime);
        log.info("第二次获取时间：{}",twoTime-oneTime);
    }
}

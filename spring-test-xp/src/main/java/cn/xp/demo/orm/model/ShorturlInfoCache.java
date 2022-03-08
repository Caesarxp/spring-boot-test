package cn.xp.demo.orm.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 短链缓存
 */
@Data
public class ShorturlInfoCache implements Serializable {

    private String originalUrl;

    private String shortUrl;

    private Integer urlStatus;

    private LocalDateTime createTime;
}

package cn.xp.demo.service;

import cn.xp.demo.orm.model.entity.TpShorturlInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 短链 服务类
 * </p>
 *
 * @author 熊鹏
 * @since 2022-01-20
 */
public interface ITpShorturlInfoService extends IService<TpShorturlInfo> {
    /**
     * 根据短链码获取长链接
     * @return
     */
    String getUrl(String code);

    void updateUrl(String code, String url);
}

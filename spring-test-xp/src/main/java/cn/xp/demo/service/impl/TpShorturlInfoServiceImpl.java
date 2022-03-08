package cn.xp.demo.service.impl;

import cn.xp.demo.orm.mapper.TpShorturlInfoMapper;
import cn.xp.demo.orm.model.entity.TpShorturlInfo;
import cn.xp.demo.service.ITpShorturlInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 短链 服务实现类
 * </p>
 *
 * @author 熊鹏
 * @since 2022-01-20
 */
@Service
public class TpShorturlInfoServiceImpl extends ServiceImpl<TpShorturlInfoMapper, TpShorturlInfo> implements ITpShorturlInfoService {

    /**
     * 根据短链码获取长链接
     *
     * @param code
     * @return
     */
    @Cacheable(value = "code", key = "#code")
    @Override
    public String getUrl(String code) {
        TpShorturlInfo shorturlInfo = this.lambdaQuery().eq(TpShorturlInfo::getShortUrl,code).one();
        return shorturlInfo.getOriginalUrl();
    }
    @CacheEvict(value="code",key="#code")
    @Override
    public void updateUrl(String code, String url) {
        this.lambdaUpdate().set(TpShorturlInfo::getOriginalUrl,url).eq(TpShorturlInfo::getShortUrl,code).update();
    }
}

package cn.xp.demo.service.impl;

import cn.xp.demo.orm.mapper.BusinessTemplateInfoMapper;
import cn.xp.demo.orm.model.entity.BusinessTemplateInfo;
import cn.xp.demo.service.IBusinessTemplateInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 模板-基本表 服务实现类
 * </p>
 *
 * @author xp
 * @since 2021-03-03
 */
@Service
public class BusinessTemplateInfoServiceImpl extends ServiceImpl<BusinessTemplateInfoMapper, BusinessTemplateInfo> implements IBusinessTemplateInfoService {

}

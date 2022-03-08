package cn.xp.demo.service.impl;

import cn.xp.demo.orm.mapper.UserInfoMapper;
import cn.xp.demo.orm.model.UserInfo;
import cn.xp.demo.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xp
 * @since 2021-01-25
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}

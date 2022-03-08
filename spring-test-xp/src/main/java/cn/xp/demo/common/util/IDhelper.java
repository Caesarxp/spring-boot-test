package cn.xp.demo.common.util;


import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

/**
 * @Description: 分布式id生成
 * @Author: xp
 * @CreateDate: 2020/11/3 17:19
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
public class IDhelper {
    /**
     * 计划分布式
     * @return
     */
    public  static Long getNextId()
    {
        IdentifierGenerator identifierGenerator=new DefaultIdentifierGenerator();
        Number id=  identifierGenerator.nextId(new Object());
        Long nextid = Long.parseLong(id+"");
        return nextid;
    }

}

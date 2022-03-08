package cn.xp.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Description: 基类接口
 * @Author: xp
 * @CreateDate: 2020/6/16 17:27
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
public interface BaseModel extends Serializable {

     LocalDate getCreateTime() ;

     void setCreateTime(LocalDate createTime) ;

     LocalDate getUpdateTime() ;

     void setUpdateTime(LocalDate updateTime) ;
}

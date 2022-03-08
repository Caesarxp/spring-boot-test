package cn.xp.demo.orm.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xp
 * @since 2021-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户邮件
     */
    private String userMail;

    /**
     * 手机号码
     */
    private String userNumber;

    private String loginCode;

    private String loginPass;

    /**
     * 上次登录时间
     */
    private String lastLoginIp;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 登录次数
     */
    private Long loginNum;


}

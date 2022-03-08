package cn.xp.demo.component;


import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 责任链模式实现多支付
 * @Author: xp
 * @CreateDate: 2021/1/14 17:23
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Getter
@Setter
public abstract  class PayHandler {

    protected PayHandler next;

    public abstract void pay(String pay);
}

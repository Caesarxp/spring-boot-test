package cn.xp.demo.service;

import java.util.Map;

/**
 * @Description: 消息转化
 * @Author: xp
 * @CreateDate: 2021/2/20 10:19
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
public interface IMsgContentConversion {
    /**
     * 得到内容，应用信息
     * 获取内容信息，list有多个就是多卡片，其余全是卡片，图片
     * @param contentId
     * @param param
     * @param img
     * @return
     */
//    List<String> getMsgContent(Long contentId, Map<String,Object> reqParam, String[] param, String[] img);

    /**
     * 转化类型
     * @param contentId
     * @param reqParam
     * @param param
     * @param img
     * @return
     */
    String conversionMsgContent(Long contentId, Map<String, Object> reqParam, String[] param, String[] img);
    /**
     * 悬浮菜单
     * @param contentId
     * @param reqParam
     * @return
     */
    String conversionSuggestionMenu(Long contentId, Map<String, Object> reqParam);



}

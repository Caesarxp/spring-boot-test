package cn.xp.demo.entity.vo;

import lombok.Data;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2020/8/25 16:39
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
@Data
public class UserHitokotoVo {
    /**
     * uuid
     * {
     *     "id":6041,
     *     "uuid":"4d4dc771-98ed-4860-a4ab-7ee652dd522a",
     *     "hitokoto":"绝望的人没有故乡。",
     *     "type":"k",
     *     "from":"加缪手记·第二卷",
     *     "from_who":"阿尔贝·加缪",
     *     "creator":"溟YX",
     *     "creator_uid":5965,
     *     "reviewer":1044,
     *     "commit_from":"web",
     *     "created_at":"1587344972",
     *     "length":9
     * }
     */
    private Long id;
    private String uuid;

    /**
     * 名言
     */
    private String hitokoto;

    /**
     * type:类型
     */
    private String type;

    /**
     * 来源
     */
    private String from;

    /**
     * 来源主角
     */
    private String from_who;

    /**
     * 作者
     */
    private String creator;

    /**
     * 作者uuid
     */
    private String creator_uid;

    /**
     * reviewer
     */
    private Long reviewer;

    /**
     * 作者uuid
     */
    private String createdAt;

    /**
     * 长度
     */
    private String length;
    
    private String commit_from;
}

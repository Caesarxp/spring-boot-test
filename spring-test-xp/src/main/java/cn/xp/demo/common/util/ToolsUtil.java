package cn.xp.demo.common.util;

/**
 * @Description: TODO
 * @Author: xp
 * @CreateDate: 2021/3/5 16:18
 * @UpdateUser: 熊鹏
 * @Version: 1.0
 */
public class ToolsUtil {
    final static char array[] =
            { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
                    'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                    'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                    'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                    'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    /**
     * 还是有问题
     * @Description：生成永不重复的随机码
     * 基于雪花id生成的随机码，但是时间回拨还是会出现重复
     * @date：2020-12-16
     *
     */
    public static String getRandomCode(){
        long code = SnowFlakeUtil.getId();
        char[] buf = new char[64];
        int charPos = 64;
        int radix = 1 << 6;
        long mask = radix - 1;
        do {
            buf[--charPos] = array[(int) (code & mask)];
            code >>>= 6;
        } while (code != 0);
        return  new String(buf, charPos, (64 - charPos));
    }
}

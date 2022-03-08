package cn.xp.demo.common.util;

/**
 * 十进制转换62进制算法
 */
public class Base62Utils {

    private static final char[] toBASE62 = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    };

    public static String toBase62(long num) {
        StringBuilder sb = new StringBuilder();
        do {
            int i = (int) (num % 62);
            sb.append(toBASE62[i]);
            num /= 62;
        } while(num > 0);
        return sb.reverse().toString();
    }

}

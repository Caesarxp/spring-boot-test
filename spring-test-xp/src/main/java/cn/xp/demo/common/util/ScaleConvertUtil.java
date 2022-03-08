package cn.xp.demo.common.util;

import org.apache.commons.lang.StringUtils;

/**
 * 转换62进制
 * @author wuqi
 * @date 2021年12月29日 19:46
 */
public class ScaleConvertUtil {
    private static String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // 10进制转62进制
    public static String encoding(long num) {
        if(num < 1)
            throw new IllegalArgumentException("num must be greater than 0.");

        StringBuilder sb = new StringBuilder();
        for (; num > 0; num /= 62) {
            sb.append(ALPHABET.charAt((int) (num % 62)));
        }
        return sb.toString();
    }

    /**
     * 62进制转换,位数不够，补齐6位
      * @param num
     * @param at
     * @return
     */
    public static String encoding(long num,Integer at){
        String encode = encoding(num);
        if (encode.length()<at){
            return StringUtils.leftPad(encode,at,"0");
        }
        if (encode.length()==at){
            System.out.println("======");
            return encode;
        }
        return  encode.substring(0,at);
    }
    private static Long MAX_NUM = 56800235583L;

    public static String encodingToSix(long num){
        if (num>MAX_NUM){
            encodingToSix(num-MAX_NUM);
        }
        return encoding(num);
    }

    // 62进制转10进制
    public static long decoding(String str) {
        if(str==null || str.trim().length() == 0 ){
            throw new IllegalArgumentException("str must not be empty.");
        }
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += ALPHABET.indexOf(str.charAt(i)) * Math.pow(62, i);
        }
        return result;
    }

}

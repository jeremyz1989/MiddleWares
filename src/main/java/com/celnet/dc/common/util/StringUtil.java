package com.celnet.dc.common.util;

/**
 * 字符串处理类
 * Created by ensure 2017-06-17.
 */
public class StringUtil {
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0 || "null".equals(cs);
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static boolean isEmpty(Object cs) {
        if (cs instanceof String) {
            return isEmpty((String) cs);
        } else {
            return isEmpty(String.valueOf(cs));
        }
    }
    /**
     * 字符串尾部添加/
     * @param rootPath
     * @return
     */
    public static String endNormalize(String rootPath) {
        if (org.springframework.util.StringUtils.isEmpty(rootPath))
            return "";
        return rootPath.endsWith("/")?rootPath:rootPath + "/";
    }
}

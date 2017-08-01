package com.celnet.dc.common.util;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterators;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

/**
 * Created by web on 2016/5/11.
 */
public class CommonUtil {


    /**
     * 判断1,2,3,2 是否包含某个值
     *
     * @param str
     * @return
     */
    public static boolean isStrContainValue(String str, String targetValue) {
        String[] arr = str.split(",");
        return Arrays.asList(arr).contains(targetValue);
    }

    /**
     * 将Bean对象转换成Map对象，忽略掉值为null或size=0的属性
     *
     * @param obj 对象
     * @return 若给定对象为null则返回size=0的map对象
     */
    public static Map<String, Object> toMap(Object obj) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (obj == null) {
            return map;
        }
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            // 过滤class属性
            if (!key.equals("class")) {
                // 得到property对应的getter方法
                Method getter = property.getReadMethod();
                Object value = getter.invoke(obj);
                if (value != null)
                    map.put(key, value);
            }

        }
        return map;
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1
     * @param v2
     * @return 两个参数数学差，以字符串格式返回
     */
    public static String subtract(String v1, String v2) {
        BigDecimal b1 = v1 == null ? BigDecimal.ZERO : new BigDecimal(v1);
        BigDecimal b2 = v2 == null ? BigDecimal.ZERO : new BigDecimal(v2);
        return b1.subtract(b2).toString();
    }

    /**
     * 计算时间差--天
     *
     * @param date_b
     * @param date_e
     * @param formatStr "yyyy-MM-dd HH:mm:对ss"
     */
    public static String dateSubtract(String date_b, String date_e, String formatStr) {
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        Date begin = null;
        Date end = null;
        try {
            begin = df.parse(date_b);
            end = df.parse(date_e);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
        long l = end.getTime() - begin.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
//    System.out.println("" + day + "天" + hour + "小时" + min + "分" + s + "秒");
        Long dayOj = new Long(day);
        return dayOj.toString();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1
     * @param v2
     * @return 两个参数的数学积，以字符串格式返回
     */
    public static String multiply(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).toString();
    }

    /**
     * 处理小数后面的0
     *
     * @param n String
     * @return String
     */
    public static String formatNum(String n) {
        int f = (int) Float.parseFloat(n);
        Integer it = new Integer(f);
        String s = subtract(n, it.toString());
        s = s.length() > 2 ? s.substring(2, s.length()) : s;
        int totle = s.length();
        for (int i = 0; i < totle - 1; i++) {
            if ("0".equals(s.substring(s.length() - 1, s.length()))) {
                s = s.substring(0, s.length() - 1);
            } else {
                break;
            }
        }
        return it + "." + s;
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。舍入模式采用用户指定舍入模式
     *
     * @param v1
     * @param v2
     * @param scale      表示需要精确到小数点以后几位
     * @param round_mode 表示用户指定的舍入模式
     * @return 两个参数的商，以字符串格式返回
     */
    public static String divide(String v1, String v2, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, round_mode).toString();
    }


    /**
     * user java reg to check phone number and replace 86 or +86
     * only check start with "+86" or "86" ex +8615911119999 13100009999 replace +86 or 86 with ""
     *
     * @param phoneNum
     * @return
     * @throws Exception
     */
    public static long checkPhoneNum(String phoneNum) {

        Pattern p1 = Pattern.compile("^((\\+{0,1}86){0,1})1[0-9]{10}");
        Matcher m1 = p1.matcher(phoneNum);
        if (m1.matches()) {
            Pattern p2 = Pattern.compile("^((\\+{0,1}86){0,1})");
            Matcher m2 = p2.matcher(phoneNum);
            StringBuffer sb = new StringBuffer();
            while (m2.find()) {
                m2.appendReplacement(sb, "");
            }
            m2.appendTail(sb);
            return Long.parseLong(sb.toString());
        } else {
            return 0;
        }

    }

    //生成随机数字和字母,
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 将手机号隐藏中间四位
     *
     * @param resTel
     * @return
     */
    public static String getHideTel(String resTel) {
        if (Strings.isNullOrEmpty(resTel))
            return "";
        return resTel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 分隔字符串
     *
     * @param str
     * @param splitter
     * @return
     */
    public static Iterable<String> getSplitStr(String str, Splitter splitter) {
        if (Strings.isNullOrEmpty(str))
            return null;
        return splitter.split(str);
    }

    /**
     * 获得Iterable中的最后一个
     *
     * @param iterable
     * @param <T>
     * @return
     */
    public static <T> T getLast(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            } else {
                return (T) getLastInNonemptyList(list);
            }
        } else {
            return Iterators.getLast(iterable.iterator());
        }
    }

    private static <T> T getLastInNonemptyList(List<T> list) {
        return list.get(list.size() - 1);
    }

    /**
     * 返回不为空的对象
     *
     * @param objs
     * @return
     */
    public static List getNotNullList(Object... objs) {
        List list = new ArrayList();
        if (objs != null) {
            for (Object obj : objs) {
                if (obj != null) {
                    list.add(obj);
                }
            }
        }
        return list;
    }

    /**
     * 任一个为空都返回true
     *
     * @param objects
     * @return
     */
    public static boolean emptyAny(Object... objects) {
        if (objects == null) {
            return true;
        }
        for (Object object : objects) {
            if (object instanceof String) {
                if (StringUtils.isEmpty((String) object)) {
                    return true;
                }
            }
            if (object instanceof Collection) {
                Collection c = (Collection) object;
                if (c == null || c.size() == 0) {
                    return true;
                }
            }
            if (object == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 任一个不为空都返回true
     *
     * @param objects
     * @return
     */
    public static boolean notEmptyAnyOne(Object... objects) {
        if (objects == null) {
            return false;
        }
        for (Object object : objects) {
            if (object instanceof String) {
                if (!StringUtils.isEmpty((String) object)) {
                    return true;
                }
            }
            if (object instanceof Collection) {
                Collection c = (Collection) object;
                if (c != null && c.size() > 0) {
                    return true;
                }
            }
            if (object != null) {
                return true;
            }
        }
        return false;
    }
}

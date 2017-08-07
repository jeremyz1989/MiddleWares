package com.celnet.dc.common.util;

import org.jcp.xml.dsig.internal.dom.DOMDigestMethod;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * Created by HONGYI_ZHENG on 2017/8/4.
 */
public class SHA1EncodingUtil {

    public static String getSha1(String str){
        if(str==null||str.length()==0){
            return null;
        }
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf).toUpperCase();
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
}

package cn.hotel.utils;

import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class CreateNumber {

    public static String createNo(String prrfix,String context){

        StringBuffer sbr = new StringBuffer();
        sbr.append(prrfix);
        String strUUID = UUID.randomUUID().toString().replace("-","");
        sbr.append(strUUID);
        if(context != null){
            sbr.append(context);
        }
        String s = DigestUtils.md5Hex(sbr.toString()).substring(0,8);

        return s;
    }
}

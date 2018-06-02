package cn.lhqs.middle.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-02 14:39
 * description : IpAddrUtils.class
 * version : 1.0
 */
public class IpAddrUtils {

    public static String getIpAddr(HttpServletRequest request ){
        String ip = request.getHeader(" x-forwarded-for ");
        System.out.println("ip1:"+ip);
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" WL-Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}

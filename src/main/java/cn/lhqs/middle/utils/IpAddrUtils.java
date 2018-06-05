package cn.lhqs.middle.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-06-02 14:39
 * description : IpAddrUtils.class
 * version : 1.0
 */
public class IpAddrUtils {

    private static Logger logger = LoggerFactory.getLogger(IpAddrUtils.class);

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

    public static String getAddressByIP(String strIP) {
        if( strIP.equals("0:0:0:0:0:0:0:1")){
            return "内网IP";
        }
        String line = null;
        BufferedReader reader = null;
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + strIP);
            URLConnection conn = url.openConnection();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        } catch (IOException e) {
            logger.warn("getAddressByIP exception ----> " + e.getMessage());
        } finally {
            if( reader != null ){
                try {
                    reader.close();
                } catch (IOException e) {
                    logger.warn("reader close exception ----> "+ e.getMessage());
                }
            }
        }
        JSONObject jsonObject = JSON.parseObject(result.toString());
        String data = jsonObject.get("data").toString();
        JSONObject jsonData = JSON.parseObject(data);
        System.out.println();
        return jsonData.get("country").toString() + "-" + jsonData.get("region").toString() + "-" + jsonData.get("region")  + "-" + jsonData.get("isp");
    }
}

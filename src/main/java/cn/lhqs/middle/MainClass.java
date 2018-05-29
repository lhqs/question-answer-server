package cn.lhqs.middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-05-29 10:38
 * description : MainClass.class
 * version : 1.0
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println(getAddressByIP("61.153.48.135"));
    }

    public static String getAddressByIP(String strIP) {
        String line = null;
        try {
            URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + strIP);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuffer result = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            return result.toString();
        } catch (IOException e) {
            return "暂时无法通过ip获取地址";
        }
    }
}

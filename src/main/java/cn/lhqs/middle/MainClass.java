package cn.lhqs.middle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
        String json = getAddressByIP("0:0:0:0:0:0:0:1");
        System.out.println(json);
        // IpObject parse = (IpObject) JSON.parse(json);
        // System.out.println(parse.getCode());
        // System.out.println(parse.getData());
        JSONObject jsonObject = JSON.parseObject(json);
        String data = jsonObject.get("data").toString();
        JSONObject jsonData = JSON.parseObject(data);
        System.out.println(jsonData.get("country").toString() + jsonData.get("city").toString());

    }

    public static String getAddressByIP(String strIP) {
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
            e.printStackTrace();
        } finally {
            if( reader != null ){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }
}

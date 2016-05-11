package com.example.edwin.mvpdemo.model;

import com.example.edwin.mvpdemo.bean.IPBean;
import com.example.edwin.mvpdemo.presenter.onSearchListener;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 创建者      Created by Edwin
 * 创建时间    2015/07/17
 * 描述        获取数据
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class SearchModel implements ISearchModel {
    @Override
    public void getIpAddressInfo(final String ipAddress, final onSearchListener onSearchListener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "http://192.168.1.110:8080/test.json";
                try {
                    IPBean ipBean = new IPBean();
                    URL url = new URL(path + ipAddress);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    int responseCode = conn.getResponseCode();
                    if(responseCode == 200){
                        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
                        BufferedReader br = new BufferedReader(isr);
                        String line;
                        StringBuilder sb = new StringBuilder();
                        while ((line = br.readLine()) != null) {
                            sb.append(line).append("\\n");
                        }
                        JSONObject jsonObject = new JSONObject();
                        ipBean.setCountry(jsonObject.getString("country"));
                        ipBean.setProvince(jsonObject.getString("province"));
                        ipBean.setCity(jsonObject.getString("city"));
                        onSearchListener.onSuccess(ipBean);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

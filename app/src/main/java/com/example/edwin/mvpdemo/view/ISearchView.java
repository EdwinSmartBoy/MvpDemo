package com.example.edwin.mvpdemo.view;

import com.example.edwin.mvpdemo.bean.IPBean;

/**
 * 创建者      Created by Edwin
 * 创建时间    2015/07/17
 * 描述        获取基本信息的接口
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public interface ISearchView {

    //获取IP地址
    String getIPAddress();

    //设置信息  将WeatherBean对象进行传递
    void setMsg(IPBean IPBean);

    //隐藏加载提示
    void hideLoad();

    //显示加载提示
    void showLoad();
}

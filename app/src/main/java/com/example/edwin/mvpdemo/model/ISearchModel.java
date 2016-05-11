package com.example.edwin.mvpdemo.model;

import com.example.edwin.mvpdemo.presenter.onSearchListener;

/**
 * 创建者      Created by Edwin
 * 创建时间    2015/07/17
 * 描述        ${TODO}
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public interface ISearchModel {

    void getIpAddressInfo(String ipAddress, onSearchListener onSearchListener);

}

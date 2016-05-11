package com.example.edwin.mvpdemo.presenter;

import com.example.edwin.mvpdemo.bean.IPBean;

/**
 * 创建者      Created by Edwin
 * 创建时间    2015/07/17
 * 描述        在Model中处理数据完成时候的回调接口
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public interface onSearchListener {

    //查询成功时回调的方法
    void onSuccess(IPBean IPBean);

    //查询失败时回调的方法
    void onError();
}

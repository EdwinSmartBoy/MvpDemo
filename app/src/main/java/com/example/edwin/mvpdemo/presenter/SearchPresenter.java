package com.example.edwin.mvpdemo.presenter;

import android.os.Handler;

import com.example.edwin.mvpdemo.bean.IPBean;
import com.example.edwin.mvpdemo.model.ISearchModel;
import com.example.edwin.mvpdemo.model.SearchModel;
import com.example.edwin.mvpdemo.view.ISearchView;

/**
 * 创建者      Created by Edwin
 * 创建时间    2015/07/17
 * 描述        控制单元
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class SearchPresenter implements ISearchPresenter, onSearchListener {

    ISearchView mSearchView;
    ISearchModel mISearchModel;
    private final Handler mHandler;

    public SearchPresenter(ISearchView searchView) {
        this.mSearchView = searchView;
        mISearchModel = new SearchModel();
        mHandler = new Handler();
    }

    /**
     * @desc 查询IP
     */
    @Override
    public void search() {
        mSearchView.showLoad();
        mISearchModel.getIpAddressInfo(mSearchView.getIPAddress(), this);
    }

    /**
     * @param ipBean
     * @desc 当查询成功时的回调
     */
    @Override
    public void onSuccess(final IPBean ipBean) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mSearchView.setMsg(ipBean);
                mSearchView.hideLoad();
            }
        });
    }

    /**
     * @desc 当查询失败时的回调
     */
    @Override
    public void onError() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mSearchView.setMsg(null);
                mSearchView.hideLoad();
            }
        });
    }
}

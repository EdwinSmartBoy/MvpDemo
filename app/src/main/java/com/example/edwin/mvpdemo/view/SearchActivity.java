package com.example.edwin.mvpdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.edwin.mvpdemo.R;
import com.example.edwin.mvpdemo.bean.IPBean;
import com.example.edwin.mvpdemo.presenter.SearchPresenter;

/**
 * 创建者      Created by Edwin
 * 创建时间    2015/07/17
 * 描述        对接口ISearchView具体的实现
 * <p/>
 * 更新者      Edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public class SearchActivity extends AppCompatActivity implements ISearchView {

    private TextView mTvResult;
    private EditText mEtText;
    private Button mBtnSearch;
    private ProgressBar mPbGress;

    private SearchPresenter mSearchPresenter = new SearchPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取界面组件信息
        mTvResult = (TextView) findViewById(R.id.tv_result);
        mEtText = (EditText) findViewById(R.id.et_input);
        mBtnSearch = (Button) findViewById(R.id.btn_search);
        mPbGress = (ProgressBar) findViewById(R.id.pb_progress);

        //设置点击事件
        onClick();
    }

    /**
     * @desc 按钮的点击事件
     */
    private void onClick() {
        mBtnSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用mSearchPresenter的search方法
                mSearchPresenter.search();
            }
        });
    }

    /**
     * @return
     * @desc 将输入框中的设置的数据进行返回的操作
     */
    @Override
    public String getIPAddress() {
        return mEtText.getText().toString().trim();
    }

    /**
     * @param IPBean
     * @desc  将当前对象显示到界面上
     */
    @Override
    public void setMsg(IPBean IPBean) {
        if (IPBean != null) {
            mEtText.setText(IPBean.toString());
        } else {
            mEtText.setText("获取失败");
        }
    }

    /**
     * @desc 将加载的进度提示隐藏
     */
    @Override
    public void hideLoad() {
        mPbGress.setVisibility(View.GONE);
    }

    /**
     * @desc 显示加载进度条
     */
    @Override
    public void showLoad() {
        mPbGress.setVisibility(View.VISIBLE);
    }
}

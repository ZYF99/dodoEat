package com.zyf.simplemvp.fragment.personal;


import android.app.Fragment;
import com.zyf.common.common.app.PresenterFragment;
import com.zyf.common.factory.presenter.base.BaseContract;
import com.zyf.simplemvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_personal extends PresenterFragment {


    public Fragment_personal() {
        // Required empty public constructor
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_fragment4;
    }


    //返回此FragmentPresenter的实体类对象
    @Override
    protected BaseContract.Presenter initPresenter() {
        return null;
    }
}

package com.zyf.simplemvp.fragment.personal;


import android.app.Fragment;
import android.widget.TextView;

import com.zyf.common.common.app.PresenterFragment;
import com.zyf.common.factory.presenter.base.BaseContract;
import com.zyf.simplemvp.R;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_personal extends PresenterFragment {


    @BindView(R.id.personal_icon)
    CircleImageView icon;
    @BindView(R.id.num_following)
    TextView tv_num_following;
    @BindView(R.id.num_fans)
    TextView tv_num_fans;
    @BindView(R.id.num_likesorcollect)
    TextView tv_num_likesorcollect;

    public Fragment_personal() {
        // Required empty public constructor
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_personal;
    }


    //返回此FragmentPresenter的实体类对象
    @Override
    protected BaseContract.Presenter initPresenter() {
        return null;
    }
}

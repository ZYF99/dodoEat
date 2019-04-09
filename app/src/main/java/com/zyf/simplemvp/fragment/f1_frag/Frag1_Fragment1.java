package com.zyf.simplemvp.fragment.f1_frag;



import android.view.View;
import com.zyf.common.common.app.PresenterFragment;
import com.zyf.factory.presenter.function1.Func1Presenter;
import com.zyf.factory.presenter.function1.Function1Contract;
import com.zyf.simplemvp.R;



public class Frag1_Fragment1 extends PresenterFragment<Function1Contract.Presenter> implements Function1Contract.View {


    public Frag1_Fragment1() {

    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);



    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.frag1_fragment1;
    }


    //返回此FragmentPresenter的实体类对象
    @Override
    protected Function1Contract.Presenter initPresenter() {
        return new Func1Presenter(this);
    }


    //此Fragment特有方法在Presenter执行后的回调
    @Override
    public void fun1Callback() {

    }


}

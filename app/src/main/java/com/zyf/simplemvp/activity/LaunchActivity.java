package com.zyf.simplemvp.activity;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.util.Property;
import android.view.View;
import com.zyf.common.common.app.PresenterActivity;
import com.zyf.factory.model.User;
import com.zyf.factory.presenter.launch.Contract_launch;
import com.zyf.factory.presenter.launch.Presenter_launch;
import com.zyf.simplemvp.R;
import net.qiujuer.genius.res.Resource;
import net.qiujuer.genius.ui.compat.UiCompat;


public class LaunchActivity extends PresenterActivity<Contract_launch.Presenter> implements Contract_launch.View {

    private ColorDrawable mBgDrawable;

    //得到界面布局ID
    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_launch;
    }

    //初始化控件
    @Override
    protected void initWidget() {
        super.initWidget();
        //拿到根布局
        View root = findViewById(R.id.activity_launch);
        //获取颜色
        int color = UiCompat.getColor(getResources(), R.color.launchback);
        //创建一个Drawable
        ColorDrawable drawable = new ColorDrawable((color));
        //设置给背景
        root.setBackground(drawable);
        mBgDrawable = drawable;
    }

    //初始化数据
    @Override
    protected void initData() {
        super.initData();
        // 动画进入到50%等待PushId获取到
        // 检查等待状态
        startAnim(0.5f, this::waitPushReceiverIdDone);
    }


    /**
     * 在跳转之前需要把剩下的50%进行完成
     */
    private void waitPushReceiverIdDone() {
        startAnim(1f, this::reallySkip);
    }


    /**
     * 真实的跳转
     */
    private void reallySkip() {
        //用户个人信息获取
        mPresenter.getUserInfo();
    }

    /**
     * 给背景设置一个动画
     *
     * @param endProcess  动画的结束进度
     * @param endCallback 动画结束时触发
     */
    private void startAnim(float endProcess, Runnable endCallback) {
        //获取一个结束的颜色
        int finalColor = Resource.Color.WHITE; //UiCompat.getColor(getResources(),R.color.white);
        //运算当前进度的颜色
        ArgbEvaluator evaluator = new ArgbEvaluator();
        int endColor = (int) evaluator.evaluate(endProcess, mBgDrawable.getColor(), finalColor);
        //构建一个属性动画
        ValueAnimator valueAnimator = ObjectAnimator.ofObject(this, property, evaluator, endColor);
        valueAnimator.setDuration(1500);//时间
        valueAnimator.setIntValues(mBgDrawable.getColor(), endColor);//开始结束
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //结束时触发
                endCallback.run();
            }
        });
        valueAnimator.start();
    }


    //颜色过度器
    private Property<LaunchActivity, Object> property = new Property<LaunchActivity, Object>(Object.class, "color") {
        @Override
        public void set(LaunchActivity object, Object value) {
            object.mBgDrawable.setColor((Integer) value);
        }

        @Override
        public Object get(LaunchActivity launchActivity) {
            return mBgDrawable.getColor();
        }
    };


    //初始化Presenter
    @Override
    public Contract_launch.Presenter initPresenter() {
        return new Presenter_launch(this);
    }

    //个人信息获取成功后的回调
    @Override
    public void onUserInfoDone(User user) {
        MainActivity.show(this);
        finish();
    }
}

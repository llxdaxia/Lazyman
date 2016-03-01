package cn.hotwoo.alien.servicelife.moudel.user;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;

import com.jude.beam.bijection.RequiresPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.hotwoo.alien.servicelife.R;
import cn.hotwoo.alien.servicelife.app.BaseActivity;

/**
 * Created by alien on 2015/8/13.
 */
@RequiresPresenter(LoginPresenter.class)
public class LoginActivity extends BaseActivity<LoginPresenter> {

    @Bind(R.id.name)
    TextInputLayout name;
    @Bind(R.id.password)
    TextInputLayout password;
    @Bind(R.id.login)
    Button login;
    @Bind(R.id.register)
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_login);
        ButterKnife.bind(this);

        name.getEditText().setText(getIntent().getStringExtra(RegisterPresenter.NAME));
        password.getEditText().setText(getIntent().getStringExtra(RegisterPresenter.PASSWORD));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = name.getEditText().getText().toString();
                String passStr = password.getEditText().getText().toString();
                getPresenter().login(nameStr, passStr);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().register();
            }
        });


    }
}

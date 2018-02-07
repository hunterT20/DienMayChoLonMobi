package com.dienmaycholon.dienmaycholonmobi.features.login;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.DataLoginDMCL;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginFragment extends Fragment {
    @BindView(R.id.edt_email_login)    EditText edt_email_login;
    @BindView(R.id.edt_password) EditText edt_password;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.btn_login)
    public void onLoginDefaultClick(){
        String username = edt_email_login.getText().toString();
        String password = edt_password.getText().toString();
        Observable<ApiResult<DataLoginDMCL, Integer>> login = ApiUtils.getAPIservices().loginDmcl(username,password, Constant.Token);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResult<DataLoginDMCL, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiResult<DataLoginDMCL, Integer> dataLoginDMCLIntegerApiResult) {
                        Toast.makeText(getActivity(), dataLoginDMCLIntegerApiResult.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}

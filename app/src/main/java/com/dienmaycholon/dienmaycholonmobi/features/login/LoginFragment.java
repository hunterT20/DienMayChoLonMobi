package com.dienmaycholon.dienmaycholonmobi.features.login;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.local.database.LocalDatabase;
import com.dienmaycholon.dienmaycholonmobi.data.model.DataLoginDMCL;
import com.dienmaycholon.dienmaycholonmobi.data.model.User;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.AccessTokenFacebook;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.dienmaycholon.dienmaycholonmobi.data.Constant.child;

public class LoginFragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener{
    private static final String TAG = LoginFragment.class.getSimpleName();
    @BindView(R.id.edt_email_login)    EditText edt_email_login;
    @BindView(R.id.edt_password) EditText edt_password;

    public static int REQUEST_CODE_LOGIN_GOOGLE = 99;
    public static int CHECK_PROVIDER_LOGIN = 0;
    private GoogleApiClient client;

    private CallbackManager callbackManager;
    private FacebookCallback<LoginResult> loginResult;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this,view);

        callbackManager = CallbackManager.Factory.create();
        initFaceBook();
        LoginManager.getInstance().registerCallback(callbackManager, loginResult);

        createClientGoogle();
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

    @OnClick(R.id.btn_Login_Face)
    public void onLoginFaceClick(){
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList(
                "public_profile","email"
        ));
    }

    @OnClick(R.id.btn_Login_Google)
    public void onLoginGoogleClick(){

    }

    /**
     * Khởi tạo client Google
     */
    private void createClientGoogle(){
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder()
                .requestProfile()
                .requestEmail()
                .requestId()
                .build();

        assert getActivity() != null;
        client = new GoogleApiClient.Builder(getActivity())
                .enableAutoManage(getActivity(),this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions)
                .build();
    }


    /**
     * Mở Fragment đăng nhập google
     */
    private void LoginGoogle(){
        CHECK_PROVIDER_LOGIN = 1;
        Intent intentGoogle = Auth.GoogleSignInApi.getSignInIntent(client);
        startActivityForResult(intentGoogle,REQUEST_CODE_LOGIN_GOOGLE);
    }

    /**
     * Xử lý dữ liệu trả về từ Fragment đăng nhập google
     * @param requestCode:
     * @param resultCode: trạng thái result (true/false)
     * @param data: dữ liệu trả về
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_LOGIN_GOOGLE){
            if (resultCode == Activity.RESULT_OK){
                GoogleSignInResult signInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                GoogleSignInAccount account = signInResult.getSignInAccount();
                assert account != null;

                String email = account.getEmail();
                String firstname = account.getGivenName();
                String lastname = account.getFamilyName();
                String id = account.getId();
            }
        }else {
            callbackManager.onActivityResult(requestCode,resultCode,data);
        }
    }

    private void initFaceBook() {
        loginResult = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                CHECK_PROVIDER_LOGIN = 2;
                AccessTokenFacebook accessToken = new AccessTokenFacebook();
                accessToken.setAccessToken(loginResult.getAccessToken().getToken());
                eventLoginFacebook(accessToken);
            }

            @Override
            public void onCancel() {
                Log.e("initFacebook", "onCancel: ");
            }

            @Override
            public void onError(FacebookException error) {
                Log.e("initFacebook", "onError: ");
            }
        };
    }

    private void eventLoginFacebook(AccessTokenFacebook accessToken){
        Observable<ApiResult<User, Integer>> loginFacebook = ApiUtils.getAPIservices()
                .loginFacebook(accessToken);

        loginFacebook.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResult<User, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiResult<User, Integer> data) {
                        Constant.Token = data.getData().getGettoken();
                        saveInfoUser(data.getData());
                        Toast.makeText(getActivity(), data.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        assert getActivity() != null;
                        getActivity().finish();
                    }
                });
    }

    private void saveInfoUser(User user){
        Single.fromCallable(() -> {
            LocalDatabase
                    .getInstance(getActivity())
                    .getUserDao()
                    .insert(user);
            return "Lưu thông tin user thành công!";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.e(TAG, "onSuccess: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }
                });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}

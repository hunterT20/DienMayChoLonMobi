package com.dienmaycholon.dienmaycholonmobi.features.launch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.Constant;
import com.dienmaycholon.dienmaycholonmobi.data.model.api.ApiResult;
import com.dienmaycholon.dienmaycholonmobi.data.remote.ApiUtils;
import com.dienmaycholon.dienmaycholonmobi.features.home.view.MainActivity;

import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LaunchActivity extends AppCompatActivity {

    private static final String TAG = LaunchActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.launch_activity);
        ButterKnife.bind(this);

        getToken();
    }

    private void getToken(){
        Observable<ApiResult<String, Integer>> getToken = ApiUtils.getAPIservices().getToken();
        getToken.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiResult<String, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiResult<String, Integer> token) {
                        Constant.Token = token.getData();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(LaunchActivity.this, "Lỗi kết nối, xin vui lòng thử lại sau!", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                    }
                });
    }
}

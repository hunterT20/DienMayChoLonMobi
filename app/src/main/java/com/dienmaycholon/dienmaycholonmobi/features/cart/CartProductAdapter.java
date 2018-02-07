package com.dienmaycholon.dienmaycholonmobi.features.cart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dienmaycholon.dienmaycholonmobi.R;
import com.dienmaycholon.dienmaycholonmobi.data.local.database.LocalDatabase;
import com.dienmaycholon.dienmaycholonmobi.data.model.Child;
import com.dienmaycholon.dienmaycholonmobi.util.NumberTextWatcherForThousand;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CartProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = CartProductAdapter.class.getSimpleName();
    private Context context;
    private List<Child> childList;

    CartProductAdapter(Context context) {
        this.context = context;
        childList = new ArrayList<>();
    }

    public void addList(List<Child> childList) {
        this.childList.addAll(childList);
        notifyDataSetChanged();
    }

    public void clear(){
        this.childList.clear();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_product_item, null);
        return new CartProductViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CartProductViewHolder viewHolder = (CartProductViewHolder) holder;
        Child child = childList.get(position);

        Picasso.with(context).load(child.getPhoto())
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.imv_product_cart);

        viewHolder.txtv_name_product.setText(child.getName());
        viewHolder.txtv_count_product.setText(String.valueOf(child.getCount()));
        viewHolder.txtv_price_product.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(child.getSaleprice())) + "đ");
        if (child.getCount() == 1) {
            viewHolder.imv_minus.setEnabled(false);
        } else {
            viewHolder.imv_minus.setEnabled(true);
        }

        viewHolder.imv_minus.setOnClickListener(view -> {
            child.setCount(child.getCount() - 1);
            updateDBLocal(child);
        });

        viewHolder.imv_plus.setOnClickListener(view -> {
            child.setCount(child.getCount() + 1);
            updateDBLocal(child);
        });

        viewHolder.imv_delete_product.setOnClickListener(view -> {
            deleteDBLocal(child);
        });
    }

    private void updateDBLocal(Child child) {
        Single.fromCallable(() -> {
            LocalDatabase
                    .getInstance(context)
                    .getChildDao()
                    .update(child);
            return "Lưu dữ liệu thành công";
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

    private void deleteDBLocal(Child child) {
        Single.fromCallable(() -> {
            LocalDatabase
                    .getInstance(context)
                    .getChildDao()
                    .delete(child);
            return "Đã xóa sản phẩm!";
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }
                });
    }

    @Override
    public int getItemCount() {
        if (childList == null) return 0;
        return childList.size();
    }

    class CartProductViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imv_minus)           ImageView imv_minus;
        @BindView(R.id.imv_plus)            ImageView imv_plus;
        @BindView(R.id.imv_delete_product)  ImageView imv_delete_product;
        @BindView(R.id.imv_product_cart)    ImageView imv_product_cart;
        @BindView(R.id.txtv_name_product)   TextView txtv_name_product;
        @BindView(R.id.txtv_price_product)  TextView txtv_price_product;
        @BindView(R.id.txtv_count_product)  TextView txtv_count_product;

        CartProductViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

package com.dienmaycholon.dienmaycholonmobi.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxSearchObservable {
    public static Observable<String> fromView(EditText editText) {

        final PublishSubject<String> subject = PublishSubject.create();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                subject.onNext(String.valueOf(charSequence));
            }

            @Override
            public void afterTextChanged(Editable editable) {
                subject.onComplete();
            }
        });

        return subject;
    }
}

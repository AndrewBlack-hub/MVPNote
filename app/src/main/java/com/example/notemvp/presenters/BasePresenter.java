package com.example.notemvp.presenters;

public class BasePresenter {

    public interface Callback {
        void callback();
    }

    public void tread(final Callback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                callback.callback();
            }
        }).start();
    }
}

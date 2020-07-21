package com.example.day05text.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseModel {
    public CompositeDisposable mDisposable;
    public void addDisposable(Disposable disposable){
        if (mDisposable==null){
            synchronized (BaseModel.class){
                if(mDisposable==null){
                    mDisposable = new CompositeDisposable();
                }
            }
        }
        mDisposable.add(disposable);
    }

    public void dispose(){
        if(mDisposable!=null){
            mDisposable.dispose();
        }
    }

    public void removeDisposable(Disposable disposable){
        if(mDisposable!=null){
            mDisposable.remove(disposable);
        }
    }
}

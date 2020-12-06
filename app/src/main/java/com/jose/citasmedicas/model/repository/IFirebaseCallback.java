package com.jose.citasmedicas.model.repository;

public interface IFirebaseCallback<T> {
    public void onSuccess(T result);
    public void onFailed(Exception exception);

}

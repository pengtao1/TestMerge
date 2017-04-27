package com.example.result;

public class DataResult<T> extends SimpleResult {
    private static final long serialVersionUID = -7529240574220114147L;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
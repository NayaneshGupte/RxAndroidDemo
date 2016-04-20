package com.technosavy.rxandroiddemo.service;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    public static <T> T createServiceFrom(final Class<T> serviceClass, String endpoint) {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(endpoint)
                .build();

        T service = retrofit.create(serviceClass);

        return service;
    }
}

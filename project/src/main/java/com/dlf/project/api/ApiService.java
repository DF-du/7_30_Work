package com.dlf.project.api;

import com.dlf.project.bean.FuliBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
//    https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/2
    String baseUrl = "https://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/2")
    Observable<FuliBean> getData();
}

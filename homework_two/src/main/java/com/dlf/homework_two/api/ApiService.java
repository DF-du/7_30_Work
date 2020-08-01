package com.dlf.homework_two.api;


import com.dlf.homework_two.bean.FuliBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
//    https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/2
    String baseUrl = "https://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/2")
    Observable<FuliBean> getData();
}

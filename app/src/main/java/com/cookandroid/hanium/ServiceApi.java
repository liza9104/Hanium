package com.cookandroid.hanium;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {
    @POST("/user/login")
    Call<LoginResponse> userLogin(@Body LoginData data);

    @POST("/user/join")
    Call<JoinResponse> userJoin(@Body JoinData data);

    @POST("user/idchk")
    Call<IdChkResponse> userIdchk(@Body IdChkData data);

    @POST("user/test")
    Call<testResponse> test(@Body testData data);

    @POST("user/RR")
    Call<RR_response> userRRInfo(@Body RRData data);


}
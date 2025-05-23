package com.example.sagar.vehicledocumentverification;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

public interface Api {

    String BASE_URL = "https://fulsome-mittens.000webhostapp.com/project/";

    @GET("login.php")
    Call<IsExist> doLogin(@Query("mobileNo") String username, @Query("password") String password);

    @GET("get_driving.php")
    Call<List<Vehicle_Driving>> getVehicle_Driving(@Query("f1") String string_qe);

    @GET("get_vehicle_document.php")
    Call<List<Vehicle_Document>> getVehicle_Document(@Query("f1") String string_qe);

    @GET("get_insurence.php")
    Call<List<Vehicle_Insurence>> getVehicle_Insurence(@Query("f1") String string_qe);

    @GET("get_emission.php")
    Call<List<Vehicle_Emission>> getVehicle_Emission(@Query("f1") String string_qe);

    @GET("getmissing.php")
    Call<List<Vehicle_Missing>> getVehicle_Missing(@Query("f1") String string_qe);

    @FormUrlEncoded
    @POST("register.php")
    Call<IsExist> CreateAccount(
            @Field("f1") String stringname,
            @Field("f2") String stringmno,
            @Field("f3") String stringemail,
            @Field("f4") String stringpassword
    );

    @FormUrlEncoded
    @POST("createPenalty.php")
    Call<IsExist> CreatePenalty(
            @Field("f1") String stringet_pdetails,
            @Field("f2") String stringet_amount,
            @Field("f3") String stringet_mno,
            @Field("f4") String stringet_uname,
            @Field("f5") String stringet_address
    );

    @GET("GetCart.php")
    Call<List<Cart>> getCartByCode(@Query("f1") String string_mno);
}

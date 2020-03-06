package dnd.madang.jang

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("search/prdName")
    fun searchProducts(@Query("prd_name")prd_name:String): Call<BaseResponse>

    @FormUrlEncoded
    @POST("auth/login")
    //fun loginAccount(@Field("user_id")user_id:String,@Field("user_pw")user_pw:String): Call<AccountBaseResponse>

    fun loginAccount(@Field("user_id") user_id :String,@Field("user_pw")user_pw:String): Call<AccountBaseResponse>

}

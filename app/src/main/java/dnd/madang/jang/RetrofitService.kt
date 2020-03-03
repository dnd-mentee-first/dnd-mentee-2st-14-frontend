package dnd.madang.jang

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("search/prdName")
    fun searchProducts(@Query("prd_name")prd_name:String): Call<BaseResponse>
}

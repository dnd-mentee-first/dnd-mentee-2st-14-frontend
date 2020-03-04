package dnd.madang.jang

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activty_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SearchActivity : AppCompatActivity() {

    private var SearchList = ArrayList<SearchItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_search)
        val mLayoutManager = LinearLayoutManager(this);
        search_recycle.setLayoutManager(mLayoutManager);

        search_btn.setOnClickListener() {
            CloseKeyboard()
            SearchList.clear()
            receiveDatasfromAPI(search_edit.text.toString())
            val adapter = SearchAdapter(SearchList)
            search_recycle.adapter = adapter



            for( i in SearchList)
                Log.d("TESTSearch :::","${i.mch_prd_name}")
        }

        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        // Calling setSystemUiVisibility() with a value of 0 clears
        // all flags.


//       AT.setOnItemClickListener { adapterView, view, position, rowId ->
//           Log.d("tag", "position: $position, rowId:$rowId, string: ${adapterView.getItemAtPosition(position)}")
//           val item_name = SearchList[position].mch_prd_name
//           val category_name = SearchList[position].cate_name
//           val category_code = SearchList[position].mch_prd_cate
//           Log.d("tag","이름 : $item_name,카테고리 이름: $category_name,카테고리 코드:$category_code")
//
//    }





    }

    private fun receiveDatasfromAPI(itemname : String) {
        val retrofit = Retrofit.Builder().baseUrl("http://api.madangiron.kro.kr/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val retrofit_service =  retrofit.create(RetrofitService::class.java)
        retrofit_service.searchProducts(itemname).enqueue(object : Callback<BaseResponse> {
            override fun onFailure(call : Call<BaseResponse>?, t: Throwable?) {}
            override fun onResponse(call : Call<BaseResponse>?, response : Response<BaseResponse>) {
                Log.d("Response::",response.body()?.result?.products?.get(0)?.mch_prd_name)
                var data : ArrayList<SearchItem>? = response?.body()?.result?.products
                for (i in data!!){
                    Log.i("data:::",i.mch_prd_name)
                    SearchList.add(i)

                }

            }

        })


    }

    fun CloseKeyboard()
    {
        var view = this.currentFocus

        if(view != null)
        {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }



}





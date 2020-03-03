package dnd.madang.jang

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.row_serach.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SearchFragment : Fragment() {
    private var SearchList = ArrayList<SearchItem>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val AT = autoCompleteTextView
        val adapter = AutoCompleteAdapter(this.requireContext(),SearchList)
        AT.setAdapter(adapter)
        //커스텀 어댑터를 생성
        //생성한 어댑터를 AT에 세팅

            AT.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //SearchList.clear()

                val target:String = AT.text.toString()//searchBar에서 사용자가 입력한 단어를 가져옵니다.
                Log.d("tag","TEST1:$target")

                //if(target.length < 2) return  // 입력한 단어가 1글자라면 퍼포먼스를 위해 디비를 검색하지 않습니다.

                receiveDatasfromAPI(target)
                val adapter = AutoCompleteAdapter(getCtx(),SearchList)
                AT.setAdapter(adapter)
                AT.setOnItemClickListener { adapterView, view, position, rowId ->
                    Log.d("tag", "position: $position, rowId:$rowId, string: ${adapterView.getItemAtPosition(position)}")
                    val item_name = SearchList[position].mch_prd_name
                    val category_name = SearchList[position].cate_name
                    val category_code = SearchList[position].mch_prd_cate
                    Log.d("tag","이름 : $item_name,카테고리 이름: $category_name,카테고리 코드:$category_code")

                }

                for(i in SearchList!!) {
                    Log.d("ArrayList", "${i.mch_prd_name}")
                }
            }
            })
    }

    private fun receiveDatasfromAPI(itemname : String) {
            val retrofit = Retrofit.Builder().baseUrl("http://api.madangiron.kro.kr/").addConverterFactory(GsonConverterFactory.create()).build()
            val retrofit_service =  retrofit.create(RetrofitService::class.java)
            retrofit_service.searchProducts(itemname).enqueue(object : Callback<BaseResponse> {
                override fun onFailure(call : Call<BaseResponse>?, t: Throwable?) {}
                override fun onResponse(call : Call<BaseResponse>?,response : Response<BaseResponse>) {
                    Log.d("Response::",response.body()?.result?.products?.get(0)?.mch_prd_name)
                    var data : ArrayList<SearchItem>? = response?.body()?.result?.products
                        for (i in data!!){
                            Log.i("data:::",i.mch_prd_name)
                            SearchList.add(i)

                        }

                    }

            })


    }
    private fun getCtx() : Context {
        return this.requireContext()
    }



}


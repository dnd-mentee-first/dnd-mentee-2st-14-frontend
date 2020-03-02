package dnd.madang.jang

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {
    private var SearchList = ArrayList<SearchItem>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search, null)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val AT = autoCompleteTextView
        fillCountryList()

        //커스텀 어댑터를 생성
        val adapter = AutoCompleteAdapter(this.requireContext(),SearchList)
        //생성한 어댑터를 AT에 세팅
        AT.setAdapter(adapter)
        print("onViewCreated")
    }

    private fun fillCountryList() {
        SearchList.add(SearchItem("아이폰 XS", "휴대폰/태블릿","023001" ))
        SearchList.add(SearchItem("아이폰 XS MAX", "휴대폰/태블릿","023001" ))
        SearchList.add(SearchItem("아이폰 XR", "휴대폰/태블릿","023001" ))
        SearchList.add(SearchItem("아이폰 11 MAX PRO", "휴대폰/태블릿","023001" ))
        SearchList.add(SearchItem("아이폰 11 MAX PRO", "휴대폰/태블릿","023001" ))
        SearchList.add(SearchItem("아이폰 11 MAX PRO", "휴대폰/태블릿","023001" ))
        SearchList.add(SearchItem("아이폰 11 MAX PRO", "휴대폰/태블릿","023001" ))
        SearchList.add(SearchItem("아이폰 11 MAX PRO", "휴대폰/태블릿","023001" ))


    }
}
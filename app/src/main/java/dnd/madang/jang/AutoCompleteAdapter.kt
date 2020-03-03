package dnd.madang.jang

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter

import java.util.ArrayList
import kotlinx.android.synthetic.main.row_serach.view.*


internal class AutoCompleteAdapter(context: Context,SearchList: List<SearchItem>) :
    ArrayAdapter<SearchItem>(context, 0, SearchList) {

    //데이터를 넣을 리스트
    private val searchListFull: List<SearchItem>

    init {
        searchListFull = ArrayList(SearchList)
        Log.d("Init:::","AutoCompleteAdapter")
    }



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            val view = LayoutInflater.from(context).inflate(
                R.layout.row_serach, parent, false
            );

        var item_name_View = view.item_name
        var category_name_View = view.category_name
        var category_code_View = view.category_code
        val searchitem = getItem(position)

        if (searchitem != null) {
            item_name_View.setText(searchitem.mch_prd_name)
            category_name_View.setText(searchitem.cate_name)
            category_code_View.setText(searchitem.mch_prd_cate)
        }


        return view
    }


    override fun getFilter() = mfilter

    private var mfilter: Filter = object : Filter() {

            override fun performFiltering(constraint: CharSequence?): Filter.FilterResults {

                val results = Filter.FilterResults()
                val suggestions = ArrayList<SearchItem>()

                if (constraint == null || constraint.length == 0) {
                    suggestions.addAll(searchListFull)
                } else {
                    val filterPattern = constraint.toString().toLowerCase().trim { it <= ' ' }

                    for (item in searchListFull) {
                        if (item.mch_prd_name.toLowerCase().contains(filterPattern)) {
                            suggestions.add(item)
                        }
                    }
                }

                results.values = suggestions
                results.count = suggestions.size

                return results
            }

            override fun publishResults(constraint: CharSequence?, results: Filter.FilterResults) {
                clear()
                addAll(results.values as ArrayList<SearchItem>)
                notifyDataSetChanged()
            }

            override fun convertResultToString(resultValue: Any): CharSequence {
                return (resultValue as SearchItem).mch_prd_name
            }
        }



}



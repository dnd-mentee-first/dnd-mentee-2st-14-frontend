package dnd.madang.jang


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_search.view.*


class SearchAdapter(private val context : Context, private val items: ArrayList<SearchItem>,private val how : String?) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener {it ->
            Toast.makeText(it.context, "Clicked: ${item.mch_prd_name}", Toast.LENGTH_SHORT).show()

            val intent = Intent(context,BuyActivity::class.java)
            val intent2 = Intent(context,SellActivity::class.java)
            intent.putExtra("PrdName",item.mch_prd_name)
            intent2.putExtra("PrdName",item.mch_prd_name)


            if(how == "buy")
                context.startActivity(intent)
            else(how == "sell")
                context.startActivity(intent2)

        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            SearchAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_search, parent, false)
        return SearchAdapter.ViewHolder(inflatedView)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v

        fun bind(listener: View.OnClickListener, item: SearchItem) {
            view.item_name.text = item.mch_prd_name
            view.category_name.text = item.cate_name
            view.category_code.text = item.mch_prd_cate
            view.setOnClickListener(listener)
        }
    }
}
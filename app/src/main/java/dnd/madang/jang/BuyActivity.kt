package dnd.madang.jang

import android.R.attr.entries
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_buy.*
import java.security.AccessController.getContext


class BuyActivity : AppCompatActivity(), View.OnClickListener {

    private var ItemList = ArrayList<Status_Btn>()
    private var ExampleList = ArrayList<Entry>()
    private var ExampleLabel = ArrayList<String>()
    private var state : String = "S"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)
        setChart()
        ExampleVO()






        ItemList.add(Status_Btn(true,status_btn_s))
        ItemList.add(Status_Btn(false,status_btn_a))
        ItemList.add(Status_Btn(false,status_btn_b))
        ItemList.add(Status_Btn(false,status_btn_c))

        status_btn_s.setOnClickListener(this)
        status_btn_a.setOnClickListener(this)
        status_btn_b.setOnClickListener(this)
        status_btn_c.setOnClickListener(this)
        buy_btn.setOnClickListener(this)

    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.status_btn_s -> {
                for(i in ItemList){
                    i.status = false
                }
                ItemList[0].status = !ItemList[0].status
                state = "S"
                updateUI()
            }
            R.id.status_btn_a -> {
                for(i in ItemList){
                    i.status = false
                }
                ItemList[1].status = !ItemList[1].status
                state = "A"
                updateUI()

            }
            R.id.status_btn_b -> {
                for(i in ItemList){
                    i.status = false
                }
                ItemList[2].status = !ItemList[2].status
                state = "B"
                updateUI()

            }
            R.id.status_btn_c -> {
                for(i in ItemList){
                    i.status = false
                }
                ItemList[3].status = !ItemList[3].status
                state = "C"
                updateUI()
            }

            R.id.buy_btn -> {
                val intent = Intent(this,BuyCompleteActivity::class.java)

                Log.d("buy_btn","clicked${R.id.buy_btn}")

                intent.putExtra("status",state)
                intent.putExtra("price",fieldHopePrice.text.toString())
                Log.d("buy_btn","real clicked${R.id.buy_btn}")

                startActivity(intent)

            }
        }
    }

    private fun updateUI(){
        for(i in ItemList){
            if(i.status)
                i.textview.alpha = 1f
            else
                i.textview.alpha = 0.5f
        }
    }

    private fun setChart() {


        val xAxis = buy_chart.xAxis



        xAxis.apply {
            xAxis.isEnabled = false
            granularity = 0.8f




        }


        buy_chart.apply {
            axisLeft.isEnabled = false
            axisRight.isEnabled = false
            description.isEnabled = false
            isDoubleTapToZoomEnabled = false
            isClickable = false
            setTouchEnabled(false)
            setPinchZoom(false)




            legend.apply {
                legend.isEnabled = false
            }

            val lineData  = LineData()
            buy_chart.data = lineData
        }
    }

    private fun ExampleVO() {
        val set = LineDataSet(null,"price")

        set.apply {
            color = resources.getColor(R.color.blue_theme)
            setCircleColor(resources.getColor(R.color.blue_theme))
            valueTextColor = resources.getColor(R.color.darkBrown)
            valueTextSize = 7f
            lineWidth = 5f
            circleRadius = 6f
            fillColor = resources.getColor(R.color.blue_theme)

            setDrawValues(true)

        }

        var data : LineData = buy_chart.data
        data.addDataSet(set)

        data.addEntry(Entry(0f,953000f),0)
        data.addEntry(Entry(1f,924290f),0)
        data.addEntry(Entry(2f,987310f),0)
        data.addEntry(Entry(3f,978320f),0)
        data.addEntry(Entry(4f,1032100f),0)
        data.addEntry(Entry(5f,1081200f),0)
        data.addEntry(Entry(6f,1120300f),0)
        data.notifyDataChanged()

        buy_chart.apply {

            notifyDataSetChanged()

        }

        ExampleLabel.add("03-01")
        ExampleLabel.add("03-02")
        ExampleLabel.add("03-03")
        ExampleLabel.add("03-04")
        ExampleLabel.add("03-05")
        ExampleLabel.add("03-06")
        ExampleLabel.add("03-07")
    }


}



//sign up test

package dnd.madang.jang

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import kotlinx.android.synthetic.main.activity_buy.*


class BuyActivity : AppCompatActivity() {

    private var ExampleList = ArrayList<Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)


    }
//
//    private fun setChart() {
//            val xAxis : XAxis = buy_chart.xAxis
//        xAxis.apply {
//            position = XAxis.XAxisPosition.BOTTOM
//            textSize = 10f
//            setDrawAxisLine(false)
//            granularity = 1f
//            axisMinimum =2f
//            isGranularityEnabled = true
//        }
//        buy_chart.apply {
//            axisRight.isEnabled = false
//            axisLeft.mAxisMaximum = 50f
//            legend.apply {
//                textSize = 15f
//                verticalAlignment = Legend.LegendVerticalAlignment.TOP
//                horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
//                orientation = Legend.LegendOrientation.HORIZONTAL
//                setDrawInside(false)
//            }
//        }
//        val lineData = LineData()
//        buy_chart.data = lineData
//
//    }
//
//    private fun makeChart(){
//        val dataSet = LineDataSet(ExampleList, "DATA");
//        dataSet.setColor(Color.BLUE);
//        RadarData data = new RadarData();
//        data.addDataSet(dataSet);
//        String[] labels = {"대형마트", "편의점", "학교", "학원", "지하철", "은행", "병원", "약국", "카페"};
//        XAxis xAxis = radarChart.getXAxis();
//        .setValueFormatter(new IndexAxisValueFormatter(labels));
//        radarChart.setData(data); }
//
//
//    private fun ExampleVO() {
//        ExampleList.add(Entry(1f,953000f))
//        ExampleList.add(Sa951510))
//        ExampleList.add(SampleData(924290))
//        ExampleList.add(SampleData(987310))
//        ExampleList.add(SampleData(978320))
//        ExampleList.add(SampleData(1032100))
//        ExampleList.add(SampleData(1081200))
//
//    }





}



//sign up test

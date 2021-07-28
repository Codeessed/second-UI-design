package com.example.recyclersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Details>
    private lateinit var personImage: Array<Int>
    private lateinit var name: Array<String>
    private lateinit var date: Array<String>
    private lateinit var daysLeft: Array<String>
    private lateinit var thinLine : Array<Int>
    lateinit var calendar : Array<Int>
    lateinit var cake: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val  value1 = Pager(R.drawable.tmf, "It's Jose's birthday")
        val  value2 = Pager(R.drawable.nick, "It's Nick's birthday")
        val  value3 = Pager(R.drawable.polo, "It's Polo's birthday")
        val  value4 = Pager(R.drawable.durkio, "It's Durk's birthday")
        val  value5 = Pager(R.drawable.roddyrich, "It's Roddy's birthday")


            val images = listOf(
                value1, value2, value3, value4, value5
            )
        val adapter1 = ViewPagerAdapter(images)
        val viewpager = findViewById<ViewPager2>(R.id.viewPager)
        viewpager.adapter = adapter1

        viewpager.offscreenPageLimit = 1
        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx

        viewpager.setPageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.25f * abs(position))
            // If you want a fading effect uncomment the next line:
            // page.alpha = 0.25f + (1 - abs(position))
            }

        val itemDecoration = HorizotalDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        viewpager.addItemDecoration(itemDecoration)

        personImage = arrayOf(R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5)
        name = arrayOf("John Bodige", "Mark Henry", "Mary Lazio", "Pryanka Chopra","Dunno Miller")
        date = arrayOf("23.05.2021","15.06.2021","01.02.2021","04.09.2021","05.09.2021")
        daysLeft = arrayOf("40 days left", "10 days left", "60 days left", "90 days left","2 days left")
        thinLine = arrayOf(R.drawable.first, R.drawable.second, R.drawable.third, R.drawable.fourth, R.drawable.fifth)
        calendar = arrayOf(R.drawable.ic_calendar, R.drawable.ic_calendar, R.drawable.ic_calendar, R.drawable.ic_calendar, R.drawable.ic_calendar)
        cake = arrayOf(R.drawable.ic_cake, R.drawable.ic_cake, R.drawable.ic_cake, R.drawable.ic_cake, R.drawable.ic_cake)

        newRecyclerView = findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        userdata()
    }

    private fun userdata() {
        for(i in personImage.indices){
            val details = Details(personImage[i],name[i], date[i], daysLeft[i], thinLine[i], calendar[i], cake[i])
            newArrayList.add(details)
        }
        newRecyclerView.adapter = DetailsAdapter(newArrayList)
    }
}
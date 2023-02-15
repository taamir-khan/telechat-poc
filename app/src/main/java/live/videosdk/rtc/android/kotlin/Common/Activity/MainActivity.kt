package live.videosdk.rtc.android.kotlin.Common.Activity

import live.videosdk.rtc.android.kotlin.Common.Modal.CareProvider
import live.videosdk.rtc.android.kotlin.R

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import live.videosdk.rtc.android.kotlin.Common.Adapter.DoctorListAdapter
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var newRecylerview : RecyclerView
    private lateinit var newArrayList : ArrayList<CareProvider>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var des : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            title = Html.fromHtml("<font color='#FFFFFF'>Telechat</font>")
            val colorDrawable = ColorDrawable(Color.parseColor("#31A78D"))
            setBackgroundDrawable(colorDrawable)
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.back_button_foreground)
            setDisplayShowHomeEnabled(true)
        }


        imageId = arrayOf(
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon,
            R.drawable.icon
        )

        heading = arrayOf(
            "Optimus Health Care",
            "Dr. Khan",
            "Dr. Shaw",
            "Dr. Nguyen",
            "Family Doctor",
            "Stamford Dentistry",
            "Dr. Stone",
            "Dr. Smith"
        )

        des = arrayOf(
            "General Health",
            "Dermatology",
            "Cardiology",
            "Radiology",
            "General Health",
            "Dentistry",
            "Pediatrician",
            "Private Practice"
        )


        newRecylerview =findViewById(R.id.recyclerView)
        newRecylerview.layoutManager = LinearLayoutManager(this)
        newRecylerview.setHasFixedSize(true)


        newArrayList = arrayListOf<CareProvider>()
        getUserdata()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    private fun getUserdata() {

        for(i in imageId.indices){

            val doctor = CareProvider(imageId[i], heading[i], des[i], true)
            newArrayList.add(doctor)

        }
        val adapter = DoctorListAdapter(newArrayList, context=baseContext)
        newRecylerview.adapter = adapter

    }

}











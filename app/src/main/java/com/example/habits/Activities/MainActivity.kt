package com.example.habits.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import com.example.habits.Adapters.AdapterViews
import com.example.habits.Data.DataHabits
import com.example.habits.Data.DataLiveFragment
import com.example.habits.databinding.ActivityMainBinding

val dataBase: DataHabits = DataHabits()


class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private val dataModel: DataLiveFragment by viewModels()
    private lateinit var viewPage : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewPage = viewBinding.viewpager
        viewPage.adapter = AdapterViews(supportFragmentManager)

        dataModel.msg.observe(this) {
            if (it.equals("добавить")) {
                val intent = Intent(this, AddActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

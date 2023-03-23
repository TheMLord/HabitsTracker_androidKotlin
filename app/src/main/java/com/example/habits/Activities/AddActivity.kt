package com.example.habits.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.habits.Data.DataLiveFragment
import com.example.habits.Fragments.AddHabitsFragment
import com.example.habits.Fragments.MainFragment
import com.example.habits.ModelHabits.Habits
import com.example.habits.R
import com.example.habits.databinding.ActivityAddBinding
import com.example.habits.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class AddActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAddBinding
    private val dataModel: DataLiveFragment by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        openFragment(AddHabitsFragment.newInstance(), R.id.frameLayoutAdd)

        dataModel.msg.observe(this) {
            if (it.equals("сохранить"))
                closeAddActivity()
        }

    }

    fun openFragment(fragment: Fragment, place: Int) {
        supportFragmentManager.beginTransaction()
            .replace(place, fragment).commit()
    }

    fun closeAddActivity() {
        finish()
    }
}
package com.example.habits.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.habits.Activities.dataBase
import com.example.habits.ModelHabits.Habits
import com.example.habits.R
import com.example.habits.databinding.FragmentBadHabitsBinding
import com.example.habits.databinding.FragmentBlank2Binding


class BadHabitsFragment : Fragment() {
    private lateinit var viewBinding: FragmentBadHabitsBinding
    private lateinit var listViewHabits: ListView
    private lateinit var adapterHabits: ArrayAdapter<Habits>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentBadHabitsBinding.inflate(inflater)

        val listBad: ArrayList<Habits> = getBadHabits()
        listViewHabits = viewBinding.listBadView
        adapterHabits = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listBad)
        listViewHabits.adapter = adapterHabits

        return viewBinding.root
    }

    override fun onStart() {
        super.onStart()
        adapterHabits.notifyDataSetChanged()
    }

    companion object {
        fun newInstance() = BadHabitsFragment()

    }

    private fun getBadHabits(): ArrayList<Habits> {
        val badList: ArrayList<Habits> = arrayListOf()
        dataBase.getList().forEach {
            if (it.type == "Плохая")
                badList.add(it)
        }
        return badList
    }
}
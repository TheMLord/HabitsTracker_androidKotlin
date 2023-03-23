package com.example.habits.Fragments

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.activityViewModels
import com.example.habits.Activities.dataBase
import com.example.habits.Data.DataLiveFragment
import com.example.habits.ModelHabits.Habits
import com.example.habits.databinding.FragmentBlankBinding

class MainFragment : Fragment() {
    private val dataModel : DataLiveFragment by activityViewModels()
    private lateinit var listViewHabits: ListView
    private lateinit var adapterHabits: ArrayAdapter<Habits>

    private lateinit var viewBinding: FragmentBlankBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentBlankBinding.inflate(inflater)

        listViewHabits = viewBinding.listView
        adapterHabits = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, dataBase.getList())
        listViewHabits.adapter = adapterHabits



        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.button1.setOnClickListener{
            dataModel.msg.value = "добавить"
        }
    }
    override fun onStart() {
        super.onStart()
        adapterHabits.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()

    }
}
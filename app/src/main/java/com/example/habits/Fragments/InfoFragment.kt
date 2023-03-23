package com.example.habits.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.habits.ModelHabits.Habits
import com.example.habits.R
import com.example.habits.databinding.FragmentGoodHabitsBinding
import com.example.habits.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {
    private lateinit var viewBinding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentInfoBinding.inflate(inflater)
        return viewBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = Bundle()
    }
}
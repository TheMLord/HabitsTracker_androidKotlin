package com.example.habits.Fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import com.example.habits.Activities.dataBase
import com.example.habits.Data.DataLiveFragment
import com.example.habits.ModelHabits.Habits
import com.example.habits.R
import com.example.habits.databinding.FragmentBlank2Binding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class AddHabitsFragment : Fragment() {
    private val dataModel: DataLiveFragment by activityViewModels()
    private lateinit var viewBinding: FragmentBlank2Binding

    private lateinit var nameHabit: String
    private lateinit var descriptionHabit: String
    private lateinit var priorityHabit: String
    private lateinit var typeHabit: String
    private lateinit var countHabits: String
    private lateinit var frequencyHabits: String


    private lateinit var editTextName: TextInputEditText
    private lateinit var editTextDescription: TextInputEditText
    private lateinit var editTextCount: TextInputEditText
    private lateinit var editTextFrequency: TextInputEditText


    private lateinit var textInputLayoutName: TextInputLayout
    private lateinit var textInputLayoutDescription: TextInputLayout
    private lateinit var textInputLayoutCount: TextInputLayout
    private lateinit var textInputLayoutFrequency: TextInputLayout

    private lateinit var spinnerHabits: Spinner

    private lateinit var radioHabits: RadioGroup

    private lateinit var buttonSave: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentBlank2Binding.inflate(inflater)
        //массив приоритета
        val spinnerArray = arrayListOf(1, 2, 3)

        //поиск по id TextInputEditText
        editTextName = viewBinding.editTextNameHabits
        editTextDescription = viewBinding.editTextDescriptionHabits
        editTextCount = viewBinding.editTextCountHabits
        editTextFrequency = viewBinding.editTextFrequencyHabits

        //поиск по id TextInputLayout
        textInputLayoutName = viewBinding.textInputLayoutNameHabits
        textInputLayoutDescription = viewBinding.textInputLayoutDescriptionHabits
        textInputLayoutCount = viewBinding.textInputLayoutCountHabits
        textInputLayoutFrequency = viewBinding.textInputLayoutFrequencyHabits

        //поиск по id Spinner
        spinnerHabits = viewBinding.spinner
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, spinnerArray
        )
        spinnerHabits.adapter = adapter
        spinnerHabits.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(requireContext(), "Выбрано: $selectedItem", Toast.LENGTH_SHORT)
                    .show()
                priorityHabit = selectedItem
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Ничего не делать
            }
        }
        //поиск по id radiogroup
        radioHabits = viewBinding.radioGroup
        radioHabits.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio_button1 -> {
                    typeHabit = "Хорошая"

                }
                R.id.radio_button2 -> {
                    typeHabit = "Плохая"
                }
            }
        }

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.saveButton.setOnClickListener {
            if (validateInput()) {
                val habits = Habits(
                    nameHabit,
                    descriptionHabit,
                    priorityHabit,
                    typeHabit,
                    countHabits,
                    frequencyHabits
                )

                dataBase.addHabits(habits)
                dataModel.msg.value = "сохранить"
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = AddHabitsFragment()
    }

    //проверка корректности ввода
    private fun validateInput(): Boolean {
        return validInputName() && validInputDecription()
                && validInputRadio() && validInputCount()
                && validInputFrequency()
    }

    //проверка ввода называния привычки
    private fun validInputName(): Boolean {
        val inputTextName = editTextName.text.toString()
        if (TextUtils.isEmpty(inputTextName)) {
            textInputLayoutName.error = "Введите название"
            return false
        } else {
            nameHabit = inputTextName
            return true
        }
    }

    //проверка ввода описания привычки
    private fun validInputDecription(): Boolean {
        val inputTextDescriptoin = editTextDescription.text.toString()
        return if (TextUtils.isEmpty(inputTextDescriptoin)) {
            textInputLayoutDescription.error = "Введите описание"
            false
        } else {
            descriptionHabit = inputTextDescriptoin
            true
        }
    }

    //проверка ввода типа привычки
    private fun validInputRadio(): Boolean {
        if (radioHabits.checkedRadioButtonId == -1) {
            showAlertDialog()
            return false
        }
        return true
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Ошибка")
        builder.setMessage("Выберите тип привычки")
        builder.setPositiveButton("ОК", null)
        val dialog = builder.create()
        dialog.show()
    }

    //проверка ввода количества привычки
    private fun validInputCount(): Boolean {
        val inputTextCount = editTextCount.text.toString()
        if (TextUtils.isEmpty(inputTextCount)) {
            textInputLayoutCount.error = "Введите количество"
            return false
        } else {
            countHabits = inputTextCount
            return true
        }
    }

    //проверка ввода периодичности привычки
    private fun validInputFrequency(): Boolean {
        val inputTextFrequency = editTextFrequency.text.toString()
        return if (TextUtils.isEmpty(inputTextFrequency)) {
            textInputLayoutFrequency.error = "Введите периодичность"
            false
        } else {
            frequencyHabits = inputTextFrequency
            true
        }
    }

}
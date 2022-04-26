package com.example.myapplication.ui.notifications

import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.work.*
import com.example.myapplication.VehicleUpdateWorker
import com.example.myapplication.databinding.FragmentNotificationsBinding


class NotificationsFragment : Fragment() {
    private var binding: FragmentNotificationsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val notificationsViewModel = ViewModelProvider(this, NewInstanceFactory()).get(
            NotificationsViewModel::class.java
        )
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        val pref =
            requireActivity().applicationContext.getSharedPreferences("MyPref", 0) // 0 - for private mode
        binding!!.make.setText("Make: " + pref.getString("current_make", null))
        binding!!.model.setText("Model: " + pref.getString("current_model", null))
        binding!!.color.setText("Color: " + pref.getString("current_color", null))
        binding!!.number.setText("Number: " + pref.getString("current_number", null))
        binding!!.state.setText("State: " + pref.getString("current_state", null))


        val editreg = binding!!.vehicleUpdateButton
        val confirmedit = binding!!.confirmUpdateButton

        editreg.setOnClickListener {
            editreg.visibility = View.GONE
            confirmedit.visibility = View.VISIBLE

            binding!!.make.setText("")
            binding!!.model.setText("")
            binding!!.color.setText("")
            binding!!.number.setText("")
            binding!!.state.setText("")

            binding!!.make.inputType = InputType.TYPE_CLASS_TEXT
            binding!!.model.inputType = InputType.TYPE_CLASS_TEXT
            binding!!.color.inputType = InputType.TYPE_CLASS_TEXT
            binding!!.number.inputType = InputType.TYPE_CLASS_TEXT
            binding!!.state.inputType = InputType.TYPE_CLASS_TEXT



        }

        confirmedit.setOnClickListener {
            confirmedit.visibility = View.GONE
            editreg.visibility = View.VISIBLE
            binding!!.make.inputType = InputType.TYPE_NULL
            binding!!.model.inputType = InputType.TYPE_NULL
            binding!!.color.inputType = InputType.TYPE_NULL
            binding!!.number.inputType = InputType.TYPE_NULL
            binding!!.state.inputType = InputType.TYPE_NULL

            val make = binding!!.make.text.toString()
            val model=binding!!.model.text.toString()
            val color=binding!!.color.text.toString()
            val number=binding!!.number.text.toString()
            val state=binding!!.state.text.toString()
            val name=pref.getString("current_username",null)
            Log.d("someone","finder")
            Log.d("someone",(pref.getString("current_username",null).toString()))

            val data = Data.Builder()
            data.putString("make", make)
            data.putString("model",model)
            data.putString("color",color)
            data.putString("number",number)
            data.putString("state",state)
            data.putString("name",name)
            val updateVehicleWorkRequest = OneTimeWorkRequest.Builder(VehicleUpdateWorker::class.java)
                .setInputData(data.build())
                .build()
            val workManager = WorkManager.getInstance(requireContext());
            workManager.enqueue(updateVehicleWorkRequest)

            val editor: SharedPreferences.Editor = pref.edit()
            editor.putString("current_make", make)
            editor.putString("current_model", model)
            editor.putString("current_color", color)
            editor.putString("current_number", number)
            editor.putString("current_state", state)
            editor.apply()
            binding!!.make.setText("Make: " + pref.getString("current_make", null))
            binding!!.model.setText("Model: " + pref.getString("current_model", null))
            binding!!.color.setText("Color: " + pref.getString("current_color", null))
            binding!!.number.setText("Number: " + pref.getString("current_number", null))
            binding!!.state.setText("State: " + pref.getString("current_state", null))



        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
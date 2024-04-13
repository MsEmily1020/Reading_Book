package com.example.fragmentstudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AddFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_fragment,
            container, false)

        arguments?.getInt("input1", 4)?.let {
            val input2 = arguments?.getInt("input2", 6)
            view.findViewById<TextView>(R.id.add_text).text = (it + input2!!).toString()
        }

        return view
    }

    companion object {
        fun newInstance(input1: Int, input2: Int)
                :ArgumentsFragment {

            val fragment = ArgumentsFragment()
            val bundle = Bundle()
            bundle.putInt("input1", input1)
            bundle.putInt("input2", input2)
            fragment.arguments = bundle

            return fragment
        }
    }
}
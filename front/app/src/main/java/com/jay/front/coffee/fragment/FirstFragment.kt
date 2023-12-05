package com.jay.front.coffee.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.jay.front.coffee.R
import com.jay.front.coffee.activity.MainActivity
import com.jay.front.coffee.databinding.FragmentFirstBinding
import com.jay.front.coffee.dto.PostModel
import com.jay.front.coffee.dto.PostResult
import com.jay.front.coffee.util.RetrofitAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    val api = RetrofitAPI.create()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            //retrofit test
            api.post_user().enqueue(object : Callback<PostResult> {
                override fun onResponse(call: Call<PostResult>, response: Response<PostResult>) {
                    Toast.makeText(context as MainActivity, response.toString(), Toast.LENGTH_SHORT).show()
                    Log.d("log",response.body().toString())

                }

                override fun onFailure(call: Call<PostResult>, t: Throwable) {
                    Toast.makeText(context as MainActivity, "fail", Toast.LENGTH_SHORT).show()
                    Log.d("log",t.message.toString())

                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
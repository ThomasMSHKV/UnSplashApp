package com.example.unsplashapp.presentor.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.unsplashapp.R
import com.example.unsplashapp.data.ApiRepository
import com.example.unsplashapp.databinding.FragmentSearchBinding
import kotlinx.coroutines.*
import kotlin.concurrent.fixedRateTimer
import kotlin.coroutines.CoroutineContext


class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var binding: FragmentSearchBinding


    companion object {
        var just = ""

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)


        binding.searchBottom.setOnClickListener {
            just = binding.searchComponent.text.toString()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer,OpenSearchFragment())
                ?.commit()
        }

    }


}


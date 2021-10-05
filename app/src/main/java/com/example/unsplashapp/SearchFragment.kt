package com.example.unsplashapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.unsplashapp.databinding.FragmentSearchBinding


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
                ?.replace(R.id.fragmentContainer, OpenSearchFragment())
                ?.commit()
        }

    }


}


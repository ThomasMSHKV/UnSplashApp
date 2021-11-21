package com.example.unsplashapp.presentor.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.unsplashapp.R
import com.example.unsplashapp.data.Result
import com.example.unsplashapp.data.Urls
import com.example.unsplashapp.data.UrlsX
import com.example.unsplashapp.databinding.FragmentOpenPictureBinding


class OpenPictureFragment() : Fragment(R.layout.fragment_open_picture) {
    private var _binding: FragmentOpenPictureBinding? = null
    private val binding get() = _binding
    private var result: Result? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOpenPictureBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        result = arguments?.getParcelable("key")

        binding?.imageOpen?.let {
            Glide.with(requireContext()).load(result?.urls).centerCrop()
                .into(binding?.imageOpen!!)
        }
    }


}
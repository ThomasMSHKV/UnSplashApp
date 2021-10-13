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
import com.example.unsplashapp.databinding.FragmentOpenPictureBinding


class OpenPictureFragment : Fragment(R.layout.fragment_open_picture), OpenPictureContract.View {
    private var _binding: FragmentOpenPictureBinding? = null
    private val binding get() = _binding!!
    private var count = 0

    private lateinit var presenter: OpenPicturesPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = OpenPicturesPresenter(this)

        count = arguments?.getInt("number")!!
        presenter.getPictures(arguments?.getString("key")!!)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOpenPictureBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun setData(result: Result) {
        Glide.with(requireContext()).load(result.id).centerCrop().into(binding.imageOpen)
    }
}
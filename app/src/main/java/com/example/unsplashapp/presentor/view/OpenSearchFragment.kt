package com.example.unsplashapp.presentor.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unsplashapp.R
import com.example.unsplashapp.data.ApiRepository
import com.example.unsplashapp.data.MainObjectClass
import com.example.unsplashapp.data.Result
import com.example.unsplashapp.databinding.FragmentOpenSearchBinding
import com.example.unsplashapp.domain.PicturesAdapter
import com.example.unsplashapp.domain.PicturesCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.concurrent.fixedRateTimer
import kotlin.coroutines.CoroutineContext


class OpenSearchFragment : Fragment(R.layout.fragment_open_search), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private lateinit var binding: FragmentOpenSearchBinding
    private lateinit var picturesCallback: PicturesCallback
    private lateinit var picAdapter: PicturesAdapter
    private var picturesList: MutableList<Result>? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOpenSearchBinding.bind(view)
        picAdapter = PicturesAdapter(picturesCallback)
        binding.recyclerFragmentOpen.adapter = picAdapter
        binding.recyclerFragmentOpen.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerFragmentOpen.setHasFixedSize(true)
        binding.recyclerFragmentOpen.setItemViewCacheSize(20)

        val repository = ApiRepository()

        launch {
            picturesList = repository.getData().await() as MutableList<Result>?
            picturesList?.let {
                picAdapter.setData(it)
            }
        }
        binding.searchBottomBack.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer,SearchFragment())
                ?.commit()
        }
    }

}


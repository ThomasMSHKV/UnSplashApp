package com.example.unsplashapp.presentor.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.unsplashapp.data.ApiRepository
import com.example.unsplashapp.databinding.FragmentSearchBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class SearchFragment : Fragment(), CoroutineScope{
    override val coroutineContext: CoroutineContext = Dispatchers.Main
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    lateinit var apiRepository: ApiRepository
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getPictures()
    }


    fun getPictures(){
        binding.searchBottom.setOnClickListener{
            GlobalScope.launch(Dispatchers.IO){
                val getPicResult = apiRepository.getData(binding.searchComponent.text.toString()).await()

                withContext(Dispatchers.Main){
                    if (getPicResult != null){

                    }

                }

            }
        }

    }

}
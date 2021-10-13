package com.example.unsplashapp.app

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.unsplashapp.R
import com.example.unsplashapp.data.ApiRepository
import com.example.unsplashapp.data.Result
import com.example.unsplashapp.databinding.FragmentOpenSearchBinding
import com.example.unsplashapp.domain.PicturesAdapter
import com.example.unsplashapp.presentor.view.OpenPictureFragment
import com.example.unsplashapp.view.OrdersCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class OpenSearchFragment : Fragment(R.layout.fragment_open_search), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private lateinit var binding: FragmentOpenSearchBinding
    private lateinit var picAdapter: PicturesAdapter
    private var picturesList: MutableList<Result>? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOpenSearchBinding.bind(view)

        init()
    }

    fun init() {
        picAdapter = PicturesAdapter(callback)
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
                ?.replace(R.id.fragmentContainer, SearchFragment())
                ?.commit()
        }
    }
    val callback = object: OrdersCallback {
        override fun setList(list: List<Result>) {

        }

        override fun openFragment(picture_id: String, number: Int) {
            Log.e("OpenSearch", "OPEN")
            val fragment = OpenPictureFragment()
            val bundle = Bundle()
            bundle.putString("key", picture_id)
            bundle.putInt("number", number)
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, fragment)
                ?.addToBackStack(null)
                ?.commit()

        }


    }
}





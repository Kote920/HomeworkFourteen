package com.example.homeworkfourteen.item

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageAndVideo.equals
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworkfourteen.BaseFragment
import com.example.homeworkfourteen.R
import com.example.homeworkfourteen.databinding.FragmentItemsBinding
import com.example.homeworkfourteen.item_detail.ItemDetailFragmentArgs


class ItemsFragment :  BaseFragment<FragmentItemsBinding>(FragmentItemsBinding::inflate) {


    private lateinit var adapter: ItemsRecyclerAdapter

    private  val args: ItemsFragmentArgs by navArgs()

    private val viewModel: ItemsViewModel by viewModels()

    override fun setUp() {


        initItemRecycler()
        listeners()


    }






    private fun initItemRecycler() {
        adapter = ItemsRecyclerAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerView.adapter = adapter
        adapter.apply {  submitList(viewModel.items)
        itemOnClick = {
        openItemDetail(it)

    }}
    }
     override fun listeners(){
        binding.btnAdd.setOnClickListener {
            openCraeteItem()
        }

        binding.layoutSwipe.setOnRefreshListener {
            fetchData()
        }

    }
    private fun fetchData() {

        binding.layoutSwipe.isRefreshing = false
    }



    private fun openItemDetail( item: Item) {
        findNavController().navigate(ItemsFragmentDirections.actionItemsFragmentToItemDetailFragment(
           item
        ))
    }

    private fun openCraeteItem(){
        findNavController().navigate(ItemsFragmentDirections.actionItemsFragmentToCreateItemFragment())
    }

}
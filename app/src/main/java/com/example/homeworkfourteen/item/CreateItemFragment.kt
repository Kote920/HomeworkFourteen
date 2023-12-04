package com.example.homeworkfourteen.item

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.homeworkfourteen.BaseFragment
import com.example.homeworkfourteen.R
import com.example.homeworkfourteen.databinding.FragmentCreateItemBinding
import com.example.homeworkfourteen.databinding.FragmentItemsBinding

class CreateItemFragment : BaseFragment<FragmentCreateItemBinding>(FragmentCreateItemBinding::inflate)  {

    private val viewModel: ItemsViewModel by viewModels()


    override fun setUp() {
       listeners()

    }
    override fun listeners(){
        binding.btnSave.setOnClickListener {


        }

    }
    private fun openItems( item: Item) {
        findNavController().navigate(CreateItemFragmentDirections.actionCreateItemFragmentToItemsFragment(
            item
        ))
    }


}
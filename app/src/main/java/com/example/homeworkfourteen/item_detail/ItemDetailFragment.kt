package com.example.homeworkfourteen.item_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.homeworkfourteen.BaseFragment
import com.example.homeworkfourteen.R
import com.example.homeworkfourteen.databinding.FragmentItemDetailBinding
import com.example.homeworkfourteen.databinding.FragmentItemsBinding
import com.example.homeworkfourteen.item.Item
import com.example.homeworkfourteen.item.ItemsFragmentDirections
import com.example.homeworkfourteen.item.ItemsRecyclerAdapter
import com.example.homeworkfourteen.item.ItemsViewModel


class ItemDetailFragment : BaseFragment<FragmentItemDetailBinding>(FragmentItemDetailBinding::inflate)  {

    private val args: ItemDetailFragmentArgs by navArgs()
    private lateinit var adapter: ItemsRecyclerAdapter

    private val viewModel: ItemsViewModel by viewModels()

    override fun setUp() {

        binding.etTitle.setText(args.item.title)
        binding.etText.setText(args.item.text)
        listeners()




    }

    override fun listeners(){
        binding.btnSave.setOnClickListener {
            args.item.title = binding.etTitle.text.toString()
            args.item.text = binding.etText.text.toString()
            openItems(args.item)
        }
//        binding.btnRemove.setOnClickListener {
//            viewModel.items.removeIf { it.id == args.item.id }
//            openItems()
//        }
    }

    private fun openItems( item: Item) {
        findNavController().navigate(
            ItemDetailFragmentDirections.actionItemDetailFragmentToItemsFragment(
                item
        ))
    }



}
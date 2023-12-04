package com.example.homeworkfourteen.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.homeworkfourteen.databinding.ItemRecyclerviewNoteBinding
import com.example.homeworkfourteen.databinding.ItemRecyclerviewTaskBinding

class ItemsRecyclerAdapter :
    ListAdapter<Item, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }) {




    fun setData(items: MutableList<Item>) {

        submitList(items)


    }
    fun removeItem(position: Int) {
        val currentListCopy = currentList.toMutableList()
        currentListCopy.removeAt(position)
        submitList(currentListCopy)
    }

    companion object {
        const val NOTE_TYPE = 1
        const val TASK_TYPE = 2

    }
    override fun getItemViewType(position: Int): Int {
        if(currentList[position].itemType == "NOTE"){
            return NOTE_TYPE
        }else{
            return TASK_TYPE

        }

    }
    lateinit var  itemOnClick: (Item)-> Unit

    inner class NoteViewHolder(private val binding: ItemRecyclerviewNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(){
                val item = currentList[adapterPosition]
                with(binding){
                    tvTitle.text = item.title

                }
                listeners(item)

            }

        private fun listeners(item: Item,){
           binding.tvSeeMore.setOnClickListener {
               itemOnClick.invoke(item)
           }

            binding.ivTrash.setOnClickListener {
                removeItem(adapterPosition)
            }
        }

    }

    inner class TaskViewHolder(private val binding:ItemRecyclerviewTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(){
            val item = currentList[adapterPosition]
            with(binding){
                tvTitle.text = item.title

            }
            listeners(item)
        }
        private fun listeners(item: Item){
            binding.tvSeeMore.setOnClickListener {
                itemOnClick.invoke(item)
            }
            binding.ivTrash.setOnClickListener {
                removeItem(adapterPosition)
            }
        }

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         if(viewType == NOTE_TYPE){
            return NoteViewHolder(
                ItemRecyclerviewNoteBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )}
        else{
            return TaskViewHolder(
                ItemRecyclerviewTaskBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(holder is NoteViewHolder){
            holder.bind()
        }else if(holder is TaskViewHolder){
            holder.bind()

        }
    }
}
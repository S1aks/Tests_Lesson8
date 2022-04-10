package com.example.lesson_8.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lesson_8.databinding.MainItemViewBinding
import com.example.lesson_8.domain.entities.GithubUser

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var usersList: MutableList<GithubUser> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun load(usersList: List<GithubUser>) {
        this.usersList = usersList as MutableList<GithubUser>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        MainItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    inner class ViewHolder(private val binding: MainItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(position: Int) = with(binding) {
            avatar.load(usersList[position].avatarUrl)
            name.text = usersList[position].login
        }
    }
}
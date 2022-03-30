package com.azalia.bfaa_submission_1

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azalia.bfaa_submission_1.DetailActivity.Companion.EXTRA_USER
import com.azalia.bfaa_submission_1.databinding.ItemListUserBinding
import com.azalia.bfaa_submission_1.model.User
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val listUser = ArrayList<User>()

    fun setAllData(data: List<User>){
        listUser.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ItemListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    inner class UserViewHolder(private val view: ItemListUserBinding): RecyclerView.ViewHolder(view.root){
        fun bind(user: User) {
            view.apply {
                tvUsername.text = user.username
                tvName.text = user.name
                tvCompany.text = user.company
            }

            Glide.with(itemView.context)
                .load(user.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(view.imgItemPhoto)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(EXTRA_USER, user)
                itemView.context.startActivity(intent)
            }
        }
    }
}

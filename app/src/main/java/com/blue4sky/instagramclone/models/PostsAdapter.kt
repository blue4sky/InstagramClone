package com.blue4sky.instagramclone.models

import android.content.Context
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blue4sky.instagramclone.R
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import java.security.MessageDigest
import java.security.MessageDigestSpi

class PostsAdapter(val context: Context, val posts: List<Post>) :
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position])
    }
    override fun getItemCount() = posts.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
            itemView.findViewById<TextView>(R.id.usernameTextView).text = post.user?.username
            itemView.findViewById<TextView>(R.id.descriptionTextview).text = post.description
            Glide.with(context).load(post.imageUrl).into(itemView.findViewById(R.id.postImageView))
            itemView.findViewById<TextView>(R.id.relativeTimeTextView).text = DateUtils.getRelativeTimeSpanString(post.creationTimeMs)
        }
    }


    }

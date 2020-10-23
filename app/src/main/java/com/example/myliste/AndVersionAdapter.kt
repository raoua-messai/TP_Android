package com.example.myliste

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_and_version.*
import kotlinx.android.synthetic.main.item_and_version.view.*


class AndVersionAdapter(val items: Array<AndVersion>) :

    RecyclerView.Adapter<AndVersionAdapter.ViewHolder>() {

    fun ViewGroup.inflate(
        @LayoutRes layoutRes: Int, attachToRoot:
        Boolean = false
    ): View {
        return LayoutInflater.from(context).inflate(
            layoutRes, this,
            attachToRoot
        )
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindAndVersion(andVersion: AndVersion) {
            with(andVersion) {
                andVersionTxt.text = "$name"
                description.text = "$descr"
                itemView.andVersionImg.setImageResource(img)
               // andVersionImg.setOnClickListener { itemView.context.toast("$name") }

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AndVersionAdapter.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_and_version))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindAndVersion(items[position])
    }
}
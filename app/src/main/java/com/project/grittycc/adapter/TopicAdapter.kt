package com.project.grittycc.adapter

import android.graphics.Typeface
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.project.grittycc.R
import com.project.grittycc.models.TopicModel

class TopicAdapter(private val topicList : ArrayList<TopicModel>) :
    RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    inner class TopicViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        override fun onClick(v: View?) {

        }
        val chapterName: TextView = itemView.findViewById(R.id.chapter_name)
        val linearLayout :  View = itemView.findViewById(R.id.hyper_links_layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.topic_items, null)
        return TopicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return topicList.size
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topicModel = topicList[position]

        holder.chapterName.text = topicModel.questionNumber
        val linearLayout = holder.linearLayout
        for (hyperLinks in topicModel.hyperLinks) {
            val hyperLink = TextView(holder.itemView.context)

            hyperLink.text = Html.fromHtml(hyperLinks)
            hyperLink.textSize = 18f
            hyperLink.setPadding(35, 25, 35, 25)
            hyperLink.setLinkTextColor(ContextCompat.getColor(holder.itemView.context, R.color.gray))
            hyperLink.setTypeface(hyperLink.typeface, Typeface.ITALIC)
            hyperLink.isClickable = true
            hyperLink.movementMethod = LinkMovementMethod.getInstance()
            hyperLink.layoutParams =
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

            (linearLayout as LinearLayout).addView(hyperLink)

        }
    }
}
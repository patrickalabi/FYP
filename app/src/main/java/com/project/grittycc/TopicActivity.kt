package com.project.grittycc

import android.graphics.Typeface
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.StyleSpan
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.project.grittycc.adapter.TopicAdapter
import com.project.grittycc.models.TopicModel


class TopicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic)

        topicsLink()

        findViewById<ImageView>(R.id.m_back_icon).setOnClickListener {
            finish()
        }

    }

    private fun topicsLink() {

        //Creating topic to fill here
        // Creating hyperlinks to redirect user to content on web
        val hyperLinkList = ArrayList<String>()
        //Cyber Legislation
        hyperLinkList.add(
                "<a href='https://www.slideshare.net/secret/uZcf5tOTYJO6vv'> General Data Protection Regulation</a>"
        )
        hyperLinkList.add(
            "<a href='https://www.slideshare.net/secret/o2mFtNr7KbbxDj'> International Cybercrime Part 1</a>"
        )

        hyperLinkList.add(
            "<a href='https://www.slideshare.net/secret/1ih7Pd9iLOIFfz'> International Cybercrime Part 2</a>"
        )

        hyperLinkList.add(
            "<a href='https://www.slideshare.net/secret/KbsomPyqF9g50H'> International Cybercrime Part 3</a>"
        )


        hyperLinkList.add(
            "<a href='https://www.slideshare.net/secret/ChYHpiGGZCitfo'> Computer Evidence Table</a>"
        )
        val hyperLinkChapter01 = TopicModel(
            "Chapter 01 Cyber Legislation", hyperLinkList
        )
        //Security Practices
        val hyperLinkList2 = ArrayList<String>()
        hyperLinkList2.add(
                "<a href='https://www.slideshare.net/secret/4dFqAyL0kpNvxY'> Password Security"

        )
        hyperLinkList2.add(
                "<a href='https://www.slideshare.net/secret/ChJ29rEApVFTxg'> Spam and Phishing"
        )
        hyperLinkList2.add(
                "<a href='https://www.slideshare.net/secret/akZ5A0z0M9YfAq'> Viruses and Worms"
        )

        val hyperLinkChapter02 = TopicModel(
            "Chapter 02 Security Practices", hyperLinkList2
        )

        val topicModelList = ArrayList<TopicModel>()
        topicModelList.add(hyperLinkChapter01)
        topicModelList.add(hyperLinkChapter02)

        val topicAdapter = TopicAdapter(topicModelList)
        findViewById<RecyclerView>(R.id.topic_recycler_view).adapter = topicAdapter
    }

}



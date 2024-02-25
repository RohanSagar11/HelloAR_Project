package com.example.helloar_project

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.helloar_project.VideoAdpat.myViewHolder

class VideoAdpat(var videos: ArrayList<Item>) :
    RecyclerView.Adapter<myViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.single_video_row, parent, false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.setData(videos[position])
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var videoView: VideoView
        var title: TextView
        var desc: TextView
        var pbar: ProgressBar
        var icon: ImageButton




        init {
            icon = itemView.findViewById(R.id.image)
            videoView = itemView.findViewById(R.id.videoView)
            title = itemView.findViewById(R.id.titleofvide)
            desc = itemView.findViewById(R.id.descofvideo)
            pbar = itemView.findViewById(R.id.progressbar)
            pbar.visibility = View.VISIBLE

        }

        @SuppressLint("ResourceType")
        fun setData(obj: Item) {
            videoView.setVideoPath(obj.videoUrl)
            title.text = obj.title
            desc.text = obj.desc
            videoView.setOnPreparedListener {
                mp -> mp.start()
                pbar.visibility = View.GONE
                videoView.setOnClickListener{
                    if (mp.isPlaying){
                        mp.pause()

                    }
                    else{
                        mp.start()

                    }
                }
                var isliked = true
                icon.setOnClickListener {
                    if (isliked) {
                        icon.setImageResource(R.drawable.baseline_add_reaction_24)
                        isliked = false;
                        // TODO: Remove like from the video
                    } else {
                        icon.setImageResource(R.drawable.outline_add_reaction_24);
                        isliked = true;
                        // TODO: Add like to the video
                    }
                }


            }
            videoView.setOnCompletionListener { mp -> mp.start()

            }
        }
    }
}

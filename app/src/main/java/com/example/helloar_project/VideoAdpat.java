//package com.example.helloar_project;
//
//import android.media.MediaPlayer;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.VideoView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class VideoAdpat extends RecyclerView.Adapter<VideoAdpat.myViewHolder>{
//    ArrayList<Item> videos;
//
//    public VideoAdpat(ArrayList<Item> videos){
//        this.videos = videos;
//    }
//
//    @NonNull
//    @Override
//    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_video_row, parent, false);
//        return new myViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
//        holder.setData(videos.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return videos.size();
//    }
//
//    class myViewHolder extends RecyclerView.ViewHolder{
//        VideoView videoView;
//        TextView title, desc;
//        ProgressBar pbar;
//        public myViewHolder(@NonNull View itemView) {
//            super(itemView);
//            videoView = itemView.findViewById(R.id.videoView);
//            title = itemView.findViewById(R.id.titleofvide);
//            desc = itemView.findViewById(R.id.descofvideo);
//            pbar = itemView.findViewById(R.id.progressbar);
//        }
//        void  setData(Item obj){
//            videoView.setVideoPath(obj.getVideoUrl());
//            title.setText(obj.getTitle());
//            desc.setText(obj.getDesc());
//            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mp) {
//                    mp.start();
//                }
//            });
//            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    mp.start();
//                }
//            });
//
//        }
//    }
//}

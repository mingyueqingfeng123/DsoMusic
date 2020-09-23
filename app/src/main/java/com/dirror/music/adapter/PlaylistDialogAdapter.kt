package com.dirror.music.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.dirror.music.MyApplication
import com.dirror.music.R
import com.dirror.music.music.StandardSongData
import com.dirror.music.util.parseArtist

class PlaylistDialogAdapter(private val list: ArrayList<StandardSongData>): RecyclerView.Adapter<PlaylistDialogAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvArtist: TextView = view.findViewById(R.id.tvArtist)
        val clSong: ConstraintLayout = view.findViewById(R.id.clSong)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.layout_playlist_dialog, parent, false).apply {
            return ViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = list[position].name
        holder.tvArtist.text = parseArtist(list[position].artists)
        holder.clSong.setOnClickListener {
            MyApplication.musicBinderInterface?.playMusic(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
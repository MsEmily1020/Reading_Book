package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        val musicList = mutableListOf<Music>()
        val img = arrayOf(R.drawable.queen, R.drawable.youdid, R.drawable._2002)
        val music = arrayOf("퀸카", "너였다면", "2002")
        val genre = arrayOf("KPOP", "발라드", "팝송")
        for (i in music.indices) {
            musicList.add(Music(music[i], genre[i], img[i]))
        }

        val listView = findViewById<RecyclerView>(R.id.music_list)
        listView.setHasFixedSize(true)
        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = MusicListAdapter(musicList)
    }
}
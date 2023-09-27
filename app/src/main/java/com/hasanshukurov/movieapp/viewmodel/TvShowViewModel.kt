package com.hasanshukurov.movieapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasanshukurov.movieapp.data.actor.ActorResponse
import com.hasanshukurov.movieapp.data.episode.EpisodeResponse
import com.hasanshukurov.movieapp.data.movie.TvShowResponse
import com.hasanshukurov.movieapp.repo.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(val repo: TvShowRepository) : ViewModel() {

    val tvShowList = MutableLiveData<TvShowResponse>()
    val actorList = MutableLiveData<ActorResponse>()
    val episodeList = MutableLiveData<EpisodeResponse>()



    fun getAllTvShowVM(){
        viewModelScope.launch(Dispatchers.Main) {
            tvShowList.value = repo.getAllTvShowRepo()
        }
    }


    fun getAllActorsVM(){
        viewModelScope.launch(Dispatchers.Main) {
            actorList.value = repo.getAllActorsRepo()
        }
    }


    fun getAllEpisodeVM(){
        viewModelScope.launch(Dispatchers.Main) {
            episodeList.value = repo.getAllEpisodeRepo()
        }
    }

}
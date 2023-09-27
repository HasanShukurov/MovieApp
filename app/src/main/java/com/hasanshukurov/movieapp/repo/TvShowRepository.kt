package com.hasanshukurov.movieapp.repo

import com.hasanshukurov.movieapp.data.movie.TvShowItem
import com.hasanshukurov.movieapp.data.service.ApiInterface
import javax.inject.Inject

class TvShowRepository @Inject constructor(
    private val api: ApiInterface) {

    suspend fun getAllTvShowRepo() = api.getAllTvShows().body()?.let {
        return@let it
    }

    suspend fun getAllActorsRepo() = api.getAllActors().body()?.let {
        return@let it
    }

    suspend fun getAllEpisodeRepo() = api.getAllEpisode().body()?.let {
        return@let it
    }

}
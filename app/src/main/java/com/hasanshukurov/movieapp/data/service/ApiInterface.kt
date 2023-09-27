package com.hasanshukurov.movieapp.data.service

import com.hasanshukurov.movieapp.data.actor.ActorResponse
import com.hasanshukurov.movieapp.data.episode.EpisodeResponse
import com.hasanshukurov.movieapp.data.movie.TvShowResponse
import com.hasanshukurov.movieapp.util.Constant
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    //  Movie
    @GET(Constant.END_POINT_TvShows)
    suspend fun getAllTvShows() : Response<TvShowResponse>

    // Actor
    @GET(Constant.END_POINT_Actors)
    suspend fun getAllActors() : Response<ActorResponse>

    // Episode
    @GET(Constant.END_POINT_Episodes)
    suspend fun getAllEpisode() : Response<EpisodeResponse>

}
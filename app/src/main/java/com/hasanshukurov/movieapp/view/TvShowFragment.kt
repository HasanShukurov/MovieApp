package com.hasanshukurov.movieapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.hasanshukurov.movieapp.adapter.ActorAdapter
import com.hasanshukurov.movieapp.adapter.EpisodeAdapter
import com.hasanshukurov.movieapp.adapter.MovieAdapter
import com.hasanshukurov.movieapp.databinding.FragmentTvShowBinding
import com.hasanshukurov.movieapp.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding
    private lateinit var viewModel: TvShowViewModel
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var actorAdapter: ActorAdapter
    private lateinit var episodeAdapter: EpisodeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val x: TvShowViewModel by viewModels()
        viewModel = x

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        GlobalScope.launch(Dispatchers.Main) {
            viewModel.tvShowList.observe(viewLifecycleOwner){

                movieAdapter = MovieAdapter(it)
                binding.recyclerView.adapter = movieAdapter
                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

            }
        }
        viewModel.getAllTvShowVM()


        GlobalScope.launch(Dispatchers.Main) {
            viewModel.actorList.observe(viewLifecycleOwner){

                actorAdapter = ActorAdapter(it)
                binding.rvActors.adapter = actorAdapter
                binding.rvActors.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

            }
        }
        viewModel.getAllActorsVM()




        GlobalScope.launch(Dispatchers.Main) {
            viewModel.episodeList.observe(viewLifecycleOwner){

                episodeAdapter = EpisodeAdapter(it)
                binding.rvRecentlyAdded.adapter = episodeAdapter
                binding.rvRecentlyAdded.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

            }
        }
        viewModel.getAllEpisodeVM()


    }

}
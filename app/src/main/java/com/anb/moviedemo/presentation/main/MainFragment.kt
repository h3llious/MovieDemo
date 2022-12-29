package com.anb.moviedemo.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.anb.moviedemo.databinding.FragmentMainBinding
import com.anb.moviedemo.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainBinding =
        FragmentMainBinding::inflate

    private val viewModel: MainViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        bindViewModel()
        bindViewEvents()
    }

    private fun initViews() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            adapter = movieAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        }
    }

    private fun bindViewModel() {
        viewModel.movies.observe(viewLifecycleOwner) {
            movieAdapter.setMovieList(it)
        }
    }

    private fun bindViewEvents() {
//        TODO("Not yet implemented")
    }
}

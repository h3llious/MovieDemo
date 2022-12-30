package com.anb.moviedemo.presentation.main

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.MenuCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.anb.moviedemo.R
import com.anb.moviedemo.databinding.FragmentMainBinding
import com.anb.moviedemo.presentation.base.BaseFragment
import com.anb.moviedemo.presentation.base.SORT_TYPE_RELEASE_DATE
import com.anb.moviedemo.presentation.base.SORT_TYPE_TITLE
import com.anb.moviedemo.presentation.main.MainFragmentDirections.Companion.actionMainFragmentToDetailFragment
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
        (activity as AppCompatActivity).supportActionBar?.hide()
        movieAdapter = MovieAdapter(onItemClickListener = {
            findNavController().navigate(actionMainFragmentToDetailFragment())
        })
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
        initSortPopup()
    }

    private fun initSortPopup() {
        val popup = PopupMenu(requireContext(), binding.tvSort)
        val menu = popup.menu
        MenuCompat.setGroupDividerEnabled(menu, true)
        popup.menuInflater.inflate(R.menu.menu_sort, menu)

        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.item_title -> viewModel.sortType = SORT_TYPE_TITLE
                R.id.item_release -> viewModel.sortType = SORT_TYPE_RELEASE_DATE
                R.id.item_cancel -> popup.dismiss()
            }
            true
        }
        binding.tvSort.setOnClickListener {
            for (i in 0 until menu.size()) {
                setTitleTypeface(menu.getItem(i), Typeface.NORMAL)
            }
            setTitleTypeface(menu.getItem(viewModel.sortType), Typeface.BOLD)
            popup.show()
        }
    }

    private fun setTitleTypeface(item: MenuItem, typeface: Int) {
        val newTitle = SpannableString(item.title.toString())
        newTitle.setSpan(
            StyleSpan(typeface), 0, newTitle.length, Spanned.SPAN_INCLUSIVE_INCLUSIVE
        )
        item.title = newTitle
    }
}

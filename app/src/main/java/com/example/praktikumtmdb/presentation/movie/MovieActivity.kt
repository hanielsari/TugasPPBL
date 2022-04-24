package com.example.praktikumtmdb.presentation.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praktikumtmdb.R
import com.example.praktikumtmdb.databinding.ActivityMovieBinding
import com.example.praktikumtmdb.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var binding: ActivityMovieBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createMovieSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
//        viewModel.getMovies().observe(this, Observer { movies ->
//            Log.i("TAG", movies.toString())
//        })
        initRecycleView()

    }

    fun initRecycleView() {
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.rvMovies.adapter = adapter
        displayPopularMovies()
    }

    fun displayPopularMovies() {
        binding.pbMovies.visibility = View.VISIBLE
        val response = viewModel.getMovies()
        response.observe(this, Observer { movies ->
            if (movies != null) {
                adapter.setList(movies)
            } else {
                Toast.makeText(this, "Data Tidak Ada", Toast.LENGTH_SHORT).show()
            }
            binding.pbMovies.visibility = View.GONE

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_update, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update->{
                updateMovies()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        binding.pbMovies.visibility = View.VISIBLE
        val response = viewModel.updateMovies()
        response.observe(this, Observer {movies->
            if(movies!=null){
                adapter.setList(movies)
            }else{
                Toast.makeText(this,"Data Tidak Ada", Toast.LENGTH_LONG).show()
            }
            binding.pbMovies.visibility =View.GONE

        })
    }
}

package com.example.praktikumtmdb.presentation.artist

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.praktikumtmdb.R
import com.example.praktikumtmdb.databinding.ActivityArtistBinding
import com.example.praktikumtmdb.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var binding: ActivityArtistBinding
    private lateinit var viewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createArtistComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)
        //        viewModel.getArtists().observe(this, Observer { artist ->
//            Log.i("TAG", artist.toString())
//        })
        initRecycleView()

    }

    fun initRecycleView() {
        binding.rvArtists.layoutManager = GridLayoutManager(this,2)
        adapter = ArtistAdapter()
        binding.rvArtists.adapter = adapter
        displayPopularArtists()
    }

    fun displayPopularArtists() {
        binding.pbArtists.visibility = View.VISIBLE
        val response = viewModel.getArtists()
        response.observe(this, Observer { artists ->
            if (artists != null) {
                adapter.setList(artists)
            } else {
                Toast.makeText(this, "Data Tidak Ada", Toast.LENGTH_SHORT).show()
            }
            binding.pbArtists.visibility = View.GONE

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
                updateArtists()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists(){
        binding.pbArtists.visibility = View.VISIBLE
        val response = viewModel.updateArtists()
        response.observe(this, Observer {artists->
            if(artists!=null){
                adapter.setList(artists)
            }else{
                Toast.makeText(this,"Data Tidak Ada", Toast.LENGTH_LONG).show()
            }
            binding.pbArtists.visibility =View.GONE

        })
    }
}



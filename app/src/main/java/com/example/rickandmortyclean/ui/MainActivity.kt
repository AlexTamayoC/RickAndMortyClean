package com.example.rickandmortyclean.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyclean.databinding.ActivityMainBinding
import com.example.rickandmortyclean.ui.states.MainStates

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private val viewModel: MainViewModel by lazy {
        MainViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        viewModel.fetchUsers()
        observeDataChanges()
    }

    private fun setupRecyclerView() {
        adapter = MainAdapter()
        binding.recyclerViewElement.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@MainActivity.adapter
        }
    }

    private fun observeDataChanges() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is MainStates.Error -> {
                    binding.progressBarView.visibility = View.GONE
                    Toast.makeText(this, "Character Fetching Failed", Toast.LENGTH_SHORT).show()
                }

                MainStates.Loading -> {
                    binding.recyclerViewElement.visibility = View.GONE
                    binding.progressBarView.visibility = View.VISIBLE
                }

                MainStates.None -> {}
                is MainStates.Success -> {
                    binding.progressBarView.visibility = View.GONE
                    binding.recyclerViewElement.visibility = View.VISIBLE
                    adapter.loadUsers(state.users)
                }
            }
        }
    }
}
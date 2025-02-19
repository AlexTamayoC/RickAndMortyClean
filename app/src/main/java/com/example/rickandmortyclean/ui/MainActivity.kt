package com.example.rickandmortyclean.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cai.randomuser.R
import com.cai.randomuser.databinding.ActivityMainBinding

//import com.example.rickandmortyclean.R

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
                    Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT).show()
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
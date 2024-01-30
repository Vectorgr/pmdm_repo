package com.victorgr.aplicacionespmdm.GiphyApps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.victorgr.aplicacionespmdm.R
import com.victorgr.aplicacionespmdm.databinding.ActivityGiphyBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GiphyListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGiphyBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: GiphyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giphy)

        binding = ActivityGiphyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI();

    }
    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
               searchByName(query.orEmpty())
                return false
            }
            override fun onQueryTextChange(newText: String?)= false;

        })
        adapter = GiphyAdapter ()
        binding.rvGiphy.setHasFixedSize(true)
        binding.rvGiphy.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvGiphy.adapter = adapter

    }

    private fun searchByName(query: String) {
        Log.i("Consulta", "Ocurriendo")
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<GiphyDataResponse> =
                retrofit.create(ApiGiphyService::class.java).getGiphys( giphyName = query)

            if (myResponse.isSuccessful) {
                Log.i("Consulta", "Succesful")
                val response: GiphyDataResponse? = myResponse.body()

                println("Response JSON: $response")
                if (response != null) {
                    Log.i("Cuerpo de la consulta", response.toString())
                    runOnUiThread {

                        adapter.updateList(response.data)
                        binding.progressBar.isVisible = false
                    }


                }

            } else {
                Log.i("Consulta", "No funciona :(")
            }

        }

    }
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.giphy.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}
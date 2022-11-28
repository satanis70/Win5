package com.example.win5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win5.adapters.AdapterLeague
import com.example.win5.adapters.AdapterTeams
import kotlinx.android.synthetic.main.fragment_popular_league.*
import kotlinx.android.synthetic.main.fragment_popular_teams.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory


class PopularLeagueFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popular_league, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiInterface = RetrofitInit.init()
        CoroutineScope(Dispatchers.IO).launch {
            val apiResponce = apiInterface.getPopularLeague().awaitResponse()
            if (apiResponce.isSuccessful){
                val recyclerAdapter = AdapterLeague(apiResponce.body()!!.league)
                launch(Dispatchers.Main) {
                    recycler_view_league.layoutManager = LinearLayoutManager(requireContext())
                    recycler_view_league.adapter = recyclerAdapter
                }
            }
        }
    }
}
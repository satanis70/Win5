package com.example.win5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win5.adapters.AdapterTeams
import kotlinx.android.synthetic.main.fragment_popular_teams.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class PopularTeamsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popular_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiInterface = RetrofitInit.init()

        GlobalScope.launch(Dispatchers.IO) {
            val apiResponce = apiInterface.getPopularTeams().awaitResponse()
            if (apiResponce.isSuccessful){
                val recyclerAdapter = AdapterTeams(apiResponce.body()!!.popularTeams)
                launch(Dispatchers.Main) {
                    recycler_view_teams.layoutManager = LinearLayoutManager(requireContext())
                    recycler_view_teams.adapter = recyclerAdapter
                }
            }
        }
    }
}
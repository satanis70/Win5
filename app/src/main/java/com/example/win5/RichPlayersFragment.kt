package com.example.win5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win5.adapters.AdapterLeague
import com.example.win5.adapters.AdapterPlayers
import kotlinx.android.synthetic.main.fragment_popular_league.*
import kotlinx.android.synthetic.main.fragment_rich_players.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class RichPlayersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_rich_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiInterface = RetrofitInit.init()
        GlobalScope.launch(Dispatchers.IO) {
            val apiResponce = apiInterface.getPlayers().awaitResponse()
            if (apiResponce.isSuccessful){
                val recyclerAdapter = AdapterPlayers(apiResponce.body()!!.richestPlayers)
                launch(Dispatchers.Main) {
                    recycler_view_players.layoutManager = LinearLayoutManager(requireContext())
                    recycler_view_players.adapter = recyclerAdapter
                }
            }
        }
    }
}
package com.example.win5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.onesignal.OneSignal
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(requireContext())
        OneSignal.setAppId(UTIL.ONESIGNAL_APP_ID)
        navController = Navigation.findNavController(view)
        button_teams.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToPopularTeamsFragment2()
            navController.navigate(action)
        }
        button_league.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToPopularLeague()
            navController.navigate(action)
        }
        button_rich_players.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToRichPlayers()
            navController.navigate(action)
        }
    }
}
package me.dilan.viewmodellivedata.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import me.dilan.viewmodellivedata.R

class MainFragment : Fragment() {

    private lateinit var userViewModel: UserViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        startCounter()
    }

    private fun startCounter() {
        userViewModel.startLifeTimer()
        userViewModel.user.observe(this, Observer {
            textViewName.text = getString(R.string.message, it?.username, it?.age)
        })
    }

}

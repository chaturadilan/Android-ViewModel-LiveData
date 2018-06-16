package me.dilan.viewmodellivedata.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.dilan.viewmodellivedata.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.layoutRoot, MainFragment.newInstance())
                    .commitNow()
        }

    }
}

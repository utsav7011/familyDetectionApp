package com.example.android.detectionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar)
        bottomBar.setOnItemSelectedListener {menuItem->

            if (menuItem.itemId == R.id.nav_guard){
                inflateFragment(guardFragment.newInstance())
            } else if (menuItem.itemId == R.id.nav_home){
                inflateFragment(homeFragment.newInstance())
            } else if (menuItem.itemId == R.id.nav_dashboard){
                inflateFragment(dashboardFragment.newInstance())
            } else if (menuItem.itemId == R.id.nav_profile){
                inflateFragment(profileFragment.newInstance())
            }

            true
        }
    }
    private fun inflateFragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()

    }

}
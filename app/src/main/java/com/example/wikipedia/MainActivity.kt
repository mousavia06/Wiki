package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.FragmentExplore
import com.example.wikipedia.fragments.FragmentProfile
import com.example.wikipedia.fragments.FragmentTrend

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBarMain)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this ,
            binding.drawerLayoutMain ,
            binding.toolBarMain ,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        firstRun(FragmentTrend())

        binding.navigationMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.writer_menu -> {
                    Toast.makeText(this, "salam", Toast.LENGTH_SHORT).show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.photographer_menu -> {}
                R.id.movie_maker_menu -> {}
                R.id.translator_menu -> {}
                R.id.wikipedia_menu -> {}
                R.id.wikimedia_menu -> {}
            }
            true
        }

        binding.bottomNavigationMain.setOnItemSelectedListener {

            when(it.itemId) {

                R.id.explore_menu -> {
                    replaceFragment(FragmentExplore())
                }
                R.id.trend_menu -> {
                    replaceFragment(FragmentTrend())
                }
                R.id.profile_menu -> {
                    replaceFragment(FragmentProfile())
                }


            }
            true
        }
        binding.bottomNavigationMain.setOnItemReselectedListener {  }

    }



    fun replaceFragment (fragment: Fragment ) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container , fragment )
        transaction.commit()
    }
    fun firstRun (fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container , fragment )
        transaction.commit()
        binding.bottomNavigationMain.selectedItemId = R.id.trend_menu
    }
}
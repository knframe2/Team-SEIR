package com.example.seirapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.seirapp.fragments.FavouriteFragment
import com.example.seirapp.fragments.HomeFragment
import com.example.seirapp.fragments.ProfileFragment
import com.example.seirapp.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val favouriteFragment = FavouriteFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_search -> replaceFragment(searchFragment)
                R.id.ic_person -> replaceFragment(profileFragment)
                R.id.ic_favourite -> replaceFragment(favouriteFragment)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}
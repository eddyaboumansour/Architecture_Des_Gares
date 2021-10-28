package com.ismin.csproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ismin.csproject.fragments.InfoFragment
import com.ismin.csproject.fragments.ListFragment
import com.ismin.csproject.fragments.MapFragment
import com.ismin.csproject.fragments.adapters.ViewPagerAdapter


class MainActivity : AppCompatActivity() {

     private lateinit var viewPager:ViewPager
     private lateinit var tabs:TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager=findViewById(R.id.viewPager)
        tabs=findViewById(R.id.tabs)
        setUpTabs()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.main_menu_refresh -> {

                true
            }
            // If we got here, the user's action was not recognized.
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun setUpTabs()

    {
        val adapter= ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ListFragment(), "Gares")
        adapter.addFragment(MapFragment(),"Locations")
        adapter.addFragment(InfoFragment(),"Info")
        viewPager.adapter=adapter
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_train_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_location_on_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_info_24)

    }
}
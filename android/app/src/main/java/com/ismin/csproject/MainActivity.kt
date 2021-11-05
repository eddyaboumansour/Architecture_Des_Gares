package com.ismin.csproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast

import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ismin.csproject.fragments.InfoFragment
import com.ismin.csproject.fragments.ListFragment
import com.ismin.csproject.fragments.MapFragment
import com.ismin.csproject.fragments.adapters.ViewPagerAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(),GareUpdater{

    private val TAG = MainActivity::class.java.simpleName

     private lateinit var viewPager:ViewPager
     private lateinit var tabs:TabLayout
     private var favorites=false
    val adapter= ViewPagerAdapter(supportFragmentManager)
    private val garesList=GaresList()
    private var fragment=ListFragment()
     val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
         .baseUrl("https://app-6c17b1b5-9cde-405a-938c-c79a21284ea3.cleverapps.io/")
         .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
        .build()

     val gareService = retrofit.create(GareService::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager=findViewById(R.id.viewPager)
        tabs=findViewById(R.id.tabs)
        loadAllGares("")

    }

    private fun loadAllGares(title:String)
    {
        gareService.getAllGare(title).enqueue(object : Callback<List<Gare>> {
            override fun onResponse(
                call: Call<List<Gare>>,
                response: Response<List<Gare>>
            ) {
                val allGares: List<Gare>? = response.body()

                allGares?.forEach {
                    if(favorites.equals(false)) {
                        garesList.addGare(it)
                    }
                    else
                    {
                        if(it.favoris.equals(true))
                        {
                            garesList.addGare(it)
                        }
                    }
                }


                setUpTabs()

            }

            override fun onFailure(call: Call<List<Gare>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(
                    this@MainActivity,
                    "Error when trying to fetch gares" + t.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            }


        }
        )



    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
            val item=menu?.findItem(R.id.main_menu_search)
            val searchView=item?.actionView as SearchView
            searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {

                    if (query != null) {

                        refreshTabs(query)
                    }
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    garesList.clear()


                    if (newText != null) {
                        Log.i("search" , newText)
                        refreshTabs(newText)

                    }

                    return false
                }
            })


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.main_menu_favorites -> {
                if(favorites.equals(false)) {
                    item.setIcon(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.ic_baseline_favorite_24_white
                        )
                    )
                    favorites = true

                }
                else
                {
                    item.setIcon(
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.ic_baseline_favorite_border_24_white
                        )
                    )
                    favorites = false

                }

                refreshTabs("")
                true
            }
            R.id.main_menu_refresh -> {
                garesList.clear()

                true
            }

            // If we got here, the user's action was not recognized.
            else -> super.onOptionsItemSelected(item)
        }

    }


    private fun refreshTabs(title:String)
    { gareService.getAllGare(title).enqueue(object : Callback<List<Gare>> {
        override fun onResponse(
            call: Call<List<Gare>>,
            response: Response<List<Gare>>
        ) {
            val allGares: List<Gare>? = response.body()
            garesList.clear()
            allGares?.forEach {
                if(favorites.equals(false)) {
                    garesList.addGare(it)

                }
                else
                {
                    if(it.favoris.equals(true))
                    {
                        garesList.addGare(it)
                    }
                }
            }

            fragment.setGare(garesList.getAllGares())


        }

        override fun onFailure(call: Call<List<Gare>>, t: Throwable) {
            t.printStackTrace()
            Toast.makeText(
                this@MainActivity,
                "Error when trying to fetch gares" + t.localizedMessage,
                Toast.LENGTH_LONG
            ).show()
        }


    }
    )


    }

    private fun setUpTabs()

    {

        fragment=ListFragment.newInstance(garesList.getAllGares())
        adapter.addFragment(fragment, "Gares")
        adapter.addFragment(MapFragment(garesList),"Locations")
        adapter.addFragment(InfoFragment(),"Info")


        viewPager.adapter=adapter
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_train_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_location_on_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_info_24)

    }

    override fun onGareUpdate(holder:GareViewHolder,gare: Gare,favoris:Boolean) {
       var favoris=Favoris(!favoris)

            gareService.addFavoris(gare.titre,favoris).enqueue(object : Callback<Gare> {
                override fun onResponse(
                    call: Call<Gare>,
                    response: Response<Gare>
                ) {
                    val updatedGare: Gare? = response.body()

                    updatedGare?.let {



                    }
                    gare.favoris=!favoris
                    refreshTabs("")

                }

                override fun onFailure(call: Call<Gare>, t: Throwable) {
                   Toast.makeText(this@MainActivity, "Error when trying to create a book" + t.localizedMessage, Toast.LENGTH_LONG).show()
                    Log.i("eddy","Hi3")
                }
            })

    }
    fun toggleFavoris(holder: GareViewHolder,favoris:Boolean)
    {   var icon:Int
        if(favoris) {icon=R.drawable.ic_baseline_favorite_24}
        else {icon=R.drawable.ic_baseline_favorite_border_24}
        holder.btnFavoris.setImageDrawable(
            ContextCompat.getDrawable(this@MainActivity, icon));
    }


}
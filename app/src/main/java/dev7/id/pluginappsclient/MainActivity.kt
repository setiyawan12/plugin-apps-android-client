package dev7.id.pluginappsclient

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.iammert.library.readablebottombar.ReadableBottomBar
import dev7.id.pluginappsclient.fragments.AccountFragment
import dev7.id.pluginappsclient.fragments.DashboardFragment
import dev7.id.pluginappsclient.fragments.EventFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var fragment : Fragment? = null
    companion object { private var navStatus = 0}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)
        bottomBarListener()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun bottomBarListener(){
        bottombar.setOnItemSelectListener(object : ReadableBottomBar.ItemSelectListener{
            override fun onItemSelected(index: Int) {
                when(index){
                    0 -> {
                        if(navStatus != 0){
                            fragment = DashboardFragment()
                            navStatus = 0
                        }
                    }

                    1 -> {
                        if(navStatus != 1){
                            fragment = EventFragment()
                            navStatus = 1
                        }
                    }

                    else -> {
                        if (navStatus != 2){
                            fragment = AccountFragment()
                            navStatus =2
                        }
                    }
                }
                if(fragment == null){
                    navStatus = 0
                    fragment = DashboardFragment()
                }

                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.screen_container, fragment!!)
                fragmentTransaction.commit()
            }
        })
    }
}

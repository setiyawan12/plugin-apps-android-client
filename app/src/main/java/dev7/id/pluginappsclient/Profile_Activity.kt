package dev7.id.pluginappsclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev7.id.pluginappsclient.adapters.PagerAdapter
import dev7.id.pluginappsclient.models.User
import kotlinx.android.synthetic.main.activity_profile_.*

class Profile_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_)

        viewpager.adapter = PagerAdapter(supportFragmentManager)
        tab_main.setupWithViewPager(viewpager)
        fill()
    }
    private fun getUser()=intent.getParcelableExtra<User>("user")

    private fun fill(){
        val user=getUser()
        user?.let {
            member_name.text=it.name
            member_role.text=it.role
        }
    }
}

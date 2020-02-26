package dev7.id.pluginappsclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev7.id.pluginappsclient.adapters.PagerAdapter
import dev7.id.pluginappsclient.fragments.PrestasiUserFragment
import dev7.id.pluginappsclient.fragments.ProfileFragment
import dev7.id.pluginappsclient.fragments.ContributionFragment
import dev7.id.pluginappsclient.models.User
import kotlinx.android.synthetic.main.activity_profile_.*

class PersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_)
        fill()
    }
    private fun getUser()=intent.getParcelableExtra<User>("user")

    private fun fill(){
        val fragmentPagerAdapter = PagerAdapter(supportFragmentManager)
        val user=getUser()
        user?.let {
            member_name.text=it.name
            member_role.text=it.role
            fragmentPagerAdapter.addNew(ProfileFragment.instance(it), "PROFIL")
            fragmentPagerAdapter.addNew(ContributionFragment(), "CONTRIBUSI")
            fragmentPagerAdapter.addNew(PrestasiUserFragment(), "PRESTASI")
            viewpager.adapter = fragmentPagerAdapter
            tab_main.setupWithViewPager(viewpager)
        }
    }
}

package dev7.id.pluginappsclient

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import coil.transform.CircleCropTransformation
import com.google.android.material.appbar.AppBarLayout
import dev7.id.pluginappsclient.adapters.PagerAdapter
import dev7.id.pluginappsclient.fragments.ContributionFragment
import dev7.id.pluginappsclient.fragments.PrestasiUserFragment
import dev7.id.pluginappsclient.fragments.ProfileFragment
import dev7.id.pluginappsclient.models.User
import kotlinx.android.synthetic.main.activity_person_detail.*
import kotlinx.android.synthetic.main.content_person_detail.*

class PersonDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_detail)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener { finish() }
        toolbar_layout.title = " "
        fillUser()
        initCollapsingToolbar()
    }


    private fun initCollapsingToolbar(){
        app_bar.addOnOffsetChangedListener( AppBarLayout.OnOffsetChangedListener { _, i ->
            val isShow = false
            var scrollRange = -1
            if (scrollRange == -1) {
                scrollRange = app_bar.totalScrollRange
            }
            when {
                scrollRange + i == 0 -> {
                    toolbar_layout.title = getUser()?.name
                }
                isShow -> {
                    toolbar_layout.title = " "
                }
                scrollRange + i > 0 -> {
                    toolbar_layout.title = " "
                }
            }
        })
    }

    private fun getUser() = intent.getParcelableExtra<User>("user")

    private fun fillUser(){
        val fragmentPagerAdapter = PagerAdapter(supportFragmentManager)
        val user=getUser()
        user?.let {
            person_display_name.text = it.name
            person_photo.load(it.avatar){
                crossfade(true)
                transformations(CircleCropTransformation())
                placeholder(R.drawable.ic_person_black_24dp)
            }
            fragmentPagerAdapter.addNew(ProfileFragment.instance(it), "PROFIL")
            fragmentPagerAdapter.addNew(ContributionFragment(), "KONTRIBUSI")
            fragmentPagerAdapter.addNew(PrestasiUserFragment(), "PRESTASI")
            vp_person_detail.adapter = fragmentPagerAdapter
            tabs.setupWithViewPager(vp_person_detail)
        }
    }
}

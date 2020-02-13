package dev7.id.pluginappsclient.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dev7.id.pluginappsclient.fragments.DetailuserFragment
import dev7.id.pluginappsclient.fragments.PrestasiUserFragment
import dev7.id.pluginappsclient.fragments.ContributionFragment

class PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    private val pages = listOf(
        DetailuserFragment(),
        PrestasiUserFragment(),
        ContributionFragment()
    )

    private var fragments = mutableListOf<Fragment>()
    private var titles = mutableListOf<String>()


    fun addNew(fragment: Fragment, title : String) {
        fragments.add(fragment)
        titles.add(title)
    }
    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = titles[position]
}
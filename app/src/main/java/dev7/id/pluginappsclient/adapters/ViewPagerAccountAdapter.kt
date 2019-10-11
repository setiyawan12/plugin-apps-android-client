package dev7.id.pluginappsclient.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import dev7.id.pluginappsclient.fragments.VpAccountInfoFragment
import dev7.id.pluginappsclient.fragments.VpAccountMainFragment
import dev7.id.pluginappsclient.models.User

class ViewPagerAccountAdapter(fm: FragmentManager, user : User): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val pages = listOf(VpAccountMainFragment(user), VpAccountInfoFragment(user))

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getCount() = pages.size
}
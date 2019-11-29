package dev7.id.pluginappsclient.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dev7.id.pluginappsclient.fragments.DetailuserFragment
import dev7.id.pluginappsclient.fragments.PrestasiUserFragment
import dev7.id.pluginappsclient.fragments.TentanguserFragment

class PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    private val pages = listOf(
        DetailuserFragment(),
        PrestasiUserFragment(),
        TentanguserFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Profil"
            1 -> "Tentang"
            else -> "Pencapaian"
        }
    }
}
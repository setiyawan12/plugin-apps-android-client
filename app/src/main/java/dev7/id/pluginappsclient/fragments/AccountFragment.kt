package dev7.id.pluginappsclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.api.load
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.adapters.FragmentPagerAdapter
import dev7.id.pluginappsclient.adapters.ViewPagerAccountAdapter
import dev7.id.pluginappsclient.contracts.fragments.AccountFragmentContract
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.presenters.fragments.AccountFragmentPresenter
import kotlinx.android.synthetic.main.fragment_account.view.*

class AccountFragment : Fragment(), AccountFragmentContract.View {
    private var presenter = AccountFragmentPresenter(this)
    private var user : User? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getUser("konotoru")

    }

    override fun toast(message: String) = Toast.makeText(activity, message , Toast.LENGTH_SHORT).show()

    override fun retrieve_user(user: User) {
        this.user = user
        val fa = FragmentPagerAdapter(childFragmentManager).apply {
            add(ProfileFragment(user), "PROFILE")
            add(ContributionFragment(user), "CONTRIBUTION")
            add(AchievementFragment(user), "ACHIEVEMENT")
        }

        view!!.vp_content.adapter = fa
        view!!.account_bg.load(user.avatar)
        view!!.account_vp.adapter = ViewPagerAccountAdapter(childFragmentManager, user)
        view!!.account_tabs.setupWithViewPager(view!!.vp_content)
    }
}
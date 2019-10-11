package dev7.id.pluginappsclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.contracts.fragments.VpAccountInfoContract
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.presenters.fragments.VpAccountInfoPresenter
import kotlinx.android.synthetic.main.vp_account_more.view.*

class VpAccountInfoFragment(var user : User) : Fragment(), VpAccountInfoContract.View{
    private var presenter = VpAccountInfoPresenter(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(R.layout.vp_account_more, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
    }

    override fun bind() { view?.account_bio?.text = user.member_id }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}
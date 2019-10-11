package dev7.id.pluginappsclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.api.load
import coil.transform.CircleCropTransformation
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.contracts.fragments.VpAccountMainContract
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.presenters.fragments.VpAccountMainPresenter
import kotlinx.android.synthetic.main.vp_account_main.view.*

class VpAccountMainFragment(var user: User) : Fragment(), VpAccountMainContract.View {
    private var presenter = VpAccountMainPresenter(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.vp_account_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
    }

    override fun bind() {
        view?.let {
            it.account_avatar.load(user.avatar){
                crossfade(true)
                crossfade(800)
                transformations(CircleCropTransformation())
            }
            it.account_fullname.text = user.name
            it.account_email.text = user.email
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}
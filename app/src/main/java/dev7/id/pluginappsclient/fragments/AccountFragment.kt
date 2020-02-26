package dev7.id.pluginappsclient.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.contracts.fragments.AccountFragmentContract
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.presenters.fragments.AccountFragmentPresenter
import dev7.id.pluginappsclient.utilities.PluginUtils
import kotlinx.android.synthetic.main.fragment_account.view.*

class AccountFragment : Fragment(R.layout.fragment_account), AccountFragmentContract.View{
    private var presenter = AccountFragmentPresenter(this)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.fetchMyProfile(PluginUtils.getToken(activity!!).toString())
    }

    override fun isLoading(state: Boolean) {
        if(state){
            view!!.btn_edit.isEnabled = false
            view!!.btn_save.isEnabled = false
        }else{
            view!!.btn_edit.isEnabled = true
            view!!.btn_save.isEnabled = true
        }
    }

    override fun toast(message: String) = Toast.makeText(activity, message, Toast.LENGTH_LONG).show()

    override fun retrieveMyProfile(user: User?) {
        user?.let {
            view!!.et_name.setText(it.name)
            view!!.et_email.setText(it.email)
        }
    }
}
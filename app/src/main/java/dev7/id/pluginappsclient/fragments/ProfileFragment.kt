package dev7.id.pluginappsclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.models.User
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    companion object {
        fun instance(user : User) : Fragment{
            val args = Bundle()
            args.putParcelable("user", user)
            return ProfileFragment().apply {
                arguments = args
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {arg ->
            val user : User? = arg.getParcelable("user")
            user?.let {
                view.email.text = it.email
                view.username.text = it.name
                view.nim.text = it.personal?.nim.toString()
                view.phone.text = it.personal?.phone.toString()
                view.github.text = if (it.personal?.github == null) "belum di isi" else it.personal?.github.toString()
                view.telegram.text = it.personal?.telegram.toString()
            }
        }
    }
}
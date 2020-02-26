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
                view.detail_email.text = it.email
                view.detail_name.text = it.name
                view.detail_nim.text = if (it.personal?.nim == null) "Belum ditentukan" else it.personal?.nim.toString()
                view.detail_phone.text = if (it.personal?.phone == null) "Belum ditentukan" else it.personal?.phone.toString()
                view.detail_github.text = if (it.personal?.github == null) "Belum ditentukan" else it.personal?.github.toString()
                view.detail_telegram.text = if (it.personal?.telegram == null) "Belum ditentukan" else it.personal?.telegram.toString()
                view.detail_jabatan.text= if (it.personal?.role == null) "Belum ditentukan" else it.personal?.role.toString()
                view.detail_class.text = if (it.personal?.Class == null) "Belum ditentukan" else it.personal?.Class.toString()
            }
        }
    }
}
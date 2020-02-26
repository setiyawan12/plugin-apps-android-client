package dev7.id.pluginappsclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.jama.carouselview.enums.IndicatorAnimationType
import com.jama.carouselview.enums.OffsetType
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.adapters.UserAdapter
import dev7.id.pluginappsclient.contracts.fragments.DashboardFragmentContract
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.presenters.fragments.DashboardFragmentPresenter
import dev7.id.pluginappsclient.utilities.PluginUtils
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.item_list_carousel.view.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard), DashboardFragmentContract.View {
    private var presenter = DashboardFragmentPresenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.allUser("${PluginUtils.getToken(activity!!)}")
        carouselView.apply {
            resource = R.layout.item_list_carousel
            autoPlay = true
            indicatorAnimationType = IndicatorAnimationType.THIN_WORM
            carouselOffset = OffsetType.START
            setCarouselViewListener { view, position ->
                view.imageView.load("https://d15hng3vemx011.cloudfront.net/attachment/66838678621842369664.large")
            }
            show()
        }
    }

    override fun attachToRecycler(users: List<User>) {
        view!!.rv_users.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = UserAdapter(users, activity!!)
        }
    }

    override fun isLoading(state: Boolean) { if(state)view!!.loading.visibility = View.VISIBLE else view!!.loading.visibility = View.GONE }

    override fun toast(message: String) = Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

}
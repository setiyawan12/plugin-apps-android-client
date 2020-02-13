package dev7.id.pluginappsclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.adapters.CarouselAdapter
import dev7.id.pluginappsclient.adapters.UserAdapter
import dev7.id.pluginappsclient.contracts.fragments.DashboardFragmentContract
import dev7.id.pluginappsclient.models.Event
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.presenters.fragments.DashboardFragmentPresenter
import dev7.id.pluginappsclient.utilities.PluginUtils
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment(), DashboardFragmentContract.View {
    private var presenter = DashboardFragmentPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.allUser("${PluginUtils.getToken(activity!!)}")

        val events = mutableListOf<Event>().apply {
            add(Event(1, "Lomba 1", "https://www.appohm.com/wp-content/uploads/2019/04/ui-1.jpg"))
            add(Event(1, "Lomba 2", "https://theninehertz.com/wp-content/uploads/2019/04/hire-ui-ux-designers-bnr-img.png"))
            add(Event(1, "Lomba 4", "https://qubstudio.com/wp-content/uploads/2018/12/trends_in_ux_for_ecommerce_websites.png"))
            add(Event(1, "Lomba 6", "https://blog.creative-tim.com/wp-content/uploads/2019/01/1_RTaL5dyKdVjXmFmC756hUw-730x410.png")
            )
        }
        view.imageSlider.sliderAdapter = CarouselAdapter(activity!!, events)
        view.imageSlider.startAutoCycle()
        view.imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM)
        view.imageSlider.setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
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
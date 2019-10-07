package dev7.id.pluginappsclient.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarteist.autoimageslider.IndicatorAnimations
import dev7.id.pluginappsclient.R
import dev7.id.pluginappsclient.adapters.CarouselAdapter
import dev7.id.pluginappsclient.adapters.UserAdapter
import dev7.id.pluginappsclient.contracts.fragments.DashboardFragmentContract
import dev7.id.pluginappsclient.models.Event
import dev7.id.pluginappsclient.models.User
import dev7.id.pluginappsclient.presenters.fragments.DashboardFragmentPresenter
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment(), DashboardFragmentContract.View {
    private var presenter = DashboardFragmentPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.allUser()
        val events = mutableListOf<Event>().apply {
            add(Event(1, "Lomba 1", "https://media.thestar.com.my/Prod/BC31E7E4-06FF-40A1-8B75-E812DE06F54B"))
            add(Event(1, "Lomba 2", "https://media.thestar.com.my/Prod/BC31E7E4-06FF-40A1-8B75-E812DE06F54B"))
            add(Event(1, "Lomba 3", "https://media.thestar.com.my/Prod/BC31E7E4-06FF-40A1-8B75-E812DE06F54B"))
        }
        view.imageSlider.sliderAdapter = CarouselAdapter(activity!!, events)
        view.imageSlider.startAutoCycle()
        view.imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM)
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
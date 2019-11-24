package ar.com.pabloflores.harrypotter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.pabloflores.harrypotter.R
import ar.com.pabloflores.harrypotter.databinding.FragmentHouseInfoBinding
import ar.com.pabloflores.harrypotter.ui.adapter.HouseInfoAdapter
import ar.com.pabloflores.harrypotter.ui.viewmodel.HouseInfoViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_house_info.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pablo Flores on 06/11/19.
 */
@ExperimentalCoroutinesApi
class HouseInfoFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HouseInfoViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HouseInfoViewModel::class.java)
    }

    private var houseInfoAdapter: HouseInfoAdapter? = null
    private lateinit var house: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHouseInfoBinding>(
            inflater,
            R.layout.fragment_house_info,
            container,
            false
        )

        houseInfoAdapter = HouseInfoAdapter()

        binding.root.findViewById<RecyclerView>(R.id.character_recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = houseInfoAdapter
        }

        house = this.arguments?.let { HouseInfoFragmentArgs.fromBundle(it).house }.toString()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getHouseInfo(house)
        with(viewModel) {
            houseInfo.observe(this@HouseInfoFragment, Observer { houseInfo ->
                houseInfoAdapter?.addHouseInfo(houseInfo)
                view.loading_spinner.visibility = View.GONE
            })
            error.observe(this@HouseInfoFragment, Observer {
                view.loading_spinner.visibility = View.GONE
                Timber.e(String.format("HouseInfoFragment %s ", it?.message))
            })
        }
    }
}

package ar.com.pabloflores.harrypotter.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import ar.com.pabloflores.harrypotter.R
import ar.com.pabloflores.harrypotter.databinding.FragmentSortingHatBinding
import ar.com.pabloflores.harrypotter.ui.viewmodel.SortingHatViewModel
import ar.com.pabloflores.harrypotter.util.House
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pablo Flores on 30/10/19.
 */
@ExperimentalCoroutinesApi
class SortingHatFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SortingHatViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SortingHatViewModel::class.java)
    }

    private lateinit var vKnowYourHouseButton: Button
    private lateinit var vNameEt: EditText
    private lateinit var vHouse: ImageView
    private lateinit var vSchoolMates: Button
    private var house: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSortingHatBinding>(
            inflater, R.layout.fragment_sorting_hat, container, false
        )

        binding.btnKnowYourSchoolMates.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(
                    SortingHatFragmentDirections.actionSortingHatFragmentToHouseInfoFragment(
                        this@SortingHatFragment.house
                    )
                )
        }

        vKnowYourHouseButton = binding.btnKnowYourHouse
        vNameEt = binding.etName
        vHouse = binding.ivHouse
        vSchoolMates = binding.btnKnowYourSchoolMates

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vKnowYourHouseButton.setOnClickListener {
            viewModel.getHouse()
            handleViews()
        }
        with(viewModel) {
            house.observe(this@SortingHatFragment, Observer { house ->
                vHouse.visibility = View.VISIBLE
                setImage(house)
                this@SortingHatFragment.house = house
                vSchoolMates.visibility = View.VISIBLE
            })
            error.observe(this@SortingHatFragment, Observer {
                Timber.e("SortingHatUseCase Fragment %s ", it.message)
            })
        }
    }

    private fun handleViews() {
        vKnowYourHouseButton.isEnabled = false
        vNameEt.isEnabled = false
    }

    private fun setImage(house: String?) {
        when (house) {
            House.GRYFFINDOR -> vHouse.setImageResource(R.drawable.griffindor)
            House.HUFFLEPUFF -> vHouse.setImageResource(R.drawable.hufflepuf)
            House.RAVENCLAW -> vHouse.setImageResource(R.drawable.ravenclaw)
            House.SLYTHERIN -> vHouse.setImageResource(R.drawable.slytherin)
        }
    }
}
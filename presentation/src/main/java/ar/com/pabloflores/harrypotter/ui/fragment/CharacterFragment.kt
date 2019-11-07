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
import ar.com.pabloflores.harrypotter.databinding.FragmentCharacterBinding
import ar.com.pabloflores.harrypotter.ui.adapter.CharacterAdapter
import ar.com.pabloflores.harrypotter.ui.viewmodel.CharacterViewModel
import ar.com.pabloflores.harrypotter.util.House
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_character.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pablo Flores on 06/11/19.
 */
@ExperimentalCoroutinesApi
class CharacterFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CharacterViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(CharacterViewModel::class.java)
    }

    private var characterAdapter: CharacterAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCharacterBinding>(
            inflater,
            R.layout.fragment_character,
            container,
            false
        )

        characterAdapter = CharacterAdapter()

        binding.root.findViewById<RecyclerView>(R.id.character_recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharactersByHouse(House.SLYTHERIN)
        with(viewModel) {
            characters.observe(this@CharacterFragment, Observer { characters ->
                characterAdapter?.characters = characters
                view.loading_spinner.visibility = View.GONE
            })
            error.observe(this@CharacterFragment, Observer {
                view.loading_spinner.visibility = View.GONE
                Timber.e(String.format("CharacterFragment %s ", it?.message))
            })
        }
    }
}

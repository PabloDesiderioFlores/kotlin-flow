package ar.com.pabloflores.harrypotter.ui.activity

import android.os.Bundle
import ar.com.pabloflores.harrypotter.R
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by Pablo Flores on 29/10/19.
 */
class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
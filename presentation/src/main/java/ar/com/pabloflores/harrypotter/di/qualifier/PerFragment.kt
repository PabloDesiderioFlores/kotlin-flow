package ar.com.pabloflores.harrypotter.di.qualifier

import javax.inject.Scope

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the fragment to be memorized in the
 * correct component.
 */
@Scope
@Retention
annotation class PerFragment
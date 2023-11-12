package com.dicoding.jetheroes

import androidx.lifecycle.*
import com.dicoding.jetheroes.data.*

class ViewModelFactory(private val repository: HeroRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JetHeroesViewModel::class.java)) {
            return JetHeroesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}
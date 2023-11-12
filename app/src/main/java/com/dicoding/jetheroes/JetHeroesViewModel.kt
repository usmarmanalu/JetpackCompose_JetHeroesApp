package com.dicoding.jetheroes

import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.dicoding.jetheroes.data.*
import com.dicoding.jetheroes.model.*
import kotlinx.coroutines.flow.*

class JetHeroesViewModel(private val repository: HeroRepository) : ViewModel() {
    private val _groupedHeroes = MutableStateFlow(
        repository.getHeroes().sortedBy { it.name }.groupBy { it.name[0] }
    )
    val groupedHeroes: StateFlow<Map<Char, List<Hero>>> get() = _groupedHeroes

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedHeroes.value = repository.searchHeroes(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}
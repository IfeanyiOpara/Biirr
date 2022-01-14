package ifeanyi.opara.biirr.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ifeanyi.opara.biirr.data.toBeer
import ifeanyi.opara.biirr.mainRepository.BeerRepository
import ifeanyi.opara.biirr.models.Beer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    private val repository: BeerRepository
) : ViewModel() {

    var beers : MutableLiveData<ArrayList<Beer>>

    init {
        beers = MutableLiveData()
        getBeers()
    }

    fun getBeerObserver() : MutableLiveData<ArrayList<Beer>>{
        return beers
    }

    fun getBeers(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getBeer().map { it.toBeer() }
            beers.postValue(response as ArrayList<Beer>?)
        }
    }

}
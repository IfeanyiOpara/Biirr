package ifeanyi.opara.biirr.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ifeanyi.opara.biirr.data.toBeerDetail
import ifeanyi.opara.biirr.mainRepository.BeerRepository
import ifeanyi.opara.biirr.models.BeerDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerDetailsViewModel @Inject constructor(
    private var repository: BeerRepository
) : ViewModel() {

    private var beerDetail : MutableLiveData<BeerDetail> = MutableLiveData()

    init {
        beerDetailObserver()
    }

    fun beerDetailObserver() : LiveData<BeerDetail> {
        return beerDetail
    }

    fun getBeerDetail(id : Int){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getBeerDetail(id).toBeerDetail()
            beerDetail.postValue(response)
        }
    }

}
package com.kdroid.hypdsample.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kdroid.hypdsample.ui.home.homerepo.HomeRepo


class HomeViewModel : ViewModel() {

    private var repository: HomeRepo? = HomeRepo()

    // this method will be call to mainactivity
    fun getHeaderData(): MutableLiveData<ArrayList<String>>? {
        // we just call reopository method here
        return repository?.getHeaderData()
    }
    fun getCategory(): MutableLiveData<ArrayList<String>>? {
        // we just call reopository method here
        return repository?.getCategory()
    }
    fun getBannerImage(): MutableLiveData<ArrayList<String>>? {
        // we just call reopository method here
        return repository?.getBannerImage()
    }

}
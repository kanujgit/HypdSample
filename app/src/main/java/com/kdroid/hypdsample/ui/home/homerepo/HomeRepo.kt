package com.kdroid.hypdsample.ui.home.homerepo

import androidx.lifecycle.MutableLiveData


class HomeRepo {

    private var mutableLiveData: MutableLiveData<ArrayList<String>> = MutableLiveData()
    private var mutableLiveDataForCategory: MutableLiveData<ArrayList<String>> = MutableLiveData()
    private var mutableLiveDataForBannerImages: MutableLiveData<ArrayList<String>> = MutableLiveData()
    private var headerListItem: ArrayList<String> = ArrayList()
    private var categoryListItem: ArrayList<String> = ArrayList()
    private var bannerImages: ArrayList<String> = ArrayList()

    fun getHeaderData() = MutableLiveData<ArrayList<String>>().also {
        headerListItem.add("Shopping")
        headerListItem.add("Task")
        headerListItem.add("Clothes")
        headerListItem.add("Man's")
        headerListItem.add("Woman's")
        mutableLiveData.postValue(headerListItem)
        return mutableLiveData
    }

    fun getCategory() = MutableLiveData<ArrayList<String>>().also {
        categoryListItem.add("Task1")
        categoryListItem.add("Task2")
        categoryListItem.add("Task3")
        categoryListItem.add("Task4")
        categoryListItem.add("Task5")
        categoryListItem.add("Task6")

        mutableLiveDataForCategory.postValue(categoryListItem)
        return mutableLiveDataForCategory
    }
    fun getBannerImage() = MutableLiveData<ArrayList<String>>().also {
        bannerImages.add("https://i.pinimg.com/originals/65/67/6b/65676bd4409ccc6ce96c7a1b3ce54fb7.jpg")
        bannerImages.add("https://picsum.photos/id/0/367/267")
        bannerImages.add("https://picsum.photos/id/1008/367/267")
        bannerImages.add("https://picsum.photos/id/1025/367/267")
        bannerImages.add("https://picsum.photos/536/354")
        bannerImages.add("https://i.picsum.photos/id/1024/1920/1280.jpg?hmac=-PIpG7j_fRwN8Qtfnsc3M8-kC3yb0XYOBfVzlPSuVII")
        mutableLiveDataForBannerImages.postValue(bannerImages)
        return mutableLiveDataForBannerImages
    }
}
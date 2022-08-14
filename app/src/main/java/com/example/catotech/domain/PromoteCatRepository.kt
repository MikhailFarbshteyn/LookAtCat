package com.example.catotech.domain

import androidx.lifecycle.MutableLiveData
import com.example.catotech.data.Cat

interface PromoteCatRepository {

    fun getCatList(): MutableLiveData<List<Cat>>

}
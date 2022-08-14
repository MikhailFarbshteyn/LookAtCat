package com.example.catotech.domain

import androidx.lifecycle.MutableLiveData
import com.example.catotech.data.Cat

class GetPromoteCatListUseCase(val promoteCatRepository: PromoteCatRepository) {

    fun getPromoteCats(): MutableLiveData <List<Cat>>{
        return promoteCatRepository.getCatList()
    }

}
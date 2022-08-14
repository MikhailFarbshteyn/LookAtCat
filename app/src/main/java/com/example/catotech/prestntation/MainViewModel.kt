package com.example.catotech.prestntation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.catotech.data.Cat
import com.example.catotech.data.PromoteCatRepositoryImpl
import com.example.catotech.domain.GetPromoteCatListUseCase

class MainViewModel(): ViewModel() {
    private val repositoryImpl = PromoteCatRepositoryImpl

   // val getPromoteCatListUseCase = GetPromoteCatListUseCase(repositoryImpl)
    val catList = repositoryImpl.getCatList()

    fun changeLikeState(cat: Cat){
        repositoryImpl.changeLikeState(cat)
    }

}
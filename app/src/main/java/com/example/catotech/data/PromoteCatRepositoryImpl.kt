package com.example.catotech.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.catotech.domain.PromoteCatRepository

object PromoteCatRepositoryImpl: PromoteCatRepository {

    val lst = mutableListOf<Cat>()
    var lstLD = MutableLiveData<List<Cat>>()

    init {
        lst.add(Cat(1,"https://i08.fotocdn.net/s120/b4a0febe1043eccb/public_pin_l/2742790978.jpg", "Барсик", 172, false))
        lst.add(Cat(2,"https://koshek.ru/assets/components/gallery/connector.php?action=web/phpthumb&ctx=web&w=1600&h=800&zc=0&far=&q=90&src=%2Fassets%2Fgallery%2F8%2F1775.jpg","Васька", 850, true))
        lst.add(Cat(3,"https://animeshka.org/uploads/posts/2022-01/1641899158_54-animeshka-org-p-scottish-chinchilla-cat-koshki-foto-56.jpg", "Бэгги", 233, false))
        lst.add(Cat(4,"https://vplate.ru/images/article/orig/2019/04/osobennosti-belyh-vislouhih-shotlandskih-koshek.jpg", "Лула",11, true))

        lstLD.value = lst
    }

    fun getCat(cat: Cat) : Cat{
        return lst.find { it.id == cat.id }?:throw RuntimeException("{id} not found in list")
    }

    fun changeLikeState(cat: Cat){
        cat.liked = !cat.liked
        cat.likes = if (cat.liked) cat.likes + 1 else cat.likes - 1
        updateList()
    }

    fun updateList(){
        lstLD.value = lst
    }

    override fun getCatList(): MutableLiveData<List<Cat>> {
        return lstLD
    }
}
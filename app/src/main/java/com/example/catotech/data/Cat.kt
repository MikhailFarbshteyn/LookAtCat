package com.example.catotech.data

data class Cat(val id: Int, val img: String, val name: String, var likes: Int, var liked:Boolean = false) {
}
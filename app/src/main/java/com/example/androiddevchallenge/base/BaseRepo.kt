package com.example.androiddevchallenge.base

import kotlinx.coroutines.Dispatchers

open class BaseRepo {
    var retrofit = RetrofitInstance.createInstance()
    private val ioDispatcher = Dispatchers.IO
}
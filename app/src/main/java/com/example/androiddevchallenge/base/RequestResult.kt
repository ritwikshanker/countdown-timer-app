/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.base

sealed class RequestResult<out R> {

    data class Success<out T>(val data: T) : RequestResult<T>()
    data class Error<out T>(val throwable: Throwable) : RequestResult<T>()

    //    data class Loading<out T>(val any: Any) : Result<T>()
    data class Loading<out T>(val any: T) : RequestResult<T>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$throwable]"
            is Loading -> "Loading[any=$any]"
        }
    }
}

val RequestResult<*>.succeeded
    get() = this is RequestResult.Success && data != null

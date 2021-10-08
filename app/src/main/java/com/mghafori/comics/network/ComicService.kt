package com.mghafori.comics.network

import com.mghafori.comics.network.model.ComicDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ComicService {

    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET("/{comic_id}/info.0.json")
    suspend fun getById(@Path("comic_id") comic_id: Int): ComicDto

    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET("/info.0.json")
    suspend fun getCurrent(): ComicDto

}
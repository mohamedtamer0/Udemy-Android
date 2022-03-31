package com.example.myretrofitapp.networking

import com.example.myretrofitapp.model.MovieResponse
import com.example.myretrofitapp.model.RateBody
import com.example.myretrofitapp.model.RateResponse
import retrofit2.Response
import retrofit2.http.*

interface MovieService {
    @GET("/movie/{movie_id}")
    suspend fun getMovieInfo(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey:String,
        @Query("language") language:String?,
        @Query("append_to_response") appendToResponse:String?,
    ):Response<MovieResponse>


    @FormUrlEncoded
    @POST("/movie/{movie_id}/rating")
    suspend fun rateMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey:String,
        @Query("guest_session_id") guestSessionId:String?,
        @Query("session_id") sessionId:String?,
        @Body body: RateBody,
    ):Response<RateResponse>

}
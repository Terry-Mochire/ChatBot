package com.example.chatbot.network;

import com.example.chatbot.models.Message;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {

    @GET
    Call<Message> getMessage(@Url String url);
}

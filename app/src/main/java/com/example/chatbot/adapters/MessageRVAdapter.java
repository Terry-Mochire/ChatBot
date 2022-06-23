package com.example.chatbot.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatbot.R;
import com.example.chatbot.models.Chats;
import com.example.chatbot.models.Message;

import java.util.ArrayList;

public class MessageRVAdapter extends RecyclerView.Adapter {

    private ArrayList<Chats> messagesArrayList;
    private Context context;


    public MessageRVAdapter(ArrayList<Chats> messagesArrayList, Context context) {
        this.messagesArrayList = messagesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:
                // below line we are inflating user message layout.
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg, parent, false);
                return new UserViewHolder(view);
            case 1:
                // below line we are inflating bot message layout.
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg, parent, false);
                return new BotViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // this method is use to set data to our layout file.
        Chats modal = messagesArrayList.get(position);
        switch (modal.getSender()) {
            case "user":
                // below line is to set the text to our text view of user layout
                ((UserViewHolder) holder).userTV.setText(modal.getMessage());
                break;
            case "bot":
                // below line is to set the text to our text view of bot layout
                ((BotViewHolder) holder).botTV.setText(modal.getMessage());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return messagesArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        // below line of code is to set position.
        switch (messagesArrayList.get(position).getSender()) {
            case "user":
                return 0;
            case "bot":
                return 1;
            default:
                return -1;
        }
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userTV;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userTV = itemView.findViewById(R.id.idTVUser);
        }
    }

    public static class BotViewHolder extends RecyclerView.ViewHolder {
        TextView botTV;

        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            botTV = itemView.findViewById(R.id.idTVBot);
        }
    }
}

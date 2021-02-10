package com.example.recyclerview1;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class MyrecyclerViewAdapter extends RecyclerView.Adapter<MyrecyclerViewAdapter.Myholder> {

    private List<Message> messageList;
    private Context context;
    private Callback callback;

    interface Callback {
        void onItemLongClicked(Message message);
    }


    public MyrecyclerViewAdapter(Context context, MyrecyclerViewAdapter.Callback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void setItems(List<Message> messageList) {
        this.messageList = messageList;
        notifyDataSetChanged();
    }

    public void removeItem(Message message) {
        messageList.remove(message);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        Myholder myholder = new Myholder(view, callback);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        Message message = messageList.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }


    static class Myholder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView messageTextView;
        private Callback callback;

        public Myholder(@NonNull View itemView, Callback callback) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.idemptyTitileView);
            messageTextView = itemView.findViewById(R.id.idEmptyMessageView);
            this.callback = callback;
        }

        public void bind(final Message message) {
            titleTextView.setText(message.getTitle());
            titleTextView.setText(message.getMessage());

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    callback.onItemLongClicked(message);
                    return false;
                }
            });
        }
    }
}

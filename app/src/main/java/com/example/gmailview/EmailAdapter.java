package com.example.gmailview;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class EmailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Email> emails;
    Consumer<Integer> onHighlightButtonClick;

    class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView emailName;
        TextView emailPreviewText;
        TextView emailDate;
        TextView emailIcon;
        Button starButton;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            emailName = itemView.findViewById(R.id.email_name);
            emailPreviewText = itemView.findViewById(R.id.email_preview_text);
            emailDate = itemView.findViewById(R.id.email_date);
            emailIcon = itemView.findViewById(R.id.icon_text_view);
            starButton = itemView.findViewById(R.id.hightlight_btn);
            starButton.setOnClickListener(view -> {
                int pos = getAdapterPosition();
                onHighlightButtonClick.accept(pos);
            });
        }
    }

    public EmailAdapter(List<Email> emails) {
        this.emails = emails;
    }

    public void setOnHighlightButtonClick(Consumer<Integer> onHighlightButtonClick) {
        this.onHighlightButtonClick = onHighlightButtonClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_item_layout, null);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Email email = emails.get(position);
        String iconText = email.getName().substring(0,1);
        ((EmailViewHolder) holder).emailIcon.setText(iconText);
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        ((EmailViewHolder)holder).emailIcon.setBackgroundTintList(ColorStateList.valueOf(color));
        ((EmailViewHolder)holder).emailIcon.setTextColor(getInverseColor(color));
        ((EmailViewHolder) holder).emailDate.setText(DateFormat.format("hh:mm aa", email.getDate()));
        ((EmailViewHolder) holder).emailName.setText(email.getName());
        ((EmailViewHolder) holder).emailPreviewText.setText(email.getPreviewText());
        ((EmailViewHolder) holder).starButton.setCompoundDrawablesWithIntrinsicBounds(email.isHighlighted() ? R.drawable.drawable_activated_star : R.drawable.drawable_star, 0, 0, 0);
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }

    private int getInverseColor(int color){
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = Color.alpha(color);
        return Color.argb(alpha, 255-red, 255-green, 255-blue);
    }
}

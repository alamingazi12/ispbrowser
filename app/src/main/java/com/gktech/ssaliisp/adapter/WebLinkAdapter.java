package com.gktech.ssaliisp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gktech.ssaliisp.R;
import com.gktech.ssaliisp.model.Website;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WebLinkAdapter extends RecyclerView.Adapter<WebLinkAdapter.WebViewHolder> {

    ArrayList<Website> weblist;

    public WebLinkAdapter(ArrayList<Website> weblist, Context context) {
        this.weblist = weblist;
        this.context = context;
    }

    Context context;
    @NonNull
    @Override
    public WebViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.web_item,parent,false);
        return new WebViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WebViewHolder holder, int position) {

          Website website=weblist.get(position);
          holder.text_siteName.setText(website.getName());
          holder.image_link.setImageResource(website.getImageid());
    }

    @Override
    public int getItemCount() {
      return   weblist.size();
    }

    public class WebViewHolder extends RecyclerView.ViewHolder {

        ImageView image_link;
        TextView text_siteName;
        public WebViewHolder(@NonNull View itemView) {
            super(itemView);
            image_link=itemView.findViewById(R.id.link_image);
            text_siteName=itemView.findViewById(R.id.link_item_text);
        }
    }
}

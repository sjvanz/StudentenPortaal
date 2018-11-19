package com.example.user.studentportaal;

import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

public class PortalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    final private PortalAdapter.PortalClickListener mPortalClickListener;
    public TextView title;
    public View view;

    public PortalViewHolder(View itemView, PortalAdapter.PortalClickListener mPortalClickListener) {
        super(itemView);
        title =  itemView.findViewById(R.id.portalNameLabel);
        view = itemView;
        itemView.setOnClickListener(this);
        this.mPortalClickListener = mPortalClickListener;
    }

    @Override
    public void onClick(View view) {
        int clickedPosition = getAdapterPosition();
        mPortalClickListener.portalOnClick(clickedPosition);
    }
}


package com.example.user.studentportaal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalViewHolder> {
    final private PortalClickListener mPortalClickListener;
    public interface PortalClickListener {
        void portalOnClick (int i);
    }

    private Context context;

    public List<Portal> listPortal;

    public PortalAdapter(List<Portal> listPortal, PortalClickListener mPortalClickListener) {
        this.listPortal = listPortal;
        this.mPortalClickListener = mPortalClickListener;
    }

    @Override
    public PortalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.portal_viewholder, parent, false);
        return new PortalViewHolder(view, mPortalClickListener);
    }

    @Override
    public void onBindViewHolder(final PortalViewHolder holder, final int position) {
        Portal portal = listPortal.get(position);
        holder.title.setText(portal.getTitle());
    }

    @Override
    public int getItemCount() {
        return listPortal.size();
    }
}

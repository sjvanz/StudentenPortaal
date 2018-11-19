package com.example.user.studentportaal;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PortalAdapter.PortalClickListener {
    private List<Portal> mPortalObjects;
    private PortalAdapter mAdapter;

    private RecyclerView mPortalRecyclerView;

    public static final int REQUESTCODE = 1234;
    public static final int PORTAL_REQUESTCODE = 1235;
    public static final String ADD_PORTAL = "PORTAAL_TOEVOEGEN";
    public static final String VIEW_PORTAL = "PORTAAL_BEKIJKEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPortalObjects = new ArrayList<>();
        mPortalObjects.add(new Portal("https://www.android-development.app/#!/home", "Android Development"));
        mPortalObjects.add(new Portal("https://vlo.informatica.hva.nl/", "VLO"));
        mAdapter = new PortalAdapter(mPortalObjects, this);

        mPortalRecyclerView = findViewById(R.id.portalList);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);

        mPortalRecyclerView.setLayoutManager(mLayoutManager);
        mPortalRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.addResource);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);

                startActivityForResult(intent, REQUESTCODE);
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            Portal portal = data.getParcelableExtra(MainActivity.ADD_PORTAL);
            // New timestamp: timestamp of update
            mPortalObjects.add(portal);
            updateUI();
        }
    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new PortalAdapter(mPortalObjects, this);
            mPortalRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void portalOnClick(int i) {
        Intent intent = new Intent(MainActivity.this, PortalActivity.class);
        intent.putExtra(VIEW_PORTAL, mPortalObjects.get(i));
        startActivityForResult(intent, PORTAL_REQUESTCODE);
    }
}
package com.example.aaronpries.herds_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.pkmmte.view.CircularImageView;
import com.squareup.picasso.Picasso;

import static android.R.attr.fragment;

public class GroupsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseDatabase mRef;
    //private static final String TAG = "MainActivity";
    private StorageReference mStorageRef;
    private RecyclerView mBlogList;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    final FragmentManager fm = getSupportFragmentManager();
    final FragmentTransaction ft = fm.beginTransaction();


    NavigationView navigationView = null;
    Toolbar toolbar = null;


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<ModelClass, BlogViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelClass, BlogViewHolder>(
                        ModelClass.class,
                        R.layout.groups_layout,
                        BlogViewHolder.class,
                        myRef
                ) {


                    @Override
                    protected void populateViewHolder(BlogViewHolder viewHolder, ModelClass model, int position) {
                        viewHolder.setName(model.getName());
                        viewHolder.setBio(model.getBio());
                        viewHolder.setImage(getApplicationContext(), model.getImage());

                    }
                };
        mBlogList.setAdapter(firebaseRecyclerAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



//CircularView
        CircularImageView circularImageView = (CircularImageView)findViewById(R.id.imageViewy);
//        circularImageView.setBorderColor(getResources().getColor(R.color.Gray_Dolphin));
//        circularImageView.setBorderWidth(10);
//        circularImageView.setSelectorColor(getResources().getColor(R.color.transparent_black_percent_50));
//        circularImageView.setSelectorStrokeColor(getResources().getColor(R.color.BlueDark));
//        circularImageView.setSelectorStrokeWidth(10);
//        circularImageView.addShadow();



        //RecyclerView
        mBlogList = (RecyclerView) findViewById(R.id.blog_list);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));

        //Send a Query to the DB
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Groups");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                ///////PINK BUTTON//////////
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {

//            Intent Events = new Intent(MainActivity.this, MainActivity.class);
//            startActivity(Events);

        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        //TEST

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //View Holder For Recycler View
    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
//                            Uri.parse("http://www.androidsquad.space/"));
//                    Intent browserChooserIntent = Intent.createChooser(browserIntent, "Choose browser of your choice");
//                    v.getContext().startActivity(browserChooserIntent);
                }
            });}
        public void setName(String name){
            TextView post_name = (TextView)mView.findViewById(R.id.titleText);
            post_name.setText(name);
        }
        public void setImage(Context ctx , String image){
//            ImageView post_image = (ImageView)mView.findViewById(R.id.imageViewy);
            CircularImageView post_image = (CircularImageView)mView.findViewById(R.id.imageViewy);
            // We Need TO pass Context
            Picasso.with(ctx).load(image).into(post_image);
        }
        public void setBio(String bio){
            TextView post_bio = (TextView)mView.findViewById(R.id.bioText);
            post_bio.setText(bio);
        }
    }
}


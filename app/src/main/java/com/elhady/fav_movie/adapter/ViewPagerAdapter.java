package com.elhady.fav_movie.adapter;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.elhady.fav_movie.R;
import com.elhady.fav_movie.Utils.Constants;
import com.elhady.fav_movie.databinding.CuttentlyShowItemBinding;
import com.elhady.fav_movie.model.Movie;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {
    private static final String TAG = "ViewPagerAdapter";
    private ArrayList<Movie> movieList;
    private Context context;
    private CuttentlyShowItemBinding binding;

    public ViewPagerAdapter(Context context, ArrayList<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public void setMovieListResults(ArrayList<Movie> movieList){
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        binding = CuttentlyShowItemBinding.inflate(inflater,parent,false);
        return new ViewPagerViewHolder(binding);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: " + movieList.get(position).getTitle() );
        holder.binding.currentlyShowingMovieName.setText(movieList.get(position).getTitle());
        Glide.with(context).load(Constants.ImageBaseURL+ movieList.get(position).getBackdrop_path())
                .into(holder.binding.currentlyShowingMovieImage);

//        holder.binding.currentlyShowingLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                HomeFragmentDirections.ActionNavigationHomeToMovieDetails action = HomeFragmentDirections
//                        .actionNavigationHomeToMovieDetails(movieList.get(position).getId());
//                Navigation.findNavController(view).navigate(action);
//            }
//        });

        holder.binding.currentlyShowingMovieImage.setClipToOutline(true);
        holder.binding.currentlyShowingLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    class ViewPagerViewHolder extends RecyclerView.ViewHolder{

        private CuttentlyShowItemBinding binding;
        public ViewPagerViewHolder(CuttentlyShowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
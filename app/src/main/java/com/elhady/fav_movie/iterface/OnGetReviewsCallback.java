package com.elhady.fav_movie.iterface;


import com.elhady.fav_movie.model.Review;

import java.util.List;

public interface OnGetReviewsCallback {
    void onSuccess(List<Review> reviews);

    void onError();
}
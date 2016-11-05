package com.example.tu.homeworkss15_daily_quote.networks;

import com.example.tu.homeworkss15_daily_quote.models.Quote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hau on 04/11/2016.
 */
public interface QuoteService {
    @GET("wp-json/posts")
    Call<List<Quote>> listQuote(@Query("filter[orderby]") String order, @Query("filter[posts_per_page]") int numberPost);
}

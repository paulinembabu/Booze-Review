package com.example.pauline.booze;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class BoozeListAdapter extends RecyclerView.Adapter<BoozeListAdapter.BoozeViewHolder> {
    private ArrayList<Beer> mBeer= new ArrayList<>();
    private Context mContext;

    public BoozeListAdapter(Context context, ArrayList<Beer> beer) {
        mContext = context;
        mBeer=beer;
    }

    @Override
    public BoozeListAdapter.BoozeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_booze_list, parent, false);
        BoozeViewHolder viewHolder = new BoozeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BoozeListAdapter.BoozeViewHolder holder, int position) {
        holder.bindBooze(mBeer.get(position));
    }

    @Override
    public int getItemCount() {

        return mBeer.size();
    }

    public class BoozeViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener  {


        int image=R.drawable.beer1;
        int image1 = R.drawable.beer1;
        int image2 =R.drawable.beer2;
        int image3 = R.drawable.beer3;
        int image4 =R.drawable.beer4;
        int image5 = R.drawable.beer5;
        int image6 = R.drawable.beer6;
        int image7 = R.drawable.beer7;
        int image8 = R.drawable.beer8;


        private int [] beerImages =new  int [] {image,image1,image2,image3,image4,image5,image6,image7,image8};

        @Bind(R.id.beerImageView) ImageView mBeerImageView;
       // @Bind(R.id.description) TextView mDescription;
        @Bind(R.id.beerNameTextView) TextView mNameTextView;
       // @Bind(R.id.categoryTextView) TextView mNameDisplay;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;




        private Context mContext;


        public BoozeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindBooze(Beer beer) {
            mNameTextView.setText(beer.getName());
            //mNameDisplay.setText(beer1.getNameDisplay());
           // mDescription.setText(beer1.getDescription());
            mBeerImageView.setImageResource(beer.getImage());
            mRatingTextView.setText("Rating:4.5 " );


        }
        @Override
        public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, boozeDetails.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("beer1",Parcels.wrap(mBeer));
            mContext.startActivity(intent);
        }
    }
}
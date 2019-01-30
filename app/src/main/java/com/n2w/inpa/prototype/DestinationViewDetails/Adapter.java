package com.n2w.inpa.prototype.DestinationViewDetails;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.n2w.inpa.prototype.CardItem;
import com.n2w.inpa.prototype.CardPagerAdapter;
import com.n2w.inpa.prototype.R;
import com.n2w.inpa.prototype.SelectDate;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflate;
    private AdapterView.OnItemClickListener mClickListener;
    private Activity activity;

    private ArrayList<DestinationModel> mDestModel;

    public Adapter(Context cont, Activity activity, ArrayList<DestinationModel> data) {

        Log.d("Adapter","Calling adapter...");

        this.mInflate = LayoutInflater.from(cont);
        this.mDestModel = data;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;

        switch (i)
        {
            case DestinationModel.HEADER:
                Log.d("ViewHolder","Header selected");
                view = mInflate.inflate(R.layout.destination_details_firstheader, viewGroup, false);
                return new DestHeaderViewHolder(view);
            case DestinationModel.DESCRIPTION:
                Log.d("ViewHolder","Desc selected");
                view = mInflate.inflate(R.layout.destination_details_description, viewGroup, false);
                return new DestDescriptionViewHolder(view);
            case DestinationModel.LINE:
                Log.d("ViewHolder","Line selected");
                view = mInflate.inflate(R.layout.destination_details_separatorline, viewGroup, false);
                return new DestLineViewHolder(view);
            case DestinationModel.FEATURES:
                Log.d("ViewHolder","Features selected");
                view = mInflate.inflate(R.layout.destination_details_features, viewGroup, false);
                return new DestFeaturesViewHolder(view);
            case DestinationModel.POI_VIEWCARD:
                Log.d("ViewHolder","Features selected");
                view = mInflate.inflate(R.layout.destination_details_poiimages, viewGroup, false);
                return new DestPOIViewHolder(view);
            case DestinationModel.POINT_DESCRIPTION:
                Log.d("ViewHolder","Point Desc selected");
                view =  mInflate.inflate(R.layout.destination_details_with_icons, viewGroup, false);
                return new DestPointFeaturesViewHolder(view);
            case DestinationModel.RULES:
                Log.d("ViewHolder","Rules Desc selected");
                view =  mInflate.inflate(R.layout.destination_details_with_icons, viewGroup, false);
                return new DestRulesViewHolder(view);
            case DestinationModel.LOCATION:
                view = mInflate.inflate(R.layout.destination_details_maps, viewGroup, false);
                return new DestLocationViewHolder(view);
            case DestinationModel.REVIEWS:
                view = mInflate.inflate(R.layout.destination_details_ratings, viewGroup, false);
                return new DestRatingsViewHolder(view);
            case DestinationModel.BOOKBUTTON:
                view = mInflate.inflate(R.layout.destination_details_bookbutton, viewGroup, false);
                return new DestBookBtnViewHolder(view);
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {

        Log.d("ItemViewType","Checking view type for no " + mDestModel.get(position).type);

        switch (mDestModel.get(position).type)
        {
            case 0:
                return DestinationModel.HEADER;
            case 1:
                return DestinationModel.DESCRIPTION;
            case 2:
                return DestinationModel.LINE;
            case 3:
                return DestinationModel.FEATURES;
            case 4:
                return DestinationModel.POI_VIEWCARD;
            case 5:
                return DestinationModel.POINT_DESCRIPTION;
            case 6:
                return DestinationModel.RULES;
            case 7:
                return DestinationModel.LOCATION;
            case 8:
                return DestinationModel.REVIEWS;
            case 9:
                return DestinationModel.NOTES;
            case 10:
                return DestinationModel.BOOKBUTTON;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder destViewHolder, int i) {

        DestinationModel destModel = mDestModel.get(i);
        if(destModel != null)
        {
            switch (destModel.type)
            {
                case DestinationModel.HEADER:
                    ((DestHeaderViewHolder) destViewHolder).textType.setText(destModel.desc);

                    RequestOptions imgReqOpt = new RequestOptions();
                    imgReqOpt.override(800,600);
                    imgReqOpt.fitCenter();

                    Glide.with(((DestHeaderViewHolder) destViewHolder).itemView)
                            .load(destModel.imageURLString)
                            .apply(imgReqOpt)
                            .into(((DestHeaderViewHolder) destViewHolder).headerImgView);


                    break;

                case DestinationModel.DESCRIPTION:
                    ((DestDescriptionViewHolder) destViewHolder).txtDetailsDescription.setText(destModel.desc);
                    break;

                case DestinationModel.LINE:

                    break;

                case DestinationModel.FEATURES:

                    FeaturesAdapter featAdapter = new FeaturesAdapter(mInflate.getContext(), destModel.mFeatModel);
                    ((DestFeaturesViewHolder) destViewHolder).recViewFeatures.setAdapter(featAdapter);
                    ((DestFeaturesViewHolder) destViewHolder).recViewFeatures.setLayoutManager(new LinearLayoutManager(mInflate.getContext()));
                    break;

                case DestinationModel.POI_VIEWCARD:

                    //((DestPOIViewHolder)destViewHolder).poiCardViewPager.
                    ((DestPOIViewHolder)destViewHolder).poiCardViewPager.setAdapter(destModel.cardPagerAdapter);
                    ((DestPOIViewHolder)destViewHolder).poiCardViewPager.setOffscreenPageLimit(3);

                    break;

                case DestinationModel.POINT_DESCRIPTION:

                    IconCellsAdapter icAdapter = new IconCellsAdapter(mInflate.getContext(), destModel.mIconCellsModel);
                    ((DestPointFeaturesViewHolder) destViewHolder).rvDestDetailsIcons.setAdapter(icAdapter);
                    ((DestPointFeaturesViewHolder) destViewHolder).rvDestDetailsIcons.setLayoutManager(new LinearLayoutManager(mInflate.getContext()));

                    break;
                case DestinationModel.RULES:

                    IconIICellsAdapter icIIAdapter = new IconIICellsAdapter(mInflate.getContext(), destModel.mIconIICellsModel);
                    ((DestRulesViewHolder) destViewHolder).rvDestDetailsIcons.setAdapter(icIIAdapter);
                    ((DestRulesViewHolder) destViewHolder).rvDestDetailsIcons.setLayoutManager(new LinearLayoutManager(mInflate.getContext()));

                    break;
                case DestinationModel.LOCATION:

                    break;
                case DestinationModel.REVIEWS:

                    break;
                case DestinationModel.BOOKBUTTON:

                    ((DestBookBtnViewHolder) destViewHolder).btnDestDetailsBook.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Intent getIntent = new Intent(activity, SelectDate.class);
                            activity.startActivity(getIntent);
                        }
                    });

                    break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return mDestModel.size();
    }

    public static class DestHeaderViewHolder extends RecyclerView.ViewHolder{

        TextView textType;
        ImageView headerImgView;

        public DestHeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            textType = itemView.findViewById(R.id.txtHeaderTitle);
            headerImgView = itemView.findViewById(R.id.imgHeaderImage);

        }
    }

    public static class DestDescriptionViewHolder extends RecyclerView.ViewHolder {

        TextView txtDetailsDescription;

        public DestDescriptionViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDetailsDescription = itemView.findViewById(R.id.txtDetailsDescription);
        }
    }

    public static class DestLineViewHolder extends RecyclerView.ViewHolder {

        public DestLineViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class DestFeaturesViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recViewFeatures;

        public DestFeaturesViewHolder(@NonNull View itemView) {
            super(itemView);

            recViewFeatures = itemView.findViewById(R.id.recViewFeatures);

        }
    }

    public static class DestPOIViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llFirstBtn;
        LinearLayout llSecondBtn;
        TextView txtFirstBtnName;
        TextView txtSecondBtnName;
        View viewFirstBtnLine;
        View viewSecondBtnLine;
        ViewPager poiCardViewPager;

        public DestPOIViewHolder(@NonNull View itemView) {
            super(itemView);

            llFirstBtn = itemView.findViewById(R.id.llFirstBtn);
            llSecondBtn = itemView.findViewById(R.id.llSecondBtn);
            txtFirstBtnName = itemView.findViewById(R.id.txtFirstBtnName);
            txtSecondBtnName = itemView.findViewById(R.id.txtSecondBtnName);
            viewFirstBtnLine = itemView.findViewById(R.id.viewFirstBtnLine);
            viewSecondBtnLine = itemView.findViewById(R.id.viewSecondBtnLine);
            poiCardViewPager = itemView.findViewById(R.id.poiCardViewPager);

        }
    }

    public static class DestPointFeaturesViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rvDestDetailsIcons;

        public DestPointFeaturesViewHolder(@NonNull View itemView) {
            super(itemView);

            rvDestDetailsIcons = itemView.findViewById(R.id.rvDestDetailsIcons);

        }
    }

    public static class DestRulesViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rvDestDetailsIcons;

        public DestRulesViewHolder(@NonNull View itemView) {
            super(itemView);

            rvDestDetailsIcons = itemView.findViewById(R.id.rvDestDetailsIcons);

        }
    }

    public static class DestLocationViewHolder extends RecyclerView.ViewHolder {

        //RecyclerView rvDestDetailsIcons;

        public DestLocationViewHolder(@NonNull View itemView) {
            super(itemView);

            //rvDestDetailsIcons = itemView.findViewById(R.id.rvDestDetailsIcons);

        }
    }

    public static class DestRatingsViewHolder extends RecyclerView.ViewHolder {

        //RecyclerView rvDestDetailsIcons;

        public DestRatingsViewHolder(@NonNull View itemView) {
            super(itemView);

            //rvDestDetailsIcons = itemView.findViewById(R.id.rvDestDetailsIcons);

        }
    }

    public static class DestBookBtnViewHolder extends RecyclerView.ViewHolder {

        Button btnDestDetailsBook;

        public DestBookBtnViewHolder(@NonNull View itemView) {
            super(itemView);

            btnDestDetailsBook = itemView.findViewById(R.id.btnDestDetailsBook);

        }
    }
}

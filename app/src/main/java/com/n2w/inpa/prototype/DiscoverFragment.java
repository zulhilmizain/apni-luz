package com.n2w.inpa.prototype;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DiscoverFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiscoverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscoverFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ViewPager mAdvCardViewPager;
    private ViewPager mPackageCardViewPager;
    private ViewPager mAdsCardViewPager;

    private CardPagerAdapter mCardPagerAdapter;
    private CardPagerAdapter mPackageCardPagerAdapter;
    private CardPagerAdapter mAdsCardPagerAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscoverFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscoverFragment newInstance(String param1, String param2) {
        DiscoverFragment fragment = new DiscoverFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        populateAdventures(view);
        populatePackages(view);
        populateAds(view);

        return view;
    }

    public void populateAdventures(View view)
    {
        mAdvCardViewPager = view.findViewById(R.id.advCardViewPager);

        mCardPagerAdapter = new CardPagerAdapter(getActivity());
        mCardPagerAdapter.addCardItem(new CardItem("Endau Rompin Peta"));
        mCardPagerAdapter.addCardItem(new CardItem("Endau Rompin Selai"));
        mCardPagerAdapter.addCardItem(new CardItem("Gunung Ledang"));

        mAdvCardViewPager.setAdapter(mCardPagerAdapter);
        mAdvCardViewPager.setOffscreenPageLimit(3);
        mAdvCardViewPager.setOnTouchListener(new View.OnTouchListener() {

            private boolean moved;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    moved = false;
                    Log.d("test","down!");
                    return true;
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    moved = true;
                    Log.d("test","moved!");
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (!moved) {
                        Log.d("test", String.valueOf(mAdvCardViewPager.getCurrentItem()));
                        getActivity().startActivity(new Intent(getActivity(),DesinationDetails.class));
                    }
                }

                return false;
            }
        });


    }

    public void populatePackages(View view)
    {
        mPackageCardViewPager = view.findViewById(R.id.packageCardViewPager);

        mPackageCardPagerAdapter = new CardPagerAdapter(getActivity());
        mPackageCardPagerAdapter.addCardItem(new CardItem("Trekking & Hiking"));
        mPackageCardPagerAdapter.addCardItem(new CardItem("Swimming"));

        mPackageCardViewPager.setAdapter(mPackageCardPagerAdapter);
        mPackageCardViewPager.setOffscreenPageLimit(3);
    }

    public void populateAds(View view)
    {
        mAdsCardViewPager = view.findViewById(R.id.adsCardViewPager);

        mAdsCardPagerAdapter = new CardPagerAdapter(getActivity());
        mAdsCardPagerAdapter.addCardItem(new CardItem("ADS1"));
        mAdsCardPagerAdapter.addCardItem(new CardItem("ADS2"));

        mAdsCardViewPager.setAdapter(mAdsCardPagerAdapter);
        mAdsCardViewPager.setOffscreenPageLimit(3);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

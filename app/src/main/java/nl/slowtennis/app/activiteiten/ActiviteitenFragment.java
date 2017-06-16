/*
 * Copyright (C) 2014 VenomVendor <info@VenomVendor.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package nl.slowtennis.app.activiteiten;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nl.slowtennis.app.MainActivity;
import nl.slowtennis.app.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ActiviteitenFragment extends Fragment  {
    RecyclerView mRecyclerView;
    ActiviteitenListAdapter adapter;

    public ActiviteitenFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_activiteiten, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        adapter = new ActiviteitenListAdapter(MockData(), this);



        ((MainActivity) getActivity()).setActionBarTitle("Toss");
        return rootView;
    }

    @Override
    public void onViewCreated(View view , Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        mRecyclerView.setAdapter(adapter);
    }

    public void animateActivity(View banner, View date, View aanvang, int pos) {

        //one view can only hav 1 tran
        Intent i = new Intent(getActivity(), ActiviteitActivity.class);

        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                Pair.create(banner, "bannerTran")
                ,Pair.create(date, "dateTran")
                ,Pair.create(aanvang, "aanvangTran")
        );
        i.putExtra("Activiteit", MockData().get(pos));
        startActivity(i, transitionActivityOptions.toBundle());
    }


    private List<Activiteit> MockData(){
        List<Activiteit> mItems;
        mItems = new ArrayList<Activiteit>();
        mItems.add(createActiviteit("Zeilweekend", "11-11-2015", "17.00", R.drawable.zeil));
        mItems.add(createActiviteit("Clubkampioenschappen “So Good to be Bad”", "23-12-2015", "18.00", R.drawable.bannerck));
        mItems.add(createActiviteit("Boer'n Toss", "15-2-2016", "19.15", R.drawable.boer));
        return mItems;
    }

    private Activiteit createActiviteit(String title, String date, String aanvang, int banner) {
        Activiteit activiteit = new Activiteit();
        activiteit.setTitle(title);
        activiteit.setDate(date);
        activiteit.setAanvang(aanvang);
        activiteit.getBanner(banner);
        return activiteit;
    }
}

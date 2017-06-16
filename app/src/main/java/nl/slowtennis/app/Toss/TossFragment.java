package nl.slowtennis.app.Toss;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import nl.slowtennis.app.MainActivity;
import nl.slowtennis.app.R;

/**
 * Created by poliveira on 11/03/2015.
 */
public class TossFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainview = inflater.inflate(R.layout.fragment_toss, null);

        LinearLayout linearLayout=(LinearLayout) mainview.findViewById(R.id.linearLayoutCorener);
        linearLayout.setBackgroundResource(R.drawable.corners);

        LinearLayout top =(LinearLayout) mainview.findViewById(R.id.linearLayoutCorenerDark);
        top.setBackgroundResource(R.drawable.corners_dark_top);

        ((MainActivity) getActivity()).setActionBarTitle("Toss");

        return mainview;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}

package nl.slowtennis.app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * Created by poliveira on 11/03/2015.
 */
public class TrainingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainview = inflater.inflate(R.layout.fragment_training, null);

        LinearLayout linearLayout=(LinearLayout) mainview.findViewById(R.id.linearLayoutCorener);
        linearLayout.setBackgroundResource(R.drawable.corners);

        ((MainActivity) getActivity()).setActionBarTitle("Training");
        return mainview;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}

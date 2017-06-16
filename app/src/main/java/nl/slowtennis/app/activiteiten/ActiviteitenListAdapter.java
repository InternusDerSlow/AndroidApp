package nl.slowtennis.app.activiteiten;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import nl.slowtennis.app.R;

public class ActiviteitenListAdapter extends RecyclerView.Adapter<ActiviteitenListAdapter.ViewHolder> {
    List<Activiteit> activiteiten;
    private Context context;
    private int lastPosition = -1;
    ActiviteitenFragment activiteitenFragment;



    public ActiviteitenListAdapter(List<Activiteit> data, ActiviteitenFragment actFrag) {
        super();
        this.activiteiten = data;
        this.activiteitenFragment = actFrag;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_activiteiten, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int pos) {
        Activiteit activiteit = activiteiten.get(pos);

        viewHolder.banner.setImageResource(activiteit.getBanner());
        viewHolder.date.setText(activiteit.getDate());
        viewHolder.aanvang.setText(activiteit.getAanvang());
        setAnimation(viewHolder.itemView, pos);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activiteitenFragment.animateActivity(viewHolder.banner, viewHolder.date, viewHolder.aanvang, pos);
            }
        });

    }


    private void setAnimation(View viewToAnimate, int position)
        {
            context = viewToAnimate.getContext();
            // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            animation.setDuration(350);
            animation.setStartOffset(position*175);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return activiteiten.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView date, aanvang;
        public ImageView banner;

        public ViewHolder(View itemView) {
            super(itemView);
            banner = (ImageView)itemView.findViewById(R.id.imgBanner);
            date = (TextView)itemView.findViewById(R.id.txtDate);
            aanvang = (TextView)itemView.findViewById(R.id.txtAanvang);

        }
    }
}

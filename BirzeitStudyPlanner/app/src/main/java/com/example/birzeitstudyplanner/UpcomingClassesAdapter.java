package com.example.birzeitstudyplanner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class UpcomingClassesAdapter extends RecyclerView.Adapter<UpcomingClassesAdapter.ViewHolder> {

    private List<UpcomingClassModel> upcomingClasses;

    public UpcomingClassesAdapter(List<UpcomingClassModel> upcomingClassesList) {
        this.upcomingClasses = upcomingClassesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_upcoming_class, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UpcomingClassModel upcomingClass = upcomingClasses.get(position);

        // Bind data to TextViews
        holder.classNameTextView.setText(upcomingClass.getClassName());
        holder.classLocationTextView.setText(upcomingClass.getClassLocation());
        holder.timeRemainingTextView.setText(upcomingClass.getTimeRemaining());
    }
    @Override
    public int getItemCount() {
        return upcomingClasses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView classNameTextView;
        TextView classLocationTextView;
        TextView timeRemainingTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            classNameTextView = itemView.findViewById(R.id.classNameTextView);
            classLocationTextView = itemView.findViewById(R.id.classLocationTextView);
            timeRemainingTextView = itemView.findViewById(R.id.timeRemainingTextView);
        }

        public void bind(String className) {
            classNameTextView.setText(className);
        }
    }
}

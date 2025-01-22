package com.example.to_do_list;

import android.app.UiModeManager;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.motion.widget.Debug;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.color.MaterialColors;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskText.setText(task.getName());
        holder.checkbox.setChecked(task.isChecked());

        holder.deleteButton.setOnClickListener(v -> {
            taskList.remove(position);
            notifyItemRemoved(position);
        });

        holder.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setChecked(isChecked);

            if (isChecked) {
                Debug.logStack("et", ""+position, 1);
                holder.taskText.setTextColor(Color.RED);
            } else {
                holder.taskText.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), com.google.android.material.R.color.m3_dynamic_dark_default_color_secondary_text));
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView taskText;
        CheckBox checkbox;
        ImageButton deleteButton;

        public TaskViewHolder(View itemView) {
            super(itemView);
            taskText = itemView.findViewById(R.id.taskText);
            checkbox = itemView.findViewById(R.id.taskCheckbox);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}

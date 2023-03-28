package com.example.apidemo20;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apidemo20.databinding.ApiResponseLayoutBinding;

import java.util.ArrayList;

public class APIRVAdapter extends RecyclerView.Adapter<APIRVAdapter.APIHolder> {
    private ArrayList<CommentModel> modelClassArrayList;
    private MainActivity mainActivity;
    ApiResponseLayoutBinding layoutBinding;

    public APIRVAdapter(MainActivity mainActivity, ArrayList<CommentModel> modelClassList) {
        this.mainActivity = mainActivity;
        this.modelClassArrayList = modelClassList;
    }

    @NonNull
    @Override
    public APIRVAdapter.APIHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new APIHolder(ApiResponseLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull APIRVAdapter.APIHolder holder, int position) {
        layoutBinding.tvId.setText(String.valueOf(modelClassArrayList.get(position).getId()));
        layoutBinding.tvTitle.setText(modelClassArrayList.get(position).getName());
        layoutBinding.tvBody.setText(modelClassArrayList.get(position).getText());
        layoutBinding.tvEmail.setText(modelClassArrayList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

    public class APIHolder extends RecyclerView.ViewHolder {

        public APIHolder(ApiResponseLayoutBinding inflate) {
            super(inflate.getRoot());
            layoutBinding = inflate;
        }
    }
}

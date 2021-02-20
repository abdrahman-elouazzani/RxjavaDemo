package com.elouazzani.rxjavademo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.elouazzani.rxjavademo.R;
import com.elouazzani.rxjavademo.model.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

public class GitHubRepoAdapter extends RecyclerView.Adapter<GitHubRepoAdapter.ViewHolder> {
    List<GitHubRepo> gitHubRepoList=new ArrayList<>();
    Context context;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_github_repo,
                parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull GitHubRepoAdapter.ViewHolder holder, int position) {
        final GitHubRepo gitHubRepo=gitHubRepoList.get(position);
        if (gitHubRepo!=null) {
            holder.textRepoName.setText(gitHubRepo.name);
            holder.textRepoDescription.setText(gitHubRepo.description);
            holder.textLanguage.setText("Language: " + gitHubRepo.language);
            holder.textStars.setText("Stars: " + gitHubRepo.stargazersCount);
        }

    }

    @Override
    public int getItemCount() {
        return gitHubRepoList.size();
    }


    public void setGitHubRepos(@Nullable List<GitHubRepo> repos) {
        if (repos == null) {
            return;
        }
        gitHubRepoList.clear();
        gitHubRepoList.addAll(repos);
        notifyDataSetChanged();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textRepoName;
        private TextView textRepoDescription;
        private TextView textLanguage;
        private TextView textStars;

        public ViewHolder(@NonNull View view) {
            super(view);
            textRepoName = (TextView) view.findViewById(R.id.text_repo_name);
            textRepoDescription = (TextView) view.findViewById(R.id.text_repo_description);
            textLanguage = (TextView) view.findViewById(R.id.text_language);
            textStars = (TextView) view.findViewById(R.id.text_stars);

        }
    }



}

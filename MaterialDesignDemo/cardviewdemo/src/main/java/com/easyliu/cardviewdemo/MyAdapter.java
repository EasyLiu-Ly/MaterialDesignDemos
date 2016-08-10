package com.easyliu.cardviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by EasyLiu on 2016/8/9.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> mDataset;
    private IOnListItemClickListener mIOnListItemClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public View mView;
        public ViewHolder(View v) {
            super(v);
            mView=v;
            mTextView = (TextView) v.findViewById(R.id.tv_title);
        }
    }

    /**
     * 设置监听
     * @param iOnListItemClickListener
     */
    public void setOnListItemClickListener(IOnListItemClickListener iOnListItemClickListener) {
        this.mIOnListItemClickListener = iOnListItemClickListener;
    }

    /**
     * 添加数据
     * @param position
     */
    public void addData(int position,String data) {
        mDataset.add(position,data);
        notifyItemInserted(position);
    }

    /**
     * 删除数据
     * @param position
     */
    public void removeData(int position) {
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<String> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position));
        //设置监听
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIOnListItemClickListener!=null){
                    mIOnListItemClickListener.onClick(position);
                }
            }
        });
        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mIOnListItemClickListener!=null){
                    mIOnListItemClickListener.onLongClick(position);
                    return  true;
                }
                return false;
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

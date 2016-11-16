package cn.chenfuduo.basicreview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chenfuduo on 2016/11/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private OnItemClickListener onItemClickListener;
    private String[] dataSet;

    public MyAdapter(String[] dataSet) {
        this.dataSet = dataSet;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.textView.setText(dataSet[position]);
        if (onItemClickListener !=null){
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int layoutPosition = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.cardView,layoutPosition);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
    interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}

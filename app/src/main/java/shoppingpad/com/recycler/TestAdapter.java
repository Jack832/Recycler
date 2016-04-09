package shoppingpad.com.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by bridgelabz4 on 9/4/16.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.HolderView>
{
    LayoutInflater mLayoutInflater;
    Context context;
    List<TestModel> testList;
    int previousposition = 0;


    public TestAdapter(Context content,List<TestModel> list) {
        testList=list;
        this.context=content;
        mLayoutInflater=LayoutInflater.from(content);

    }

    @Override
    public HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.content_main,parent,false);
        HolderView holderView= new HolderView(view);

        return holderView;
    }

    @Override
    public void onBindViewHolder(HolderView holder, int position) {
       final TestModel testModel=testList.get(position);
        holder.imageView.setImageResource(testModel.image);

        if (position > previousposition){
            AnimationUtils.animate(holder,true);
        }else {
            AnimationUtils.animate(holder,false);
        }
        previousposition = position;
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    public class HolderView extends RecyclerView.ViewHolder{
        ImageView imageView;
        public HolderView(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.images);
        }
    }
}

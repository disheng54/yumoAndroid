package com.yumo.android.test.view.recyclerview.nestedscroll;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yumo.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wks on 15/11/22.
 * 让RecyclerView上面的部件跟随其一起滑动实现方法
 * https://www.jianshu.com/p/af299c1ec76c
 */
public class TestNestedScrollRecyclerView extends FrameLayout {

    private RecyclerView mListView = null;
    private ItemAdapter mAdapter = null;
    private List<String> mDataList = null;

    private LinearLayout mHeadView = null;

    public TestNestedScrollRecyclerView(Context context) {
        super(context);
        setupUI();
    }

    public TestNestedScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupUI();
    }

    public TestNestedScrollRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupUI();
    }

    public void setupUI(){
        View view = View.inflate(getContext(), R.layout.nested_scrollview, this);
        mHeadView = view.findViewById(R.id.header);
        initTestData();


        mListView = view.findViewById(R.id.list);
        mListView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new ItemAdapter(getContext());
        mListView.setAdapter(mAdapter);
    }

    private void initTestData(){
        if (mDataList == null){
            mDataList = new ArrayList<>();
        }

        for (int n =0; n< 50; n++){
            mDataList.add("test "+n);
        }
    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
        private LayoutInflater mInflater;

        public ItemAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = mInflater.inflate(R.layout.recycler_simple_array_one, viewGroup, false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ItemViewHolder itemViewHolder, final int i) {
            itemViewHolder.mTextView.setText(mDataList.get(i));
        }

        @Override
        public int getItemCount() {
            if (mDataList == null){
                return 0;
            }

            return mDataList.size();
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {
            TextView mTextView;

            public ItemViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.drag_title_id);
            }

        }
    }
}

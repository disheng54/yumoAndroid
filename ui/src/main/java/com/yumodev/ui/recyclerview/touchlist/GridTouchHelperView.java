

package com.yumodev.ui.recyclerview.touchlist;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.widget.FrameLayout;

public class GridTouchHelperView extends FrameLayout implements OnStartDragListener {

    private ItemTouchHelper mItemTouchHelper;

    public GridTouchHelperView(Context context) {
        super(context);
    }

    public void setupUI(){
        final RecyclerListAdapter adapter = new RecyclerListAdapter(getContext(), this);

        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        final int spanCount = 4;
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), spanCount);
        recyclerView.setLayoutManager(layoutManager);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);

        addView(recyclerView);
    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}

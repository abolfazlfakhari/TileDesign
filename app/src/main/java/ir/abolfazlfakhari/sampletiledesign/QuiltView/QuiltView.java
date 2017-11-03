package ir.abolfazlfakhari.sampletiledesign.QuiltView;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Iterator;

import ir.abolfazlfakhari.sampletiledesign.R;


public class QuiltView extends FrameLayout implements OnGlobalLayoutListener {
    private Adapter adapter;
    private DataSetObserver adapterObserver = new DataSetObserver() {
        public void onChanged() {
            super.onChanged();
            onDataChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            onDataChanged();
        }

        public void onDataChanged() {
            QuiltView.this.setViewsFromAdapter(QuiltView.this.adapter);
        }
    };
    public boolean isVertical = false;
    public int padding = 2;
    public QuiltViewBase quilt;
    public ViewGroup scroll;
    public ArrayList<View> views;

    public QuiltView(Context context, boolean isVertical) {
        super(context);
        this.isVertical = isVertical;
        setup();
    }

    public QuiltView(Context context, AttributeSet attrs) {
        super(context, attrs);
        String orientation = context.obtainStyledAttributes(attrs, R.styleable.QuiltView).getString(0);
        if (orientation != null) {
            if (orientation.equals("vertical")) {
                this.isVertical = true;
            } else {
                this.isVertical = false;
            }
        }
        setup();
    }

    public void setup() {
        this.views = new ArrayList();
        if (this.isVertical) {
            this.scroll = new ScrollView(getContext());
        } else {
            this.scroll = new HorizontalScrollView(getContext());
        }
        this.quilt = new QuiltViewBase(getContext(), this.isVertical);
        this.scroll.addView(this.quilt);
        addView(this.scroll);
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
        adapter.registerDataSetObserver(this.adapterObserver);
        setViewsFromAdapter(adapter);
    }

    private void setViewsFromAdapter(Adapter adapter) {
        removeAllViews();
        for (int i = 0; i < adapter.getCount(); i++) {
            this.quilt.addPatch(adapter.getView(i, null, null));
        }
    }

    public void addPatchImages(ArrayList<ImageView> images) {
        Iterator it = images.iterator();
        while (it.hasNext()) {
            addPatchImage((ImageView) it.next());
        }
    }

    public void addPatchImage(ImageView image) {
        image.setLayoutParams(new LayoutParams(-1, -1));
        LinearLayout wrapper = new LinearLayout(getContext());
        wrapper.setPadding(this.padding, this.padding, this.padding, this.padding);
        wrapper.addView(image);
        this.quilt.addPatch(wrapper);
    }

    public void addPatchViews(ArrayList<View> views_a) {
        Iterator it = views_a.iterator();
        while (it.hasNext()) {
            this.quilt.addPatch((View) it.next());
        }
    }

    public void addPatchView(View view) {
        this.quilt.addPatch(view);
    }

    public void addPatchesOnLayout() {
        Iterator it = this.views.iterator();
        while (it.hasNext()) {
            this.quilt.addPatch((View) it.next());
        }
    }

    public void removeQuilt(View view) {
        this.quilt.removeView(view);
    }

    public void setChildPadding(int padding) {
        this.padding = padding;
    }

    public void refresh() {
        this.quilt.refresh();
    }

    public void setOrientation(boolean isVertical) {
        this.isVertical = isVertical;
    }

    public void onGlobalLayout() {
    }

    public void addPatchView(View view, int row, int column) {
        LinearLayout wrapper = new LinearLayout(getContext());
        wrapper.setPadding(this.padding, this.padding, this.padding, this.padding);
        wrapper.addView(view);
        this.quilt.addPatch(wrapper, row, column);
    }
}

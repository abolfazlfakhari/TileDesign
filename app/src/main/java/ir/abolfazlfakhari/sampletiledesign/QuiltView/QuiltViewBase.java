package ir.abolfazlfakhari.sampletiledesign.QuiltView;

import android.content.Context;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.imagepipeline.producers.ThumbnailSizeChecker;

import java.util.ArrayList;
import java.util.Iterator;

public class QuiltViewBase extends GridLayout {
    public int columns;
    public boolean isVertical = true;
    public int rows;
    public int[] size;
    public int view_height = -1;
    public int view_width = -1;
    public ArrayList<View> views;
    public int padding;

    public QuiltViewBase(Context context, boolean isVertical) {
        super(context);
        this.isVertical = isVertical;
        if (this.view_width == -1) {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int height = metrics.heightPixels - 120;
            this.view_width = (metrics.widthPixels - getPaddingLeft()) - getPaddingRight();
            this.view_height = (height - getPaddingTop()) - getPaddingBottom();
        }
        this.views = new ArrayList();
        setup();
    }

    public void setup() {
        if (this.isVertical) {
            setupVertical();
        } else {
            setupHorizontal();
        }
    }

    public void setupVertical() {
        this.size = getBaseSizeVertical();
        setColumnCount(this.columns);
        setRowCount(Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        setOrientation(GridLayout.HORIZONTAL);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        this.setLayoutParams(params);
    }

    public void setupHorizontal() {
        this.size = getBaseSizeHorizontal();
        setRowCount(this.rows);
        setColumnCount(-1);
        setOrientation(GridLayout.VERTICAL);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        this.setLayoutParams(params);
    }

    public void addPatch(View view) {
        QuiltViewPatch child = QuiltViewPatch.init(getChildCount(), this.columns);
        LayoutParams params = new LayoutParams();
        params.width = this.size[0] * child.width_ratio;
        params.height = this.size[1] * child.height_ratio;
        params.rowSpec = GridLayout.spec(Integer.MIN_VALUE, child.height_ratio);
        params.columnSpec = GridLayout.spec(Integer.MIN_VALUE, child.width_ratio);
        view.setLayoutParams(params);
        addView(view);
        this.views.add(view);
    }

    public void addPatch(View view, int row, int column) {
        int count = getChildCount();

        QuiltViewPatch child = new QuiltViewPatch(row, column);
        LayoutParams params = new LayoutParams();
        params.width = this.size[0] * child.width_ratio;
        params.height = this.size[1] * child.height_ratio;
        params.rowSpec = GridLayout.spec(Integer.MIN_VALUE, child.height_ratio);
        params.columnSpec = GridLayout.spec(Integer.MIN_VALUE, child.width_ratio);
        view.setLayoutParams(params);
        addView(view);
        this.views.add(view);
    }

    public LayoutParams getLayoutParams(int row, int column) {
        QuiltViewPatch child = new QuiltViewPatch(row, column);
        LayoutParams params1 = new LayoutParams();
        params1.width = this.size[0] * child.width_ratio;
        params1.height = this.size[1] * child.height_ratio;
        params1.rowSpec = GridLayout.spec(Integer.MIN_VALUE, child.height_ratio);
        params1.columnSpec = GridLayout.spec(Integer.MIN_VALUE, child.width_ratio);
        return params1;
    }

    public void refresh() {
        removeAllViewsInLayout();
        setup();
        Iterator it = this.views.iterator();
        while (it.hasNext()) {
            addPatch((View) it.next());
        }
    }

    public int[] getBaseSize() {
        int[] size = new int[2];
        int base_width = getBaseWidth();
        int base_height = (int) (((float) base_width) * 0.75f);
        size[0] = base_width;
        size[1] = base_height;
        return size;
    }

    public int[] getBaseSizeVertical() {
        int[] size = new int[2];
        int base_width = getBaseWidth();
        int base_height = (int) (((float) base_width) * 0.75f);
        size[0] = base_width;
        size[1] = base_height;
        return size;
    }

    public int[] getBaseSizeHorizontal() {
        size = new int[2];
        int base_height = getBaseHeight();
        size[0] = (int) (((float) base_height) * ThumbnailSizeChecker.ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO);
        size[1] = base_height;
        return size;
    }

    public int getBaseWidth() {
        this.columns = 3;
        return this.view_width / this.columns;
    }

    public int getBaseHeight() {
        if (this.view_height < 350) {
            this.rows = 2;
        } else if (this.view_height < 650) {
            this.rows = 3;
        } else if (this.view_height < 1050) {
            this.rows = 4;
        } else if (this.view_height < 1250) {
            this.rows = 5;
        } else {
            this.rows = 6;
        }
        return this.view_height / this.rows;
    }

    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld) {
        super.onSizeChanged(xNew, yNew, xOld, yOld);
        this.view_width = xNew;
        this.view_height = yNew;
    }
}

package kz.sapasoft.emark.app;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kz.sapasoft.emark.app.databinding.ActivityWelcomeBindingImpl;
import kz.sapasoft.emark.app.databinding.FragmentAboutBindingImpl;
import kz.sapasoft.emark.app.databinding.FragmentMainBindingImpl;
import kz.sapasoft.emark.app.databinding.FragmentMapBindingImpl;
import kz.sapasoft.emark.app.databinding.FragmentMarkerBindingImpl;
import kz.sapasoft.emark.app.databinding.FragmentProjectsBindingImpl;
import kz.sapasoft.emark.app.databinding.FragmentSettingsBindingImpl;
import kz.sapasoft.emark.app.databinding.ItemPhotoBindingImpl;
import kz.sapasoft.emark.app.databinding.ItemPhotoFooterBindingImpl;
import kz.sapasoft.emark.app.databinding.ItemProjectBindingImpl;
import kz.ss.emark.R;

public abstract class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYWELCOME = 1;
    private static final int LAYOUT_FRAGMENTABOUT = 2;
    private static final int LAYOUT_FRAGMENTMAIN = 3;
    private static final int LAYOUT_FRAGMENTMAP = 4;
    private static final int LAYOUT_FRAGMENTMARKER = 5;
    private static final int LAYOUT_FRAGMENTPROJECTS = 6;
    private static final int LAYOUT_FRAGMENTSETTINGS = 7;
    private static final int LAYOUT_ITEMPHOTO = 8;
    private static final int LAYOUT_ITEMPHOTOFOOTER = 9;
    private static final int LAYOUT_ITEMPROJECT = 10;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(10);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_welcome, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_about, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_main, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_map, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_marker, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_projects, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_settings, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_photo, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_photo_footer, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_project, 10);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i2) {
                case 1:
                    if ("layout/activity_welcome_0".equals(tag)) {
                        return new ActivityWelcomeBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_welcome is invalid. Received: " + tag);
                case 2:
                    if ("layout/fragment_about_0".equals(tag)) {
                        return new FragmentAboutBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_about is invalid. Received: " + tag);
                case 3:
                    if ("layout/fragment_main_0".equals(tag)) {
                        return new FragmentMainBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_main is invalid. Received: " + tag);
                case 4:
                    if ("layout/fragment_map_0".equals(tag)) {
                        return new FragmentMapBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_map is invalid. Received: " + tag);
                case 5:
                    if ("layout/fragment_marker_0".equals(tag)) {
                        return new FragmentMarkerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_marker is invalid. Received: " + tag);
                case 6:
                    if ("layout/fragment_projects_0".equals(tag)) {
                        return new FragmentProjectsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_projects is invalid. Received: " + tag);
                case 7:
                    if ("layout/fragment_settings_0".equals(tag)) {
                        return new FragmentSettingsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_settings is invalid. Received: " + tag);
                case 8:
                    if ("layout/item_photo_0".equals(tag)) {
                        return new ItemPhotoBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_photo is invalid. Received: " + tag);
                case 9:
                    if ("layout/item_photo_footer_0".equals(tag)) {
                        return new ItemPhotoFooterBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_photo_footer is invalid. Received: " + tag);
                case 10:
                    if ("layout/item_project_0".equals(tag)) {
                        return new ItemProjectBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for item_project is invalid. Received: " + tag);
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @SuppressLint("RestrictedApi")
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @SuppressLint("RestrictedApi")
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @SuppressLint("RestrictedApi")
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(7);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sKeys.put(1, "about");
            sKeys.put(2, "imageDataModel");
            sKeys.put(3, "isVisible");
            sKeys.put(4, "item");
            sKeys.put(5, "model");
            sKeys.put(6, "viewModel");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(10);
            sKeys = hashMap;
            hashMap.put("layout/activity_welcome_0", Integer.valueOf(R.layout.activity_welcome));
            sKeys.put("layout/fragment_about_0", Integer.valueOf(R.layout.fragment_about));
            sKeys.put("layout/fragment_main_0", Integer.valueOf(R.layout.fragment_main));
            sKeys.put("layout/fragment_map_0", Integer.valueOf(R.layout.fragment_map));
            sKeys.put("layout/fragment_marker_0", Integer.valueOf(R.layout.fragment_marker));
            sKeys.put("layout/fragment_projects_0", Integer.valueOf(R.layout.fragment_projects));
            sKeys.put("layout/fragment_settings_0", Integer.valueOf(R.layout.fragment_settings));
            sKeys.put("layout/item_photo_0", Integer.valueOf(R.layout.item_photo));
            sKeys.put("layout/item_photo_footer_0", Integer.valueOf(R.layout.item_photo_footer));
            sKeys.put("layout/item_project_0", Integer.valueOf(R.layout.item_project));
        }
    }
}

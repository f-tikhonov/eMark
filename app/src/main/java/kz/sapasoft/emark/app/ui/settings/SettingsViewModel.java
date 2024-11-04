package kz.sapasoft.emark.app.ui.settings;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.core.BaseViewModel;
import kz.sapasoft.emark.app.data.cloud.repository.BaseCloudRepository;
import kz.sapasoft.emark.app.data.local.prefs.PrefsImpl;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerRepository;
import kz.sapasoft.emark.app.data.local.room.project.ProjectRepository;
import kz.sapasoft.emark.app.data.local.room.tag.TagRepository;
import kz.sapasoft.emark.app.data.local.room.template.TemplateRepository;
import kz.sapasoft.emark.app.domain.model.MarkerModel;
import kz.sapasoft.emark.app.domain.model.ProjectModel;
import kz.sapasoft.emark.app.domain.model.TagModel;
import kz.sapasoft.emark.app.domain.model.TemplateModel;
import kz.ss.emark.R;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020,H\u0002J\u0006\u0010/\u001a\u000200J\b\u00101\u001a\u00020,H\u0002J\b\u00102\u001a\u00020,H\u0002J\b\u00103\u001a\u00020,H\u0002J\u0010\u00104\u001a\u00020,2\u0006\u00105\u001a\u000206H\u0002J\u0016\u00107\u001a\u00020,2\f\u00108\u001a\b\u0012\u0004\u0012\u00020609H\u0002J\u0016\u0010:\u001a\u00020,2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<09H\u0002J\u0016\u0010=\u001a\u00020,2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?09H\u0002J\u0016\u0010@\u001a\u00020,2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B09H\u0002J\u000e\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u000200J\b\u0010E\u001a\u00020,H\u0002J\u000e\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020\u001bR\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00158FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00158FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001c\u0010\u0017R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u00158FX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b!\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00158FX\u0002¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b$\u0010\u0017R!\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00158FX\u0002¢\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b'\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lkz/sapasoft/emark/app/ui/settings/SettingsViewModel;", "Lkz/sapasoft/emark/app/core/BaseViewModel;", "prefsImpl", "Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;", "context", "Landroid/content/Context;", "baseCloudRepository", "Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;", "projectRepository", "Lkz/sapasoft/emark/app/data/local/room/project/ProjectRepository;", "tagRepository", "Lkz/sapasoft/emark/app/data/local/room/tag/TagRepository;", "templateRepository", "Lkz/sapasoft/emark/app/data/local/room/template/TemplateRepository;", "markerRepository", "Lkz/sapasoft/emark/app/data/local/room/marker/MarkerRepository;", "(Lkz/sapasoft/emark/app/data/local/prefs/PrefsImpl;Landroid/content/Context;Lkz/sapasoft/emark/app/data/cloud/repository/BaseCloudRepository;Lkz/sapasoft/emark/app/data/local/room/project/ProjectRepository;Lkz/sapasoft/emark/app/data/local/room/tag/TagRepository;Lkz/sapasoft/emark/app/data/local/room/template/TemplateRepository;Lkz/sapasoft/emark/app/data/local/room/marker/MarkerRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "dateDb", "Landroidx/lifecycle/MutableLiveData;", "getDateDb", "()Landroidx/lifecycle/MutableLiveData;", "dateDb$delegate", "Lkotlin/Lazy;", "loadButtonEnabled", "", "getLoadButtonEnabled", "loadButtonEnabled$delegate", "markersPages", "", "offlineMode", "getOfflineMode", "offlineMode$delegate", "progress", "getProgress", "progress$delegate", "progressVisibility", "getProgressVisibility", "progressVisibility$delegate", "projectsPages", "tagsPages", "downloadAllDataFromServer", "", "getMarkerDetails", "getMarkerList", "getMarkerSize", "", "getProjectList", "getTags", "getTemplateList", "insertMarkerEntity", "markerModel", "Lkz/sapasoft/emark/app/domain/model/MarkerModel;", "insertMarkerEntityList", "markerModelList", "", "insertProjectEntityList", "projectModelList", "Lkz/sapasoft/emark/app/domain/model/ProjectModel;", "insertTagEntityList", "tagModelList", "Lkz/sapasoft/emark/app/domain/model/TagModel;", "insertTemplateEntityList", "templateModelList", "Lkz/sapasoft/emark/app/domain/model/TemplateModel;", "saveMarkerSize", "size", "setLoadingDate", "setOfflineMode", "isOffline", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: SettingsViewModel.kt */
public final class SettingsViewModel extends BaseViewModel {
    private final String TAG = getClass().getSimpleName();
    /* access modifiers changed from: private */
    public final BaseCloudRepository baseCloudRepository;
    private final Context context;
    private final Lazy dateDb$delegate = LazyKt.lazy(SettingsViewModel$dateDb$2.INSTANCE);
    private final Lazy loadButtonEnabled$delegate = LazyKt.lazy(SettingsViewModel$loadButtonEnabled$2.INSTANCE);
    /* access modifiers changed from: private */
    public final MarkerRepository markerRepository;
    /* access modifiers changed from: private */
    public int markersPages;
    private final Lazy offlineMode$delegate = LazyKt.lazy(SettingsViewModel$offlineMode$2.INSTANCE);
    /* access modifiers changed from: private */
    public final PrefsImpl prefsImpl;
    private final Lazy progress$delegate = LazyKt.lazy(SettingsViewModel$progress$2.INSTANCE);
    private final Lazy progressVisibility$delegate = LazyKt.lazy(SettingsViewModel$progressVisibility$2.INSTANCE);
    /* access modifiers changed from: private */
    public final ProjectRepository projectRepository;
    /* access modifiers changed from: private */
    public int projectsPages;
    /* access modifiers changed from: private */
    public final TagRepository tagRepository;
    /* access modifiers changed from: private */
    public int tagsPages;
    /* access modifiers changed from: private */
    public final TemplateRepository templateRepository;

    public final MutableLiveData<String> getDateDb() {
        return (MutableLiveData) this.dateDb$delegate.getValue();
    }

    public final MutableLiveData<Boolean> getLoadButtonEnabled() {
        return (MutableLiveData) this.loadButtonEnabled$delegate.getValue();
    }

    public final MutableLiveData<Boolean> getOfflineMode() {
        return (MutableLiveData) this.offlineMode$delegate.getValue();
    }

    public final MutableLiveData<Integer> getProgress() {
        return (MutableLiveData) this.progress$delegate.getValue();
    }

    public final MutableLiveData<Boolean> getProgressVisibility() {
        return (MutableLiveData) this.progressVisibility$delegate.getValue();
    }

    @Inject
    public SettingsViewModel(PrefsImpl prefsImpl2, Context context2, BaseCloudRepository baseCloudRepository2, ProjectRepository projectRepository2, TagRepository tagRepository2, TemplateRepository templateRepository2, MarkerRepository markerRepository2) {
        Intrinsics.checkParameterIsNotNull(prefsImpl2, "prefsImpl");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(baseCloudRepository2, "baseCloudRepository");
        Intrinsics.checkParameterIsNotNull(projectRepository2, "projectRepository");
        Intrinsics.checkParameterIsNotNull(tagRepository2, "tagRepository");
        Intrinsics.checkParameterIsNotNull(templateRepository2, "templateRepository");
        Intrinsics.checkParameterIsNotNull(markerRepository2, "markerRepository");
        this.prefsImpl = prefsImpl2;
        this.context = context2;
        this.baseCloudRepository = baseCloudRepository2;
        this.projectRepository = projectRepository2;
        this.tagRepository = tagRepository2;
        this.templateRepository = templateRepository2;
        this.markerRepository = markerRepository2;
        setLoadingDate();
        getOfflineMode().postValue(Boolean.valueOf(this.prefsImpl.getOffline()));
        this.prefsImpl.getDateDB();
        getProgressVisibility().postValue(false);
        this.projectsPages = 1;
        this.tagsPages = 1;
        this.markersPages = 1;
    }

    public final void setOfflineMode(boolean z) {
        this.prefsImpl.setOffline(z);
        getLoadButtonEnabled().postValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final void setLoadingDate() {
        String str;
        if (this.prefsImpl.getDateDB() == null) {
            str = "";
        } else {
            str = this.context.getResources().getString(R.string.download_date_x, new Object[]{this.prefsImpl.getDateDB()});
            Intrinsics.checkExpressionValueIsNotNull(str, "context.resources.getStr…x, prefsImpl.getDateDB())");
        }
        getDateDb().postValue(str);
    }

    public final void downloadAllDataFromServer() {
        this.projectsPages = 1;
        this.tagsPages = 1;
        this.markersPages = 1;
        getProgress().postValue(0);
        getProgressVisibility().postValue(true);
        getProjectList();
        getTags();
    }

    /* access modifiers changed from: private */
    public final void getProjectList() {
        launchIO(new SettingsViewModel$getProjectList$1(this, (Continuation) null));
    }

    /* access modifiers changed from: private */
    public final void getTemplateList() {
        launchIO(new SettingsViewModel$getTemplateList$1(this, (Continuation) null));
    }

    /* access modifiers changed from: private */
    public final void getTags() {
        launchIO(new SettingsViewModel$getTags$1(this, (Continuation) null));
    }

    /* access modifiers changed from: private */
    public final void getMarkerList() {
        launchIO(new SettingsViewModel$getMarkerList$1(this, (Continuation) null));
    }

    /* access modifiers changed from: private */
    public final void getMarkerDetails() {
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (true) {
            i = 0;
            if (i2 <= 0) {
                break;
            }
            int i3 = i2 + 1;
            Collection findAll = this.markerRepository.findAll(i2);
            if (!findAll.isEmpty()) {
                arrayList.addAll(findAll);
                i2 = i3;
            } else {
                i2 = 0;
            }
        }
        for (Object next : arrayList) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            launchIO(new SettingsViewModel$getMarkerDetails$$inlined$forEachIndexed$lambda$1((MarkerModel) next, i, (Continuation) null, this, arrayList));
            i = i4;
        }
    }

    /* access modifiers changed from: private */
    public final void insertProjectEntityList(List<ProjectModel> list) {
        this.projectRepository.addProjectList(list);
    }

    /* access modifiers changed from: private */
    public final void insertTagEntityList(List<TagModel> list) {
        this.tagRepository.addTagList(list);
    }

    /* access modifiers changed from: private */
    public final void insertTemplateEntityList(List<TemplateModel> list) {
        this.templateRepository.addWithReplace(list);
    }

    /* access modifiers changed from: private */
    public final void insertMarkerEntityList(List<MarkerModel> list) {
        this.markerRepository.addWithReplace(list);
    }

    /* access modifiers changed from: private */
    public final void insertMarkerEntity(MarkerModel markerModel) {
        this.markerRepository.addWithReplace(markerModel);
    }

    public final void saveMarkerSize(float f) {
        this.prefsImpl.setMarkerSize(f);
    }

    public final float getMarkerSize() {
        return this.prefsImpl.getMarkerSize();
    }
}

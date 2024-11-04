package kz.sapasoft.emark.app.data.local.room;

import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kz.sapasoft.emark.app.data.local.room.image.ImageDao;
import kz.sapasoft.emark.app.data.local.room.marker.MarkerDao;
import kz.sapasoft.emark.app.data.local.room.marker_sync.MarkerSyncDao;
import kz.sapasoft.emark.app.data.local.room.project.ProjectDao;
import kz.sapasoft.emark.app.data.local.room.tag.TagDao;
import kz.sapasoft.emark.app.data.local.room.template.TemplateDao;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/LocalDatabase;", "Landroidx/room/RoomDatabase;", "()V", "imageDao", "Lkz/sapasoft/emark/app/data/local/room/image/ImageDao;", "getImageDao", "()Lkz/sapasoft/emark/app/data/local/room/image/ImageDao;", "markerDao", "Lkz/sapasoft/emark/app/data/local/room/marker/MarkerDao;", "getMarkerDao", "()Lkz/sapasoft/emark/app/data/local/room/marker/MarkerDao;", "markerSyncDao", "Lkz/sapasoft/emark/app/data/local/room/marker_sync/MarkerSyncDao;", "getMarkerSyncDao", "()Lkz/sapasoft/emark/app/data/local/room/marker_sync/MarkerSyncDao;", "projectDao", "Lkz/sapasoft/emark/app/data/local/room/project/ProjectDao;", "getProjectDao", "()Lkz/sapasoft/emark/app/data/local/room/project/ProjectDao;", "tagDao", "Lkz/sapasoft/emark/app/data/local/room/tag/TagDao;", "getTagDao", "()Lkz/sapasoft/emark/app/data/local/room/tag/TagDao;", "templateDao", "Lkz/sapasoft/emark/app/data/local/room/template/TemplateDao;", "getTemplateDao", "()Lkz/sapasoft/emark/app/data/local/room/template/TemplateDao;", "Companion", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: LocalDatabase.kt */
public abstract class LocalDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int VERSION = 1;

    public abstract ImageDao getImageDao();

    public abstract MarkerDao getMarkerDao();

    public abstract MarkerSyncDao getMarkerSyncDao();

    public abstract ProjectDao getProjectDao();

    public abstract TagDao getTagDao();

    public abstract TemplateDao getTemplateDao();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/LocalDatabase$Companion;", "", "()V", "VERSION", "", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: LocalDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

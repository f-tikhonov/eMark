package kz.sapasoft.emark.app.data.local.room;

import com.google.gson.Gson;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kz.sapasoft.emark.app.domain.model.EdgeModel;
import kz.sapasoft.emark.app.domain.model.FieldModel;
import kz.sapasoft.emark.app.domain.model.ImageDataModel;
import kz.sapasoft.emark.app.utils.Constants;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006H\u0007J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006H\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\rH\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fH\u0007J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0018\u00010\u0011R\u00020\u0012H\u0007J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0007J \u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0007J\u001a\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u001b\u001a\b\u0018\u00010\u0011R\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u001e"}, d2 = {"Lkz/sapasoft/emark/app/data/local/room/DataConverter;", "", "()V", "fromDoubleList", "", "value", "", "", "fromEdgeModelList", "Lkz/sapasoft/emark/app/domain/model/EdgeModel;", "fromFieldModelList", "Lkz/sapasoft/emark/app/domain/model/FieldModel;", "fromFile", "Ljava/io/File;", "fromMarkerStatus", "Lkz/sapasoft/emark/app/utils/Constants$MarkerStatus;", "fromMetaData", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel$MetaData;", "Lkz/sapasoft/emark/app/domain/model/ImageDataModel;", "fromStringList", "fromStringMap", "", "toDoubleList", "toEdgeModelList", "toFieldModelList", "toFile", "toMarkerStatus", "toMetaData", "toStringList", "toStringMap", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DataConverter.kt */
public final class DataConverter {
    public final String fromStringList(List<String> list) {
        return new Gson().toJson((Object) list, new DataConverter$fromStringList$type$1().getType());
    }

    public final List<String> toStringList(String str) {
        return (List) new Gson().fromJson(str, new DataConverter$toStringList$type$1().getType());
    }

    public final String fromDoubleList(List<Double> list) {
        return new Gson().toJson((Object) list, new DataConverter$fromDoubleList$type$1().getType());
    }

    public final List<Double> toDoubleList(String str) {
        return (List) new Gson().fromJson(str, new DataConverter$toDoubleList$type$1().getType());
    }

    public final String fromStringMap(Map<String, String> map) {
        return new Gson().toJson((Object) map, new DataConverter$fromStringMap$type$1().getType());
    }

    public final Map<String, String> toStringMap(String str) {
        return (Map) new Gson().fromJson(str, new DataConverter$toStringMap$type$1().getType());
    }

    public final String fromFieldModelList(List<FieldModel> list) {
        return new Gson().toJson((Object) list, new DataConverter$fromFieldModelList$type$1().getType());
    }

    public final List<FieldModel> toFieldModelList(String str) {
        return (List) new Gson().fromJson(str, new DataConverter$toFieldModelList$type$1().getType());
    }

    public final String fromEdgeModelList(List<EdgeModel> list) {
        return new Gson().toJson((Object) list, new DataConverter$fromEdgeModelList$type$1().getType());
    }

    public final List<EdgeModel> toEdgeModelList(String str) {
        return (List) new Gson().fromJson(str, new DataConverter$toEdgeModelList$type$1().getType());
    }

    public final String fromMarkerStatus(Constants.MarkerStatus markerStatus) {
        if (markerStatus != null) {
            return markerStatus.name();
        }
        return null;
    }

    public final Constants.MarkerStatus toMarkerStatus(String str) {
        if (str != null) {
            return Constants.MarkerStatus.valueOf(str);
        }
        return null;
    }

    public final String fromMetaData(ImageDataModel.MetaData metaData) {
        return new Gson().toJson((Object) metaData, new DataConverter$fromMetaData$type$1().getType());
    }

    public final ImageDataModel.MetaData toMetaData(String str) {
        return (ImageDataModel.MetaData) new Gson().fromJson(str, new DataConverter$toMetaData$type$1().getType());
    }

    public final String fromFile(File file) {
        return new Gson().toJson((Object) file, new DataConverter$fromFile$type$1().getType());
    }

    public final File toFile(String str) {
        return (File) new Gson().fromJson(str, new DataConverter$toFile$type$1().getType());
    }
}

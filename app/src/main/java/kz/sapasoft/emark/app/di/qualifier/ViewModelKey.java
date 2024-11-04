package kz.sapasoft.emark.app.di.qualifier;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Documented
@java.lang.annotation.Target({ElementType.METHOD})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0010\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkz/sapasoft/emark/app/di/qualifier/ViewModelKey;", "", "value", "Lkotlin/reflect/KClass;", "Landroidx/lifecycle/ViewModel;", "()Ljava/lang/Class;", "app_release"}, k = 1, mv = {1, 1, 16})
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* compiled from: ViewModelKey.kt */
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}

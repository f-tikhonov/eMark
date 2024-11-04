package kz.sapasoft.emark.app.ui.photo;

import android.view.View;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kz.sapasoft.emark.app.R;
import kz.sapasoft.emark.app.utils.Utils;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: PhotoActivity.kt */
final class PhotoActivity$setOnClickListeners$1 implements View.OnClickListener {
    final /* synthetic */ PhotoActivity this$0;

    PhotoActivity$setOnClickListeners$1(PhotoActivity photoActivity) {
        this.this$0 = photoActivity;
    }

    public final void onClick(View view) {
        Utils utils = Utils.INSTANCE;
        MaterialButton materialButton = (MaterialButton) this.this$0._$_findCachedViewById(R.id.btn_start);
        Intrinsics.checkExpressionValueIsNotNull(materialButton, "btn_start");
        utils.hideKeyboard(materialButton);
        PhotoViewModel access$getViewModel$p = this.this$0.getViewModel();
        TextInputEditText textInputEditText = (TextInputEditText) this.this$0._$_findCachedViewById(R.id.et_username);
        Intrinsics.checkExpressionValueIsNotNull(textInputEditText, "et_username");
        String valueOf = String.valueOf(textInputEditText.getText());
        TextInputEditText textInputEditText2 = (TextInputEditText) this.this$0._$_findCachedViewById(R.id.et_password);
        Intrinsics.checkExpressionValueIsNotNull(textInputEditText2, "et_password");
        String valueOf2 = String.valueOf(textInputEditText2.getText());
        TextInputEditText textInputEditText3 = (TextInputEditText) this.this$0._$_findCachedViewById(R.id.et_server);
        Intrinsics.checkExpressionValueIsNotNull(textInputEditText3, "et_server");
        access$getViewModel$p.login(valueOf, valueOf2, String.valueOf(textInputEditText3.getText()));
    }
}

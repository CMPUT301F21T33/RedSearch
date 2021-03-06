// Generated by view binder compiler. Do not edit!
package com.example.redsearch.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.redsearch.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddHabitEventBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText Comment;

  @NonNull
  public final Button button3;

  @NonNull
  public final ImageButton cameraButton;

  @NonNull
  public final Button cancel;

  @NonNull
  public final TextView coordinates;

  @NonNull
  public final ImageView habitImage;

  @NonNull
  public final ImageButton imageButton4;

  @NonNull
  public final ImageButton mapbutton;

  @NonNull
  public final ToolbarBinding toolbarAddHabitEvent;

  private ActivityAddHabitEventBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText Comment, @NonNull Button button3, @NonNull ImageButton cameraButton,
      @NonNull Button cancel, @NonNull TextView coordinates, @NonNull ImageView habitImage,
      @NonNull ImageButton imageButton4, @NonNull ImageButton mapbutton,
      @NonNull ToolbarBinding toolbarAddHabitEvent) {
    this.rootView = rootView;
    this.Comment = Comment;
    this.button3 = button3;
    this.cameraButton = cameraButton;
    this.cancel = cancel;
    this.coordinates = coordinates;
    this.habitImage = habitImage;
    this.imageButton4 = imageButton4;
    this.mapbutton = mapbutton;
    this.toolbarAddHabitEvent = toolbarAddHabitEvent;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddHabitEventBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddHabitEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_habit_event, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddHabitEventBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Comment;
      EditText Comment = ViewBindings.findChildViewById(rootView, id);
      if (Comment == null) {
        break missingId;
      }

      id = R.id.button3;
      Button button3 = ViewBindings.findChildViewById(rootView, id);
      if (button3 == null) {
        break missingId;
      }

      id = R.id.cameraButton;
      ImageButton cameraButton = ViewBindings.findChildViewById(rootView, id);
      if (cameraButton == null) {
        break missingId;
      }

      id = R.id.cancel;
      Button cancel = ViewBindings.findChildViewById(rootView, id);
      if (cancel == null) {
        break missingId;
      }

      id = R.id.coordinates;
      TextView coordinates = ViewBindings.findChildViewById(rootView, id);
      if (coordinates == null) {
        break missingId;
      }

      id = R.id.habitImage;
      ImageView habitImage = ViewBindings.findChildViewById(rootView, id);
      if (habitImage == null) {
        break missingId;
      }

      id = R.id.imageButton4;
      ImageButton imageButton4 = ViewBindings.findChildViewById(rootView, id);
      if (imageButton4 == null) {
        break missingId;
      }

      id = R.id.mapbutton;
      ImageButton mapbutton = ViewBindings.findChildViewById(rootView, id);
      if (mapbutton == null) {
        break missingId;
      }

      id = R.id.toolbar_add_habit_event;
      View toolbarAddHabitEvent = ViewBindings.findChildViewById(rootView, id);
      if (toolbarAddHabitEvent == null) {
        break missingId;
      }
      ToolbarBinding binding_toolbarAddHabitEvent = ToolbarBinding.bind(toolbarAddHabitEvent);

      return new ActivityAddHabitEventBinding((ConstraintLayout) rootView, Comment, button3,
          cameraButton, cancel, coordinates, habitImage, imageButton4, mapbutton,
          binding_toolbarAddHabitEvent);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

/**
 * CMPUT 301 FALL 2021
 * Project part 3
 * @author
 *
 * The {@code HabitEvent} Class
 *
 * Copyright 2021
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Acknowledgements:
 * */

package com.example.redsearch;

import androidx.annotation.NonNull;

import java.util.Date;
import android.graphics.Bitmap;

public class HabitEvent{
    private String comment;
    private Date date;
    public Bitmap image;

    /**
     * Habit Event Class constructor
     * @param comment {@code String} comment associated with HabitEvent
     * @param date {@code Date} date HabitEvent was created
     */
    HabitEvent(String comment, Date date){
        // a simple habit event constructor
        setComment(comment);
        setDate(date);
    }

    /**
     * Habit Event Class constructor with image
     * @param comment {@code String} comment associated with HabitEvent
     * @param date {@code Date} date HabitEvent was created
     * @param image {@code Bitmap} image of HabitEvent
     */
    HabitEvent(String comment, Date date, Bitmap image) {
        // overloaded constructor
        setComment(comment);
        setDate(date);
        setImage(image);
    }

    /**
     * HabitEvent's comment setter
     * The comment must be 20 characters or less.
     * If there are more than 20 characters, only the first 20 will be stored
     * @param Comment {@code String} Comment associated with HabitEvent
     */
    public void setComment(@NonNull String Comment){
        if (Comment.length() <= 20) {
            this.comment = Comment;
        } else {
            this.comment = Comment.substring(0,20);
        }
    }

    /**
     * HabitEvent's date setter
     * @param Date {@code Date} Date HabitEvent was created
     */
    public void setDate(Date Date){this.date = Date;}

    /**
     * HabitEvent's image setter
     * @param Image {@code Bitmap} image associated with HabitEvent
     */
    private void setImage(Bitmap Image) {this.image = Image;}

    /**
     * HabitEvent date getter
     * @return {@code Date} Date the habitEvent was created
     */
    Date getDate(){return this.date;}

    /**
     * HabitEvent comment getter
     * @return {@code String} Comment associated with HabitEvent
     */
    String getComment(){return this.comment;}

    /**
     * HabitEvent image getter
     * @return {@code Bitmap} Image associated with HabitEvent
     */
    Bitmap getImage(){return this.image;}

    /**
     * Overridden equals method to compare habit events.
     * @param obj {@code Object} The object class used for comparison
     * @return {@code boolean} True if objects are equal, False otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof HabitEvent)) {
            return false;
        }
        HabitEvent habitEvent = (HabitEvent) obj;
        return this.comment.equals(habitEvent.comment) && this.date.equals(habitEvent.date);
    }
}

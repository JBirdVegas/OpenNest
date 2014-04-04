package com.wearables;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.jbirdvegas.nest.NestHelper;
import com.jbirdvegas.nest.R;
import com.jbirdvegas.nest.models.valueobjects.SharedValueObject;
import com.jbirdvegas.nest.wearables.WearableWrapper;

/**
 * Created by jbird: 3/31/14
 */
public class WearableHelper {
    public static Notification getSetAbleTemperatureActions(Context context, NestHelper helper, SharedValueObject thermostat, int currentTemp) {
        int max = currentTemp + 3;
        int min = currentTemp - 3;

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setContentTitle(thermostat.getName())
                        .setContentText(context.getString(R.string.set_temp_wearable))
                        .setSmallIcon(R.drawable.ic_launcher);

        int counter = currentTemp;
        while (max > counter) {
            makeNotificationFor(notificationBuilder, counter++, context, helper, thermostat);
        }
        counter = currentTemp;
        while (min < counter) {
            makeNotificationFor(notificationBuilder, counter--, context, helper, thermostat);
        }

        return notificationBuilder.build();
    }

    private static void makeNotificationFor(NotificationCompat.Builder notificationBuilder,
                                            int counter,
                                            Context context,
                                            NestHelper helper,
                                            SharedValueObject thermostat) {
        counter++;
        WearableWrapper wearableWrapper = new WearableWrapper(context,
                helper,
                thermostat,
                R.drawable.ic_launcher,
                context.getString(R.string.change_temp),
                counter);
        notificationBuilder.addAction(wearableWrapper.getIcon(), wearableWrapper.getTitle(), wearableWrapper.getPendingIntent());
    }
}

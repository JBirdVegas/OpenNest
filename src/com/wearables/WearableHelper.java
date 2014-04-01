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
        int max = currentTemp + 5;
        int min = currentTemp - 5;

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setContentTitle(String.valueOf(R.string.app_name))
                        .setContentText(context.getString(R.string.set_temp_wearable))
                        .setSmallIcon(R.drawable.ic_launcher);
        for (int i = currentTemp; currentTemp + max > i; i++) {
            WearableWrapper wearableWrapper = new WearableWrapper(context,
                    helper,
                    thermostat,
                    R.drawable.ic_launcher,
                    context.getString(R.string.change_temp), i);
            notificationBuilder.addAction(wearableWrapper.getIcon(), wearableWrapper.getTitle(), wearableWrapper.getPendingIntent());
        }
        for (int i = currentTemp; currentTemp - min > i; i--) {
            WearableWrapper wearableWrapper = new WearableWrapper(context,
                    helper,
                    thermostat,
                    R.drawable.ic_launcher,
                    context.getString(R.string.change_temp), i);
            notificationBuilder.addAction(wearableWrapper.getIcon(), wearableWrapper.getTitle(), wearableWrapper.getPendingIntent());
        }
        return notificationBuilder.build();
    }
}

package com.maedi.user.godok.v1.fragment;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Window;
import android.widget.DatePicker;
import com.maedi.user.godok.v1.R;
import com.maedi.user.godok.v1.utils.DialogUtil;

/**
 * Created by user on 11/29/2016.
 */

public class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private String dialogTag;
    private DatePickerDialogFragmentListener listener;

    public interface DatePickerDialogFragmentListener {
        public void onDateSet(String date, String senderId, Bundle bundle);
    }

    public static class Builder
    {
        private String date;
        private boolean cancelable = true;
        private String senderId;
        private Bundle bundle;

        public DatePickerDialogFragment.Builder setDate(String date)
        {
            this.date = date;
            return this;
        }

        public DatePickerDialogFragment.Builder setCancelable(boolean cancelable)
        {
            this.cancelable = cancelable;
            return this;
        }

        public DatePickerDialogFragment.Builder setSenderId(String senderId)
        {
            this.senderId = senderId;
            return this;
        }

        public DatePickerDialogFragment.Builder setBundle(Bundle bundle)
        {
            this.bundle = bundle;
            return this;
        }

        public DatePickerDialogFragment build()
        {
            return DatePickerDialogFragment.newInstance(date, cancelable, senderId, bundle);
        }
    }

    protected static DatePickerDialogFragment newInstance()
    {
        return newInstance(null, true, "", null);
    }

    protected static DatePickerDialogFragment newInstance(String date, boolean cancelable, String senderId, Bundle bundle)
    {
        DatePickerDialogFragment frag = new DatePickerDialogFragment();
        Bundle args = new Bundle();
        args.putString("date", date);
        args.putBoolean("cancelable", cancelable);
        args.putString("senderId", senderId);
        args.putBundle("bundle", bundle);
        frag.setArguments(args);
        return frag;
    }

    public void setListener(DatePickerDialogFragmentListener listener) {
        this.listener = listener;
    }

    @Override public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        String date = getArguments().getString("date");
        if ((date == null) || (date.equalsIgnoreCase(""))) {
            date = getFriendlyDateNow();
        }
        String splitted[] = date.split("-");
        int dayOfMonth = Integer.parseInt(splitted[0]);
        int monthOfYear = Integer.parseInt(getMonthFromFriendly(splitted[1])) - 1;
        int year = Integer.parseInt(splitted[2]);

        final OnDateSetListener finalListener = this;

        final DatePickerDialog picker = new DatePickerDialog(getActivity(), getConstructorListener(), year, monthOfYear, dayOfMonth);

        //picker.setTitle(getActivity().getResources().getString(R.string.app_name));
        picker.setTitle("");
        picker.setIcon(R.drawable.logo_godok);
        picker.setCancelable(getArguments().getBoolean("cancelable"));

        if (hasJellyBeanAndAbove()) {
            picker.setButton(DialogInterface.BUTTON_POSITIVE, getActivity().getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        Field mDatePickerField;
                        mDatePickerField = dialog.getClass().getDeclaredField("mDatePicker");
                        mDatePickerField.setAccessible(true);
                        DatePicker dp = (DatePicker) mDatePickerField.get(dialog);
                        //DatePicker dp = picker.getDatePicker(); //API Level 8 Constraint
                        finalListener.onDateSet(dp, dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
                    } catch (Exception e) {
                        DialogUtil.alert(getActivity(), e.getMessage(), null, null, null);
                    }
                }
            });
            picker.setButton(DialogInterface.BUTTON_NEGATIVE, getActivity().getString(android.R.string.cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {}
            });
        }

        return picker;
    }

    @Override
    public void onAttach(android.app.Activity activity) {
        super.onAttach(activity);
        if (activity instanceof DatePickerDialogFragmentListener) {
            setListener((DatePickerDialogFragmentListener)activity);
        }
    }

    public void dismiss(FragmentManager manager)
    {
        DatePickerDialogFragment dialog = (DatePickerDialogFragment)manager.findFragmentByTag(dialogTag);
        if (dialog != null)
        {
            dialog.dismiss();
        }
    }

    @Override public void show(FragmentManager manager, String tag)
    {
        dialogTag = tag;
        super.show(manager, dialogTag);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(year, monthOfYear, dayOfMonth);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String value = df.format(c.getTime());
        if (listener != null) {
            listener.onDateSet(value, getArguments().getString("senderId"), getArguments().getBundle("bundle"));
        }
    }

    private static boolean hasJellyBeanAndAbove() {
        return Build.VERSION.SDK_INT >= 16; //Build.VERSION_CODES.JELLY_BEAN API Level 8 Constraint
    }

    private OnDateSetListener getConstructorListener() {
        return hasJellyBeanAndAbove() ? null : this;
    }

    public static String getFriendlyDate(String date) {
        String day = date.substring(0, 2);
        String month = getMonthFromValue(date.substring(2, 4));
        String year = date.substring(4);
        return day + "-" + month + "-" + year;
    }

    public static String getValueDate(String date) {
        String splitted[] = date.split("-");
        String monthValue = getMonthFromFriendly(splitted[1]);
        return splitted[0] + monthValue + splitted[2];
    }

    private static String getMonthFromValue(String month) {
        if (month.equals("01")) {
            return "Jan";
        } else if (month.equals("02")) {
            return "Feb";
        } else if (month.equals("03")) {
            return "Mar";
        } else if (month.equals("04")) {
            return "Apr";
        } else if (month.equals("05")) {
            return "May";
        } else if (month.equals("06")) {
            return "Jun";
        } else if (month.equals("07")) {
            return "Jul";
        } else if (month.equals("08")) {
            return "Aug";
        } else if (month.equals("09")) {
            return "Sep";
        } else if (month.equals("10")) {
            return "Oct";
        } else if (month.equals("11")) {
            return "Nov";
        } else if (month.equals("12")) {
            return "Dec";
        }
        return null;
    }

    private static String getMonthFromFriendly(String month) {
        Log.i("month", ""+month);
        if (month.equals("Jan")) {
            return "01";
        } else if (month.equals("Feb")) {
            return "02";
        } else if (month.equals("Mar")) {
            return "03";
        } else if (month.equals("Apr")) {
            return "04";
        } else if (month.equals("May") || month.equals("Mei")) {
            return "05";
        } else if (month.equals("Jun")) {
            return "06";
        } else if (month.equals("Jul")) {
            return "07";
        } else if (month.equals("Aug") || month.equals("Agt")) {
            return "08";
        } else if (month.equals("Sep")) {
            return "09";
        } else if (month.equals("Oct") || month.equals("Okt")) {
            return "10";
        } else if (month.equals("Nov") || month.equals("Nop")) {
            return "11";
        } else if (month.equals("Dec") || month.equals("Des")) {
            return "12";
        }
        return null;
    }

    public static String getFriendlyDateNow() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }
}


package com.maedi.user.godok.v1.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.util.Log;

public class ListMenu extends ArrayList<ListMenu>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public int imageIcon;
    public int imageIcon2;
    public int imageIcon3;
    public int imageIcon4;
    public int imageIcon5;
    public int editText;
    public String text;
    public String text2;
    public String text3;
    public String text4;
    public String text5;
    public String text6;
    public String text7;
    public String text8;
    public int page;
    public int position;
    public int p1;
	
	public boolean messageNotification;
	
	private Date dateTime;
	
	public ListMenu(){
        super();
    }
	
	public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date datetime) {
        this.dateTime = datetime;
    }
    
    public ListMenu (String text) {
    	super();
        this.text = text;
    }

    public ListMenu (int imageIcon) {
        super();
        this.imageIcon = imageIcon;
    }
    
    public ListMenu (String text, int imageIcon) {
    	super();
        this.text = text;
        this.imageIcon = imageIcon;
    }
    
    public ListMenu (String text, String text2) {
    	super();
        this.text = text;
        this.text2 = text2;
    }

    public ListMenu (String text, String text2, int position) {
        super();
        this.text = text;
        this.text2 = text2;
        this.position = position;
    }

    /*
    public ListMenu (String text, String text2, int imageIcon) {
    	super();
        this.text = text;
        this.text2 = text2;
        this.imageIcon = imageIcon;
    }
    */
    
    public ListMenu (String text, String text2, boolean messageNotification) {
    	super();
        this.text = text;
        this.text2 = text2;
        this.messageNotification = messageNotification;
    }
    
    public ListMenu (int imageIcon, String text) {
    	super();
    	this.imageIcon = imageIcon;
        this.text = text;
    }
    
    public ListMenu (String text, String text2, String text3) {
    	super();
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
        /*
        //2015-11-29 23:47:32.654
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try
        {
            Date date = simpleDateFormat.parse(text3);
            setDateTime(date);

            Log.i("date chat ==",""+simpleDateFormat.format(date));
        }
        catch (ParseException ex)
        {
            Log.i("ParseException",""+ex);
        }
        */
    }

    public ListMenu (int imageIcon, String text, String text2, String text3) {
        super();
        this.imageIcon = imageIcon;
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
    }

    public ListMenu (int imageIcon, String text, String text2, String text3, int p1) {
        super();
        this.imageIcon = imageIcon;
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
        this.p1 = p1;
    }

    public ListMenu (int imageIcon, String text, String text2, String text3, String text4) {
        super();
        this.imageIcon = imageIcon;
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
    }

    public ListMenu (int imageIcon, String text, String text2, String text3, String text4, String text5) {
        super();
        this.imageIcon = imageIcon;
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
    }

    public ListMenu (int imageIcon, String text, String text2, String text3, String text4,
                     String text5, String text6, String text7, String text8) {
        super();
        this.imageIcon = imageIcon;
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        this.text6 = text6;
        this.text7 = text7;
        this.text8 = text8;
    }
    
}

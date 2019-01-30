package com.n2w.inpa.prototype.SelectPeopleGoingView;

public class SelectPeopleGoingModel {

    final static public int HEADER = 0;
    final static public int PEOPLE_SUBTITLE = 1;
    final static public int ADULT_SELECT = 2;
    final static public int CHILD_SELECT = 3;
    final static public int JUNIOR_SELECT = 4;
    final static public int ROOM_SUBTITLE = 5;
    final static public int SINGLE_SELECT = 6;
    final static public int DOUBLE_SELECT = 7;
    final static public int FAMILY_SELECT = 8;
    final static public int NEXT_STEP_BTN = 9;

    String text;

    public SelectPeopleGoingModel(int type, String text)
    {
        this.text = text;
    }

}
